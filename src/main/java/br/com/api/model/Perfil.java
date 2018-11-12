package br.com.api.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.api.model.arquitetura.Model;

@Entity
@Table(name = "perfil")
public class Perfil extends Model<Long>{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "nome")
	private String nome;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "perfil_permissao", joinColumns = {@JoinColumn(name = "perfil_id") }, inverseJoinColumns = {@JoinColumn(name = "permissao_id") })
	private List<Permissao> permissoes;

	/*
	 * Construtores
	 */

	public Perfil() {

	}

	public Perfil(Long id) {
		this.setId(id);
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

	public List<Permissao> getPermissoes() {
		return this.permissoes;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

}
