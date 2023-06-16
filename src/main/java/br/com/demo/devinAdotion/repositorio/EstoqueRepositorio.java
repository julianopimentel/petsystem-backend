package br.com.demo.devinAdotion.repositorio;

import br.com.demo.devinAdotion.modelos.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepositorio extends JpaRepository<Estoque, Long> {
}
