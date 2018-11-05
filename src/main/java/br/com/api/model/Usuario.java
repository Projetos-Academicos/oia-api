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
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "ativo")
	private Boolean ativo;

	@NotNull
	@Column(name = "login")
	private String login;

	@NotNull
	@Column(name = "senha")
	private String senha;

	@NotNull
	@Column(name = "nome")
	private String nome;

	@NotNull
	@Column(name = "contato")
	private String contato;

	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "profissao_id")
	private Profissao profissao;

	/*
	 * Construtores
	 */

	public Usuario() {

	}

	public Usuario(Long id) {
		this.setId(id);
	}
	public Usuario(Long id, Boolean ativo) {
		this.setId(id);
		this.setAtivo(ativo);
	}

	public Usuario(Long id, String nome) {
		this.setId(id);
		this.setNome(nome);
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
	public String getContato() {
		return this.contato;
	}
	public Long getId() {
		return this.id;
	}
	public String getLogin() {
		return this.login;
	}
	public String getNome() {
		return this.nome;
	}
	public Profissao getProfissao() {
		return this.profissao;
	}
	public String getSenha() {
		return this.senha;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
