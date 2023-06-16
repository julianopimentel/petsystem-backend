package br.com.demo.devinAdotion.servicos;

import br.com.demo.devinAdotion.modelos.Armazem;
import br.com.demo.devinAdotion.modelos.Estoque;
import br.com.demo.devinAdotion.repositorio.EstoqueRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EstoqueServico {

    @Autowired
    private EstoqueRepositorio estoqueRepositorio;

    @Autowired
    private ArmazemServico armazemServico;


    // 4 - Listagem do estoque

    public List<Estoque> findAll(){
        return estoqueRepositorio.findAll();
    }

    // 7 - Cadastro de Produto do estoque
    public  Long save (
            Long armazem_id,
            String produto,
            Integer quantidade,
            String animal,
            String categoria_animal
    ){
        Estoque estoque = new Estoque();
        Armazem armazem = armazemServico.findById(armazem_id);
        estoque.setProduto(produto);
        estoque.setQuantidade(quantidade);
        estoque.setAnimal(animal);
        estoque.setCategoria_animal(categoria_animal);
        return estoqueRepositorio.save(estoque).getId();
    }

    // 5 - Editar produto do estoque

    public  Estoque update (Estoque estoque) {
        return estoqueRepositorio.save(estoque);
    }

    // 6 - Remover item

    public void deleteById(Long id) {
        estoqueRepositorio.deleteById(id);
    }

}
