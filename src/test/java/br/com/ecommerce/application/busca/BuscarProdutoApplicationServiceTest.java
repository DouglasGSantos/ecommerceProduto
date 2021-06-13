package br.com.ecommerce.application.busca;

import static br.com.ecommerce.application.mock.ProdutoMock.getProduto;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.ecommerce.application.busca.response.ProdutoResponse;
import br.com.ecommerce.infrastructure.repository.ProdutoRepository;

class BuscarProdutoApplicationServiceTest {

	@InjectMocks
	BuscarProdutoApplicationService service = new BuscarProdutoApplicationService();

	@Mock
	private ProdutoRepository produtoRepository;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testGetProduto() {

		when(produtoRepository.findById(anyString())).thenReturn(Optional.of(getProduto()));

		ProdutoResponse response = service.getProduto("25");
		assertNotNull(response);
		assertNotNull(response.getCodigo());

		verify(produtoRepository, times(1)).findById(anyString());
	}

}
