package br.com.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.constantes.ConstantesMessage;
import br.com.api.exception.ExceptionGeral;
import br.com.api.model.Usuario;
import br.com.api.model.Vaga;
import br.com.api.repository.UsuarioRepository;
import br.com.api.repository.VagaRepository;
import br.com.api.util.Utils;

@Service
public class UsuarioService extends ServiceGenerico<Usuario, Long, UsuarioRepository>{


	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private VagaRepository vagaRepository;

	public Usuario consultaSimplesPorId(Long id) {
		return this.usuarioRepository.consultaSimplesPorId(id);
	}

	public Usuario consultaSimplesPorLogin(String login) {
		return this.usuarioRepository.consultaSimplesPorLogin(login);
	}

	public Long countByLogin(String login) {
		return this.usuarioRepository.countByLogin(login);
	}

	@Override
	public UsuarioRepository getRepositorio() {
		return this.usuarioRepository;
	}

	public List<Usuario> listarUsuariosCandidatosVaga(Long idVaga){
		Vaga vaga = this.vagaRepository.findByAtivoAndId(true, idVaga);
		List<Usuario> usuariosCandidatos = new ArrayList<>();
		for (Usuario usuario : vaga.getUsuarioCandidatos()) {
			usuariosCandidatos.add(usuario);
		}
		return usuariosCandidatos;
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

	@Override
	public void validarUnicidade(Usuario model) throws ExceptionGeral {
		Long count = this.countByLogin(model.getLogin());
		if(count > 0) {
			if(model.getId() != null) {
				Usuario usuarioAux = this.consultaSimplesPorId(model.getId());
				if(!usuarioAux.getId().equals(model.getId())) {
					throw new ExceptionGeral(this.getMensagem(ConstantesMessage.ERRO_UNICIDADE_LOGIN_USUARIO));
				}
			}else {
				throw new ExceptionGeral(this.getMensagem(ConstantesMessage.ERRO_UNICIDADE_LOGIN_USUARIO));
			}
		}
	}
}
