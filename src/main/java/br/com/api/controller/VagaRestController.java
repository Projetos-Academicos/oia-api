package br.com.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.constantes.ConstantesURL;
import br.com.api.model.Vaga;
import br.com.api.service.VagaService;

@RestController
public class VagaRestController {

	@Autowired
	private VagaService vagaService;

	@PostMapping(value = ConstantesURL.CADASTRAR_VAGA)
	public void cadastrar(@Valid @RequestBody Vaga vaga, HttpServletResponse response) {
		this.vagaService.salvar(vaga);
	}

	@GetMapping(value = ConstantesURL.CONSULTAR_VAGA)
	public Vaga consultar(@PathVariable Long idVaga) {
		return this.vagaService.consultar(idVaga);
	}

	@PostMapping(value = ConstantesURL.INSERIR_CANDIDATO_SELECIONADO)
	public void inserirCandidatoSelecionado(@PathVariable Long idVaga, @RequestBody Long idUsuario) {
		this.vagaService.inserirUsuarioSelecionado(idVaga, idUsuario);
	}

	@GetMapping(value = ConstantesURL.LISTAR_VAGAS)
	public List<Vaga> listarOias(@PathVariable Long idUsuario){
		return this.vagaService.listarVagasAbertasParaCandidatos(idUsuario);
	}

	@GetMapping(value = ConstantesURL.LISTAR_MINHAS_VAGAS)
	public List<Vaga> minhasVagas(@PathVariable Long idUsuario){
		return this.vagaService.listarVagasPorIdUsuario(idUsuario);
	}

}
