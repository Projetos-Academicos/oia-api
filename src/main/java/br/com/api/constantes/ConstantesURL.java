package br.com.api.constantes;

public class ConstantesURL {

	// ROTAS LIBERADAS
	public static final String CADASTRAR_USUARIO = "/cadastro-usuario";
	public static final String REALIZAR_LOGIN = "/login";

	// CARREGAR LISTAS
	public static final String LISTAR_CATEGORIAS = "/admin/listar-categorias";
	public static final String LISTAR_PROFISSAO = "/admin/listar-profissao";
	public static final String LISTAR_CIDADES = "/admin/listar-cidades";

	// VAGA
	public static final String CADASTRAR_VAGA = "/admin/cadastro-vaga";
	public static final String CONSULTAR_VAGA = "/admin/consultar-vaga/{idVaga}";
	public static final String PARTICIPAR_VAGA = "/admin/candidatar-se/{idUsuario}/{idVaga}";
	public static final String LISTAR_MINHAS_VAGAS = "/admin/minhas-vagas/{idUsuario}";
	public static final String INSERIR_CANDIDATO_SELECIONADO = "/admin/selecionar-candidato/{idUsuario}/{idVaga}";
	public static final String LISTAR_VAGAS = "/admin/listar-vagas/{idUsuario}";


}
