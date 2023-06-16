package br.com.demo.devinAdotion.repositorios;

import br.com.demo.devinAdotion.modelos.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepositorio extends JpaRepository<Estoque, Long> {
}
