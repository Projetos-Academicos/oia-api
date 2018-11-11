package br.com.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.exception.ExceptionGeral;
import br.com.api.model.Usuario;
import br.com.api.repository.UsuarioRepository;
import br.com.api.util.Utils;

@Service
public class UsuarioService extends ServiceGeneric<Usuario, Long, UsuarioRepository>{


	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UsuarioRepository getRepositorio() {
		return this.usuarioRepository;
	}

	@Override
	Usuario persistirEntidade(Usuario model) {
		return this.usuarioRepository.save(model);
	}

	@Override
	public void validarInclusao(Usuario model) throws ExceptionGeral {
		String senhaEncodada = Utils.encodarSenha(model.getSenha());
		model.setSenha(senhaEncodada);
	}
}
