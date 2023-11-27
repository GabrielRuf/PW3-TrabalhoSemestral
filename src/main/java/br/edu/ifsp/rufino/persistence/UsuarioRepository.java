package br.edu.ifsp.rufino.persistence;

import br.edu.ifsp.rufino.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
    UserDetails findByLogin(String username);
}