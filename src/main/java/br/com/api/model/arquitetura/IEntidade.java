package br.com.api.model.arquitetura;

import java.io.Serializable;

public interface IEntidade<ID extends Serializable> extends Serializable {

	public ID getId();
	public void setId(ID id);

}
