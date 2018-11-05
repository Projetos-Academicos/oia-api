package br.com.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.enums.StatusVagaEnum;
import br.com.api.model.Usuario;
import br.com.api.model.Vaga;
import br.com.api.repository.VagaRepository;

@Service
public class VagaService {

	@Autowired
	private VagaRepository vagaRepository;

	public Vaga consultar(Long id) {
		return this.vagaRepository.consultar(id);
	}

	public void inserirUsuarioSelecionado(Long id, Long idUsuario) {
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

	public void salvar(Vaga vaga) {
		this.vagaRepository.save(vaga);
	}


	public void salvarCandidatoNaVaga(Long idUsuario, Long idVaga) {
		Vaga vaga = this.consultar(idVaga);
		List<Usuario> candidato = new ArrayList<>();
		candidato.add(new Usuario(idUsuario));
		vaga.setUsuarioCandidatos(candidato);

		this.salvar(vaga);
	}
}
