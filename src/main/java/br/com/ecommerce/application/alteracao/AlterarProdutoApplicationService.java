package br.com.ecommerce.application.alteracao;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerce.application.alteracao.request.ProdutoAlteracaoRequest;
import br.com.ecommerce.domain.Produto;
import br.com.ecommerce.infrastructure.exception.types.BusinessException;
import br.com.ecommerce.infrastructure.repository.ProdutoRepository;

@Service
public class AlterarProdutoApplicationService {

	@Autowired
	private ProdutoRepository repository;

	public void executar(ProdutoAlteracaoRequest request) {

		validarProdutoNulo(request);
		
		Optional<Produto> findById = repository.findById(request.getCodigo());
		validarSeProdutoExiste(findById);
		
		Produto produto = findById.get();		
		alterarProdutoNaBase(request, produto);
		informarAlteracaoProduto(produto);
		
		

	}

	private void informarAlteracaoProduto(Produto produto) {
		// TODO criar metodo que informa ao kafka que o produto foi alterado
		
	}

	private void alterarProdutoNaBase(ProdutoAlteracaoRequest request, Produto produto) {
		BeanUtils.copyProperties(request, produto,"codigo");		
		produto.validar();
		
		repository.save(produto);
	}

	private void validarSeProdutoExiste(Optional<Produto> findById) {
		if(findById.isEmpty()) {
			throw new BusinessException("O código do produto informado não foi encontrado");
		}
	}

	private void validarProdutoNulo(ProdutoAlteracaoRequest request) {
		if (Objects.isNull(request)) {
			throw new BusinessException("O produto a ser alterado não pode ser nulo");
		}

	}
}
