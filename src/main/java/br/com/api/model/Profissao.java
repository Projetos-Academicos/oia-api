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

import br.com.api.model.arquitetura.Model;

@Entity
@Table(name = "profissao")
public class Profissao extends Model<Long>{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

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
	public Categoria getCategoria() {
		return this.categoria;
	}

	@Override
	public Long getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
