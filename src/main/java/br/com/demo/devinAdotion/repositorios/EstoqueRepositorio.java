package br.com.demo.devinAdotion.repositorios;

import br.com.demo.devinAdotion.modelos.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepositorio extends JpaRepository<Estoque, Long> {

    @Query("select count(e) from Estoque e where e.animal = ?1 and e.categoria_animal = ?2 and e.produto = ?3")
    long countByTipo(String animal, String categoria_animal, String produto);
    @Query("select count(e) from Estoque e where e.animal = ?1 and e.categoria_animal = ?2")
    long countByTipoAnimal(String animal, String categoria_animal);

    @Query("select avg(e.quantidade) from Estoque e where e.animal = ?1 and e.categoria_animal = ?2")
    double calcularMedia(String animal, String categoria);
}
