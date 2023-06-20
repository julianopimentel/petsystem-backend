package br.com.demo.devinAdotion.repositorios;

import br.com.demo.devinAdotion.modelos.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EstoqueRepositorio extends JpaRepository<Estoque, Long> {
    @Transactional
    @Modifying
    @Query("update Estoque e set e.produto = ?1, e.quantidade = ?2 where e.id = ?3")
    void updateProdutoAndQuantidadeById(@NonNull String produto, @NonNull Integer quantidade, @NonNull Long id);

    @Query("select count(e) from Estoque e where e.animal = ?1 and e.categoria = ?2 and e.produto = ?3")
    long countByTipo(String animal, String categoria, String produto);
    @Query("select count(e) from Estoque e where e.animal = ?1 and e.categoria = ?2")
    long countByTipoAnimal(String animal, String categoria);

    @Query("select avg(e.quantidade) from Estoque e where e.animal = ?1 and e.categoria = ?2")
    double calcularMedia(String animal, String categoria);

}
