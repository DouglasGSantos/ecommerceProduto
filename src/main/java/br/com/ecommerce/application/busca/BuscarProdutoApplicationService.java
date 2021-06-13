package br.com.ecommerce.application.busca;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerce.application.busca.response.ProdutoResponse;
import br.com.ecommerce.domain.Produto;
import br.com.ecommerce.infrastructure.exception.types.NoContentException;
import br.com.ecommerce.infrastructure.repository.ProdutoRepository;

@Service
public class BuscarProdutoApplicationService {

	@Autowired
	private ProdutoRepository repository;

	public ProdutoResponse getProduto(String codigo) {

		Optional<Produto> findById = repository.findById(codigo);
		if (findById.isEmpty()) {
			throw new NoContentException();
		}

		Produto produto = findById.get();

		ProdutoResponse response = new ProdutoResponse();
		BeanUtils.copyProperties(produto, response);

		return response;

	}

}
