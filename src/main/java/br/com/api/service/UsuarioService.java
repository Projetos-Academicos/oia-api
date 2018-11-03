package br.com.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.model.Usuario;
import br.com.api.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario consultar(Long id) {
		return this.usuarioRepository.findOne(id);
	}

	public void salvar(Usuario usuario) {
		this.usuarioRepository.save(usuario);
	}
}
