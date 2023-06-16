package br.com.demo.devinAdotion.repositorio;

import br.com.demo.devinAdotion.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
}
