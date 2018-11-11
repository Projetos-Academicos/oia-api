package br.com.api.model.arquitetura;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
public abstract class Model<ID extends Serializable> implements IEntidade<ID> {

	private static final long serialVersionUID = -2532439740056413084L;

	@Column(name = "ativo", nullable = false)
	private boolean ativo;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_inclusao", nullable = false)
	private Date dataInclusao;

	/*
	 * Getter's and Setter's
	 */
	public Date getDataInclusao() {
		return this.dataInclusao;
	}

	public boolean isAtivo() {
		return this.ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
}
