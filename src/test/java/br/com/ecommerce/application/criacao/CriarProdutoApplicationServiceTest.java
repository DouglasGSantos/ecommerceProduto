package br.com.ecommerce.application.criacao;

import static br.com.ecommerce.application.mock.ProdutoMock.getProduto;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.ecommerce.application.criacao.request.ProdutoRequest;
import br.com.ecommerce.infrastructure.exception.types.BusinessException;
import br.com.ecommerce.infrastructure.repository.ProdutoRepository;

class CriarProdutoApplicationServiceTest {

	@InjectMocks
	private CriarProdutoApplicationService service = new CriarProdutoApplicationService();

	@Mock
	private ProdutoRepository produtoRepository;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testExecutar() {

		when(produtoRepository.save(any())).thenReturn(getProduto());
		ProdutoRequest request = getProdutoRequest();
		service.executar(request);
		verify(produtoRepository, times(1)).save(any());

	}

	@Test
	void testExecutarComRequestInvalido() {

		ProdutoRequest request = new ProdutoRequest();

		try {
			service.executar(request);

			fail("era esperado um erro");
		} catch (BusinessException e) {
			assertNotNull(e.getMessage());
		}
		verify(produtoRepository, never()).save(any());

	}

	@Test
	void testExecutarComProdutoNulo() {

		try {
			service.executar(null);
			fail("era esperado um erro");
		} catch (BusinessException e) {
			assertNotNull(e.getMessage());
		}
		verify(produtoRepository, never()).save(any());

	}

	
	private ProdutoRequest getProdutoRequest() {
		ProdutoRequest request = new ProdutoRequest();
		request.setCodigo("1");
		request.setDescricao("teste");
		request.setMarca("teste");
		request.setNome("teste");
		request.setUrlImagem("teste.jpg");
		return request;
	}

}
