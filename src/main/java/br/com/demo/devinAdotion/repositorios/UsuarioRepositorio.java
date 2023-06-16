package br.com.demo.devinAdotion.repositorios;

import br.com.demo.devinAdotion.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    boolean existsByEmail(String email);

    Usuario findByEmail(String email);
}
