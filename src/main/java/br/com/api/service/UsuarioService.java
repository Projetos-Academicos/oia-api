package br.com.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.model.Usuario;
import br.com.api.repository.UsuarioRepository;
import br.com.api.util.Utils;

@Service
public class UsuarioService {


	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario consultar(Long id) {
		return this.usuarioRepository.findOne(id);
	}

	public void salvar(Usuario usuario) {
		String senhaEncodada = Utils.encodarSenha(usuario.getSenha());
		usuario.setSenha(senhaEncodada);
		this.usuarioRepository.save(usuario);
	}
}
