package br.com.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.model.Cidade;
import br.com.api.repository.CidadeRepository;

@Service
public class CidadeService extends ServiceGenerico<Cidade, Long, CidadeRepository> {

	@Autowired
	private CidadeRepository cidadeRepositoy;

	@Override
	public CidadeRepository getRepositorio() {
		return this.cidadeRepositoy;
	}

	@Override
	Cidade persistirEntidade(Cidade model) {
		return this.cidadeRepositoy.save(model);
	}




}
