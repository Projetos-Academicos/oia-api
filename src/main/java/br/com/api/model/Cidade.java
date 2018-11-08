package br.com.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cidade")
public class Cidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "nome")
	private String nome;

	@NotNull
	@Column(name = "ativo")
	private Boolean ativo;

	@NotNull
	@Column(name = "estado")
	private String estado;

	/*
	 * Construtores
	 */

	public Cidade() {

	}

	public Cidade(Long id) {
		this.setId(id);
	}

	public Cidade(Long id, String nome, String estado) {
		this.setId(id);
		this.setNome(nome);
		this.setEstado(estado);
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

	public String getEstado() {
		return this.estado;
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
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
