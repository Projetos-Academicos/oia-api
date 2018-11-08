package br.com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	/*@Query("SELECT NEW Usuario(u.id, u.nome) FROM Usuario u JOIN Vaga v ON  WHERE ") //FAZER COM QUE RETORNE UMA LISTA DE USUARIOS POR ID DA VAGA.
	List<Usuario> listarUsuariosParticipandoDaVaga(Long idVaga);*/

}
