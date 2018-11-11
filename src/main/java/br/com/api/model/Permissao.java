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
@Table(name = "permissao")
public class Permissao extends Model<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "descricao")
	private String descricao;

	/*
	 * Getter's and Setter's
	 */
	public String getDescricao() {
		return this.descricao;
	}
	@Override
	public Long getId() {
		return this.id;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}
}
