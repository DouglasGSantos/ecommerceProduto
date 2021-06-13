package br.com.ecommerce.application.alteracao;

import static br.com.ecommerce.application.mock.ProdutoMock.getProduto;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.ecommerce.application.alteracao.request.ProdutoAlteracaoRequest;
import br.com.ecommerce.infrastructure.repository.ProdutoRepository;

class AlterarProdutoApplicationServiceTest {

	@InjectMocks
	AlterarProdutoApplicationService service = new AlterarProdutoApplicationService();

	@Mock
	private ProdutoRepository produtoRepository;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testExecutar() {

		when(produtoRepository.findById(any())).thenReturn(Optional.of(getProduto()));
		when(produtoRepository.save(any())).thenReturn(getProduto());

		service.executar(getRequest());
		
		verify(produtoRepository,times(1)).findById(any());
		verify(produtoRepository,times(1)).save(any());

	}
	
	
	

	private ProdutoAlteracaoRequest getRequest() {
		ProdutoAlteracaoRequest request = new ProdutoAlteracaoRequest();
		request.setCodigo("1");
		request.setDescricao("teste");
		request.setMarca("teste");
		request.setNome("teste");
		request.setUrlImagem("teste.jpg");
		return request;
	}

}
