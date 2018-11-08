package br.com.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.model.Cidade;
import br.com.api.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepositoy;

	public Cidade consultar(Long id) {
		return this.cidadeRepositoy.findOne(id);
	}

	public List<Cidade> listar(){
		return this.cidadeRepositoy.listar();
	}

	public void salvar(Cidade cidade) {
		this.cidadeRepositoy.save(cidade);
	}

}
