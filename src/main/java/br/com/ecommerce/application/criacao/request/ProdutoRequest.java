package br.com.ecommerce.application.criacao.request;

import javax.validation.constraints.NotBlank;

public class ProdutoRequest {

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

	public ProdutoRequest(String codigo, String nome, String descricao, String marca, String urlImagem) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.marca = marca;
		this.urlImagem = urlImagem;
	}

	public ProdutoRequest() {
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
