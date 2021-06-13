package br.com.ecommerce.application.criacao;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.com.ecommerce.application.criacao.request.ProdutoRequest;
import br.com.ecommerce.domain.Produto;
import br.com.ecommerce.infrastructure.exception.types.BusinessException;
import br.com.ecommerce.infrastructure.repository.ProdutoRepository;

@Service
public class CriarProdutoApplicationService {

	@Autowired
	private ProdutoRepository repository;

	@Autowired
	private KafkaTemplate<String, Produto> kafkaTemplate;

	public void executar(ProdutoRequest request) {

		validarProdutoNulo(request);
		validarSeProdutoJaExiste(request);

		Produto produto = new Produto();
		validarDadosProduto(request, produto);

		repository.save(produto);

		informarCriacaoProduto(produto);

	}

	private void validarSeProdutoJaExiste(ProdutoRequest request) {

		Optional<Produto> findById = repository.findById(request.getCodigo());
		if (findById.isPresent()) {
			throw new BusinessException("Já existe um produto com este código");
		}
	}

	private void informarCriacaoProduto(Produto produto) {
		kafkaTemplate.send("ECOMMERCE_PRODUTO_NOVO", produto);

	}

	private void validarDadosProduto(ProdutoRequest request, Produto produto) {
		BeanUtils.copyProperties(request, produto);
		produto.validar();
	}

	private void validarProdutoNulo(ProdutoRequest request) {
		if (Objects.isNull(request)) {
			throw new BusinessException("o produto não pode ser nulo");
		}
	}

}
