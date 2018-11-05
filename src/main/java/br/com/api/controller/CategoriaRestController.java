package br.com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.constantes.ConstantesURL;
import br.com.api.model.Categoria;
import br.com.api.service.CategoriaService;

@RestController
public class CategoriaRestController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping(value = ConstantesURL.LISTAR_CATEGORIAS)
	public List<Categoria> listar(){
		return this.categoriaService.listar();
	}


}
