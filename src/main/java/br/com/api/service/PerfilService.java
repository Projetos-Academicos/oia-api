package br.com.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.model.Perfil;
import br.com.api.repository.PerfilRepository;

@Service
public class PerfilService extends ServiceGenerico<Perfil, Long, PerfilRepository>{

	@Autowired
	private PerfilRepository perfilRepository;

	@Override
	public PerfilRepository getRepositorio() {
		return this.perfilRepository;
	}

	@Override
	Perfil persistirEntidade(Perfil model) {
		return this.perfilRepository.save(model);
	}

}
