package br.com.ecommerce.application.alteracao.request;

import javax.validation.constraints.NotBlank;

public class ProdutoAlteracaoRequest {
	
	@NotBlank
	private String codigo;
	@NotBlank
	private String nome;

	@NotBlank
	private String descricao;

	@NotBlank
	private String marca;

	@NotBlank
	private String urlImagem;

	public ProdutoAlteracaoRequest(@NotBlank String codigo, @NotBlank String nome, @NotBlank String descricao,
			@NotBlank String marca, @NotBlank String urlImagem) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.marca = marca;
		this.urlImagem = urlImagem;
	}

	public ProdutoAlteracaoRequest() {
		super();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

}
