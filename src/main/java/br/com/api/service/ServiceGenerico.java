package br.com.api.service;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.transaction.annotation.Transactional;

import br.com.api.constantes.ConstantesMessage;
import br.com.api.exception.ExceptionGeral;
import br.com.api.model.arquitetura.Model;
import br.com.api.repository.arquitetura.RepositorioGenerico;

public abstract class ServiceGenerico<ENTIDADE extends Model<ID>, ID extends Serializable, REPOSITORIO extends RepositorioGenerico<ENTIDADE, ID>> {

	protected static final Logger log = LoggerFactory.getLogger(ServiceGenerico.class);

	@Autowired
	private MessageSource messageSource;

	@Transactional(readOnly = true)
	public ENTIDADE consultar(ID id) {
		return this.getRepositorio().findByAtivoAndId(true, id);
	}

	@Transactional(rollbackFor=Exception.class)
	public void exlcuir(ENTIDADE model) throws ExceptionGeral {
		this.validarExclusao(model);
		this.resolverPreExcluir(model);
		ENTIDADE entidade = this.consultar(model.getId());
		entidade.setAtivo(false);

		this.salvarSemDependenciasSemValidacao(model);
		this.resolverPosExcluir(model);
	}

	public String getMensagem(String key) {
		return this.messageSource.getMessage(key, null, new Locale("pt", "BR"));
	}

	public String getMensagem(String key, String... parametros) {
		return this.messageSource.getMessage(key, parametros, new Locale("pt", "BR"));
	}

	public abstract REPOSITORIO getRepositorio();

	public List<ENTIDADE> listar() {
		return this.getRepositorio().findByAtivo(true);
	}

	abstract ENTIDADE persistirEntidade(ENTIDADE model);

	public void resolverPosDependencias(ENTIDADE model) throws ExceptionGeral {
	}

	public void resolverPosExcluir(ENTIDADE model) throws ExceptionGeral {
	}

	public void resolverPreDependencias(ENTIDADE model) throws ExceptionGeral {
	}
	public void resolverPreExcluir(ENTIDADE model) throws ExceptionGeral {
	}

	@Transactional(rollbackFor = Exception.class)
	public void salvar(ENTIDADE model) throws ExceptionGeral {
		if(model.getId() == null) {
			this.validarInclusao(model);
		}else{
			this.validarAlteracao(model);
		}

		this.validarUnicidade(model);
		this.resolverPreDependencias(model);
		ENTIDADE modelBanco = this.salvarEntidade(model);
		model.setId(modelBanco.getId());
		this.resolverPosDependencias(model);
	}


	protected ENTIDADE salvarEntidade(ENTIDADE model) throws ExceptionGeral {
		if(model.getId() == null) {
			model.setDataInclusao(Calendar.getInstance().getTime());
			model.setAtivo(true);
		}

		ENTIDADE modelBanco = null;
		try {
			modelBanco = this.persistirEntidade(model);
		} catch (ObjectOptimisticLockingFailureException e) {
			e.printStackTrace();
			throw new ExceptionGeral(this.getMensagem(ConstantesMessage.ENTIDADE_ALTERADA_OUTRO_USUARIO));
		}

		return modelBanco;
	}

	@Transactional(rollbackFor = Exception.class)
	public void salvarSemDependenciasSemValidacao(ENTIDADE model) throws ExceptionGeral {
		ENTIDADE modelBanco = this.salvarEntidade(model);
		model.setId(modelBanco.getId());
	}

	public void validarAlteracao(ENTIDADE model) throws ExceptionGeral {
	}

	public void validarExclusao(ENTIDADE model) throws ExceptionGeral {
	}

	public void validarInclusao(ENTIDADE model) throws ExceptionGeral {
	}

	public void validarUnicidade(ENTIDADE model) throws ExceptionGeral {
	}
}
