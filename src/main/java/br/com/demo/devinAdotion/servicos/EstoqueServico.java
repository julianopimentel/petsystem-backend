package br.com.demo.devinAdotion.servicos;

import br.com.demo.devinAdotion.modelos.Armazem;
import br.com.demo.devinAdotion.modelos.Estoque;
import br.com.demo.devinAdotion.repositorios.EstoqueRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueServico {

    @Autowired
    private EstoqueRepositorio estoqueRepositorio;

    @Autowired
    private ArmazemServico armazemServico;


    // 4 - Listagem do estoque

    public List<Estoque> buscarTodos(){
        return estoqueRepositorio.findAll();
    }

    public Estoque buscarId(Long id){
        Optional<Estoque> estoque = estoqueRepositorio.findById(id);
        return (estoque.isPresent() ? estoque.get() : null);
    }

    // 7 - Cadastro de Produto do estoque
    public  Long salvar (
            Long armazem_id,
            String produto,
            Integer quantidade,
            String animal,
            String categoria_animal
    ) throws Exception {
        Estoque estoque = new Estoque();
        Armazem armazem = armazemServico.buscarPorId(armazem_id);
        estoque.setProduto(produto);
        estoque.setQuantidade(quantidade);
        estoque.setAnimal(animal);
        estoque.setCategoria_animal(categoria_animal);
        return estoqueRepositorio.save(estoque).getId();
    }

    // 5 - Editar produto do estoque

    public  Estoque editar (Estoque estoque) {
        return estoqueRepositorio.save(estoque);
    }

    // 6 - Remover item

    public void deletarId (Long id) {
        estoqueRepositorio.deleteById(id);
    }

}
