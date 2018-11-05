package br.com.api.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.api.enums.StatusVagaEnum;

@Entity
@Table(name = "vaga")
public class Vaga {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "ativo")
	private Boolean ativo;

	@NotNull
	@Column(name = "titulo")
	private String titulo;

	@NotNull
	@Column(name = "descricao")
	private String descricao;

	@NotNull
	@Column(name = "orcamento")
	private Long orcamento;

	@NotNull
	@Column(name = "prazo")
	private Integer prazo;

	@Enumerated(EnumType.STRING)
	@Column(name = "status_vaga")
	private StatusVagaEnum statusVaga;

	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "usuario_vaga_id")
	private Usuario usuarioVaga;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "usuario_candidato_id")
	private Usuario usuarioCandidatoSelecionado;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "candidatos_vagas", joinColumns = {@JoinColumn(name = "candidato_id") }, inverseJoinColumns = {@JoinColumn(name = "vaga_id") })
	private List<Usuario> usuarioCandidatos;

	/*
	 * Construtores
	 */

	public Vaga() {

	}

	public Vaga(Long id, Boolean ativo) {
		this.setId(id);
		this.setAtivo(ativo);
	}

	/**
	 * listarVagasAbertasParaCandidatos
	 *
	 *  @param id
	 *  @param ativo
	 *  @param titulo
	 *  @param descricao
	 *  @param orcamento
	 *  @param prazo
	 *  @param idCategoria
	 *  @param nomeCateogria
	 *  @param idUsuario
	 *  @param nomeUsuario
	 */
	public Vaga(Long id, Boolean ativo, String titulo, String descricao, Long orcamento, Integer prazo, Long idCategoria, String nomeCateogria, Long idUsuario, String nomeUsuario) {
		this.setId(id);
		this.setAtivo(ativo);
		this.setTitulo(titulo);
		this.setDescricao(descricao);
		this.setOrcamento(orcamento);
		this.setPrazo(prazo);
		this.setCategoria(new Categoria(idCategoria, nomeCateogria));
		this.setUsuarioVaga(new Usuario(idUsuario, nomeUsuario));
	}

	/**
	 * listarVagasPorIdUsuario
	 * consultar
	 *
	 *  @param id
	 *  @param ativo
	 *  @param titulo
	 *  @param descricao
	 *  @param orcamento
	 *  @param prazo
	 *  @param status
	 *  @param idCategoria
	 *  @param nomeCategoria
	 *  @param idUsuario
	 *  @param nomeUsuario
	 */
	public Vaga(Long id, Boolean ativo, String titulo, String descricao, Long orcamento, Integer prazo, StatusVagaEnum status, Long idCategoria, String nomeCategoria, Long idUsuario, String nomeUsuario) {
		this.setId(id);
		this.setAtivo(ativo);
		this.setTitulo(titulo);
		this.setDescricao(descricao);
		this.setOrcamento(orcamento);
		this.setPrazo(prazo);
		this.setStatusVaga(status);
		this.setCategoria(new Categoria(idCategoria, nomeCategoria));
		this.setUsuarioVaga(new Usuario(idUsuario, nomeUsuario));
	}


	/*
	 *	Getter's and Setter's
	 */

	public Boolean getAtivo() {
		if(this.ativo == null) {
			this.ativo = true;
		}
		return this.ativo;
	}
	public Categoria getCategoria() {
		return this.categoria;
	}
	public String getDescricao() {
		return this.descricao;
	}
	public Long getId() {
		return this.id;
	}
	public Long getOrcamento() {
		return this.orcamento;
	}
	public Integer getPrazo() {
		return this.prazo;
	}
	public StatusVagaEnum getStatusVaga() {
		return this.statusVaga;
	}
	public String getTitulo() {
		return this.titulo;
	}
	public List<Usuario> getUsuarioCandidatos() {
		return this.usuarioCandidatos;
	}
	public Usuario getUsuarioCandidatoSelecionado() {
		return this.usuarioCandidatoSelecionado;
	}
	public Usuario getUsuarioVaga() {
		return this.usuarioVaga;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setOrcamento(Long orcamento) {
		this.orcamento = orcamento;
	}
	public void setPrazo(Integer prazo) {
		this.prazo = prazo;
	}
	public void setStatusVaga(StatusVagaEnum statusVaga) {
		this.statusVaga = statusVaga;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setUsuarioCandidatos(List<Usuario> usuarioCandidatos) {
		this.usuarioCandidatos = usuarioCandidatos;
	}
	public void setUsuarioCandidatoSelecionado(Usuario usuarioCandidatoSelecionado) {
		this.usuarioCandidatoSelecionado = usuarioCandidatoSelecionado;
	}
	public void setUsuarioVaga(Usuario usuarioVaga) {
		this.usuarioVaga = usuarioVaga;
	}


}
