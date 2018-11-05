package br.com.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.model.Profissao;
import br.com.api.repository.ProfissaoRepository;

@Service
public class ProfissaoService {

	@Autowired
	private ProfissaoRepository profissaoRepository;

	public List<Profissao> listar(){
		return this.profissaoRepository.listar();
	}
}
