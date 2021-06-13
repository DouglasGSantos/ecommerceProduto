package br.com.ecommerce.application.mock;

import br.com.ecommerce.domain.Produto;

public class ProdutoMock {
	
	public static Produto getProduto() {
		Produto produto = new Produto();
		produto.setCodigo("1");
		produto.setDescricao("teste");
		produto.setMarca("teste");
		produto.setNome("teste");
		produto.setUrlImagem("teste");
		return produto;
	}

}
