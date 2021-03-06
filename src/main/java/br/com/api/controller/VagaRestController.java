package br.com.api.controller;

import java.util.List;

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
import br.com.api.model.Vaga;
import br.com.api.service.VagaService;

@RestController
public class VagaRestController {

	@Autowired
	private VagaService vagaService;

	@PreAuthorize(Constantes.PERMISSAO + "('" + Constantes.CADASTRAR_VAGA +"')")
	@PostMapping(value = ConstantesURL.CADASTRAR_VAGA)
	public String cadastrar(@Valid @RequestBody Vaga vaga) throws ExceptionGeral {

		this.vagaService.salvar(vaga);
		return ConstantesMessage.OPERACAO_REALIZADA_SUCESSO;
	}

	@PreAuthorize(Constantes.PERMISSAO + "('" + Constantes.CONSULTAR_VAGA +"')")
	@GetMapping(value = ConstantesURL.CONSULTAR_VAGA)
	public Vaga consultar(@PathVariable Long idVaga) {
		return this.vagaService.consultar(idVaga);
	}

	@PreAuthorize(Constantes.PERMISSAO + "('" + Constantes.ALTERAR_VAGA +"')")
	@PostMapping(value = ConstantesURL.INSERIR_CANDIDATO_SELECIONADO)
	public void inserirCandidatoSelecionado(@PathVariable Long idUsuario, @PathVariable Long idVaga) throws ExceptionGeral {
		this.vagaService.inserirUsuarioSelecionado(idVaga, idUsuario);
	}

	@PreAuthorize(Constantes.PERMISSAO + "('" + Constantes.CONSULTAR_VAGA +"')")
	@GetMapping(value = ConstantesURL.LISTAR_VAGAS)
	public List<Vaga> listarOias(@PathVariable Long idUsuario){
		return this.vagaService.listarVagasAbertasParaCandidatos(idUsuario);
	}

	@PreAuthorize(Constantes.PERMISSAO + "('" + Constantes.CONSULTAR_VAGA +"')")
	@GetMapping(value = ConstantesURL.LISTAR_MINHAS_VAGAS)
	public List<Vaga> minhasVagas(@PathVariable Long idUsuario){
		return this.vagaService.listarVagasPorIdUsuario(idUsuario);
	}

	@PreAuthorize(Constantes.PERMISSAO + "('" + Constantes.PARTICIPAR_VAGA +"')")
	@PostMapping(value = ConstantesURL.PARTICIPAR_VAGA)
	public void secandidatar(@PathVariable Long idUsuario, @PathVariable Long idVaga) throws ExceptionGeral {
		this.vagaService.salvarCandidatoNaVaga(idUsuario, idVaga);
	}

}
