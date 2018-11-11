package br.com.api.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.constantes.ConstantesURL;
import br.com.api.exception.ExceptionGeral;
import br.com.api.model.Usuario;
import br.com.api.service.UsuarioService;

@RestController
public class UsuarioRestController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping(value = ConstantesURL.CADASTRAR_USUARIO)
	public String cadastrar(@Valid @RequestBody Usuario usuario, HttpServletResponse response) throws ExceptionGeral {
		this.usuarioService.salvar(usuario);
		return "USUARIO CADASTRADO COM SUCESSO";
	}

}
