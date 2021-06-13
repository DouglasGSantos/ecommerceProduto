package br.com.ecommerce.application.busca.response;

public class ProdutoResponse {

	private String codigo;
	private String nome;
	private String descricao;
	private String marca;
	private String urlImagem;

	public ProdutoResponse(String codigo, String nome, String descricao, String marca, String urlImagem) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.marca = marca;
		this.urlImagem = urlImagem;
	}

	public ProdutoResponse() {
		super();
		// TODO Auto-generated constructor stub
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
