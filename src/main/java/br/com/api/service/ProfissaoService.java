package br.com.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.model.Profissao;
import br.com.api.repository.ProfissaoRepository;

@Service
public class ProfissaoService extends ServiceGeneric<Profissao, Long, ProfissaoRepository> {

	@Autowired
	private ProfissaoRepository profissaoRepository;

	@Override
	public ProfissaoRepository getRepositorio() {
		return this.profissaoRepository;
	}

	@Override
	Profissao persistirEntidade(Profissao model) {
		return this.profissaoRepository.save(model);
	}

}
