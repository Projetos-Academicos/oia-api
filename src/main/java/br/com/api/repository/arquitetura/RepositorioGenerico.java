package br.com.api.repository.arquitetura;

import java.io.Serializable;
import java.util.List;

import br.com.api.model.arquitetura.Model;

public interface RepositorioGenerico<ENTIDADE extends Model<ID>, ID extends Serializable> {

	List<ENTIDADE> findByAtivo(boolean ativo);

	ENTIDADE findByAtivoAndId(boolean ativo, ID id);
}
