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
@Table(name = "categoria")
public class Categoria extends Model<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

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
	public Categoria(Long id, String nome) {
		this.setId(id);
		this.setNome(nome);
	}

	/*
	 * Getter's and Setter's
	 */

	@Override
	public Long getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
