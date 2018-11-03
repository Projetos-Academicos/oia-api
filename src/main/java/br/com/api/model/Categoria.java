package br.com.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "ativo")
	private Boolean ativo;

	@NotNull
	@Column(name = "nome")
	private String nome;

	/*
	 * Construtores
	 */

	public Categoria() {


	}
	public Categoria(Long id) {
		this.setId(id);
	}
	public Categoria(Long id, Boolean ativo) {
		this.setId(id);
		this.setAtivo(ativo);
	}

	/*
	 * Getter's and Setter's
	 */

	public Boolean getAtivo() {
		if(this.ativo == null) {
			this.ativo = true;
		}
		return this.ativo;
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

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
