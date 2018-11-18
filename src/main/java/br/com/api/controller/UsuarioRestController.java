package br.com.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.constantes.Constantes;
import br.com.api.constantes.ConstantesMessage;
import br.com.api.constantes.ConstantesURL;
import br.com.api.exception.ExceptionGeral;
import br.com.api.model.Perfil;
import br.com.api.model.Usuario;
import br.com.api.service.PerfilService;
import br.com.api.service.UsuarioService;

@RestController
public class UsuarioRestController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private PerfilService perfilService;

	@PostMapping(value = ConstantesURL.CADASTRAR_USUARIO)
	public String cadastrar(@Valid @RequestBody Usuario usuario, HttpServletResponse response) {

		String retorno = ConstantesMessage.OPERACAO_REALIZADA_SUCESSO;

		List<Perfil> perfis = this.perfilService.listar();
		for (Perfil perfil : perfis) {
			if(perfil.getNome().equals(Constantes.USUARIO)) {
				usuario.setPerfil(new Perfil(perfil.getId()));
			}
		}
		try {

			this.usuarioService.salvar(usuario);

		} catch (ExceptionGeral e) {
			e.printStackTrace();
			retorno = e.getMessage();
		}

		return retorno;
	}

	@PreAuthorize(Constantes.PERMISSAO + "('" + Constantes.CONSULTAR_USUARIO +"')")
	@GetMapping(value = ConstantesURL.CONSULTAR_USUARIO)
	public Usuario consultar(@PathVariable Long id) {
		return this.usuarioService.consultar(id);
	}

	@PreAuthorize(Constantes.PERMISSAO + "('" + Constantes.ALTERAR_VAGA +"')")
	@GetMapping(value = ConstantesURL.LISTAR_CANDIDATOS_VAGA)
	public List<Usuario> listarUsuariosCandidatosVaga(@PathVariable Long idVaga){
		return this.usuarioService.listarUsuariosCandidatosVaga(idVaga);
	}

}
