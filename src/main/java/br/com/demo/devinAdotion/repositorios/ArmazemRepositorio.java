package br.com.demo.devinAdotion.repositorios;

import br.com.demo.devinAdotion.modelos.Armazem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArmazemRepositorio extends JpaRepository<Armazem, Long> {
}
