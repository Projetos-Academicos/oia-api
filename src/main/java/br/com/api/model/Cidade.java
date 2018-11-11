package br.com.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.api.model.arquitetura.Model;

@Entity
@Table(name = "cidade")
public class Cidade extends Model<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "nome")
	private String nome;

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

	public String getEstado() {
		return this.estado;
	}
	@Override
	public Long getId() {
		return this.id;
	}
	public String getNome() {
		return this.nome;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
