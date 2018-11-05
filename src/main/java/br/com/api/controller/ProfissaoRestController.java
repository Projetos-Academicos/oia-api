package br.com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.constantes.ConstantesURL;
import br.com.api.model.Profissao;
import br.com.api.service.ProfissaoService;

@RestController
public class ProfissaoRestController {

	@Autowired
	private ProfissaoService profissaoService;

	@GetMapping(value = ConstantesURL.LISTAR_PROFISSAO)
	public List<Profissao> listar(){
		return this.profissaoService.listar();
	}
}
