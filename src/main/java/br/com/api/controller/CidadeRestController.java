package br.com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.constantes.Constantes;
import br.com.api.constantes.ConstantesURL;
import br.com.api.model.Cidade;
import br.com.api.service.CidadeService;

@RestController
public class CidadeRestController {

	@Autowired
	private CidadeService cidadeService;

	@PreAuthorize(Constantes.PERMISSAO + "('" + Constantes.CARREGAR_LISTAS +"')")
	@GetMapping(value = ConstantesURL.LISTAR_CIDADES)
	public List<Cidade> listar(){
		return this.cidadeService.listar();
	}
}
