package br.com.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.model.Permissao;
import br.com.api.repository.PermissaoRepository;

@Service
public class PermissaoService extends ServiceGeneric<Permissao, Long, PermissaoRepository> {

	@Autowired
	private PermissaoRepository permissaoRepository;

	@Override
	public PermissaoRepository getRepositorio() {
		return this.permissaoRepository;
	}

	@Override
	Permissao persistirEntidade(Permissao model) {
		return this.permissaoRepository.save(model);
	}

}
