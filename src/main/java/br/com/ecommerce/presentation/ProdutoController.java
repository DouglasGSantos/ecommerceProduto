package br.com.ecommerce.presentation;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.application.alteracao.AlterarProdutoApplicationService;
import br.com.ecommerce.application.alteracao.request.ProdutoAlteracaoRequest;
import br.com.ecommerce.application.busca.BuscarProdutoApplicationService;
import br.com.ecommerce.application.busca.response.ProdutoResponse;
import br.com.ecommerce.application.criacao.CriarProdutoApplicationService;
import br.com.ecommerce.application.criacao.request.ProdutoRequest;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private CriarProdutoApplicationService criarProdutoService;

	@Autowired
	private AlterarProdutoApplicationService alterarProdutoService;

	@Autowired
	private BuscarProdutoApplicationService buscarProdutoService;

	@PostMapping("/")
	public ResponseEntity<Void> criarProduto(@RequestBody @Valid ProdutoRequest request) {

		criarProdutoService.executar(request);

		return ResponseEntity.ok().build();
	}

	@PutMapping("/")
	public ResponseEntity<Void> alterarProduto(@RequestBody @Valid ProdutoAlteracaoRequest request) {

		alterarProdutoService.executar(request);

		return ResponseEntity.ok().build();
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<ProdutoResponse> getProduto(@PathVariable("codigo") String codigo) {

		ProdutoResponse produto = buscarProdutoService.getProduto(codigo);

		return ResponseEntity.ok(produto);

	}

}
