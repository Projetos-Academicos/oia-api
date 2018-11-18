package br.com.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.enums.StatusVagaEnum;
import br.com.api.exception.ExceptionGeral;
import br.com.api.model.Usuario;
import br.com.api.model.Vaga;
import br.com.api.repository.UsuarioRepository;
import br.com.api.repository.VagaRepository;
import br.com.api.util.Utils;

@Service
public class VagaService extends ServiceGenerico<Vaga, Long, VagaRepository> {

	@Autowired
	private VagaRepository vagaRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public VagaRepository getRepositorio() {
		return this.vagaRepository;
	}

	public void inserirUsuarioSelecionado(Long id, Long idUsuario) throws ExceptionGeral {
		Vaga vaga = this.consultar(id);
		vaga.setUsuarioCandidatoSelecionado(new Usuario(idUsuario));
		vaga.setStatusVaga(StatusVagaEnum.PREENCHIDA);

		this.salvar(vaga);
	}

	public List<Vaga> listarVagasAbertasParaCandidatos(Long idUsuario){
		return this.vagaRepository.listarVagasAbertasParaCandidatos(idUsuario);
	}

	public List<Vaga> listarVagasPorIdUsuario(Long idUsuario){
		return this.vagaRepository.listarVagasPorIdUsuario(idUsuario);
	}

	@Override
	Vaga persistirEntidade(Vaga model) {
		return this.vagaRepository.save(model);
	}

	public void salvarCandidatoNaVaga(Long idUsuario, Long idVaga) throws ExceptionGeral {
		Vaga vaga = this.consultar(idVaga);
		List<Usuario> candidato = new ArrayList<>();
		candidato.add(new Usuario(idUsuario));
		vaga.setUsuarioCandidatos(candidato);

		this.salvar(vaga);
	}

	@Override
	public void validarInclusao(Vaga model) throws ExceptionGeral {
		if(model.getStatusVaga() == null) {
			model.setStatusVaga(StatusVagaEnum.ABERTA);
		}
		if(model.getUsuarioVaga() == null) {
			Usuario usuarioVaga = this.usuarioRepository.consultaSimplesPorLogin(Utils.getLoginUsuarioLogado());
			model.setUsuarioVaga(usuarioVaga);
		}
	}
}
