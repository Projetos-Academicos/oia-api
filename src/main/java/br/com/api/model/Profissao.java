package br.com.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "profissao")
public class Profissao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "ativo")
	private Boolean ativo;

	@NotNull
	@Column(name = "nome")
	private String nome;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	/*
	 * Construtores
	 */

	public Profissao() {

	}
	public Profissao(Long id) {
		this.setId(id);
	}
	public Profissao(Long id, Boolean ativo) {
		this.setId(id);
		this.setAtivo(ativo);
	}

	/**
	 * listar
	 *
	 * @param id
	 * @param nome
	 */
	public Profissao(Long id, String nome) {
		this.setId(id);
		this.setNome(nome);
	}

	/*
	 * Getter's and Setter's
	 */
	public Boolean getAtivo() {
		if (this.ativo == null) {
			this.ativo = true;
		}
		return this.ativo;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public Long getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
