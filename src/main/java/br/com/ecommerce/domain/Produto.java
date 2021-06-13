package br.com.ecommerce.domain;

import static br.com.ecommerce.utils.EcommerceStringUtils.isBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.ecommerce.infrastructure.exception.dto.MessageDto;
import br.com.ecommerce.infrastructure.exception.types.BusinessException;

@Document(collection = "produtos")
public class Produto {

	@Id
	private String codigo;
	private String nome;
	private String descricao;
	private String marca;
	private String urlImagem;

	private boolean ativo;

	public Produto(String codigo, String nome, String descricao, String marca, String urlImagem, boolean ativo) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.marca = marca;
		this.urlImagem = urlImagem;
		this.ativo = ativo;
	}

	public Produto() {
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

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public void validar() {
		MessageDto message = new MessageDto();
		if (isBlank(codigo)) {
			message.addAdditionalMessages("o campo código não pode ser em branco");
		}

		if (isBlank(descricao)) {
			message.addAdditionalMessages("o campo descricao não pode ser em branco");
		}

		if (isBlank(nome)) {
			message.addAdditionalMessages("o nome descricao não pode ser em branco");
		}

		if (message.containsErrors()) {
			throw new BusinessException("erro", message);
		}

	}

}
