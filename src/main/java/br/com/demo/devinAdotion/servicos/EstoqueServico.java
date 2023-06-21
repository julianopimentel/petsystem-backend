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

    public List<Estoque> buscarTodos() {
        return estoqueRepositorio.findAll();
    }

    public Estoque buscarId(Long id) {
        Optional<Estoque> estoque = estoqueRepositorio.findById(id);
        return estoque.orElse(null);
    }

    public Long salvar(Estoque estoque) throws Exception {
        validarEstoque(estoque);
        Armazem armazem = armazemServico.buscarPorId(estoque.getArmazenamento().getId());
        if (!verificarAceitacaoAnimal(armazem, estoque.getAnimal())) {
            throw new Exception("Este local de armazenamento não aceita produtos para o animal especificado.");
        }
        estoque.setArmazenamento(armazem);
        return estoqueRepositorio.save(estoque).getId();
    }

    public void editarProduto(Estoque estoque) {
        estoqueRepositorio.updateProdutoAndQuantidadeById(estoque.getProduto(), estoque.getQuantidade(), estoque.getId());
    }

    public void deletarId(Long id) {
        estoqueRepositorio.deleteById(id);
    }

    private void validarEstoque(Estoque estoque) throws Exception {
        if (!isTipoProdutoValido(estoque.getTipoProduto())) {
            throw new Exception("Tipo de produto inválido");
        }

        if (estoque.getQuantidade() <= 0) {
            throw new Exception("A quantidade deve ser um número inteiro maior que zero");
        }

        if (!isAnimalValido(estoque.getAnimal())) {
            throw new Exception("Animal inválido");
        }

        if (!isCategoriaValida(estoque.getCategoria())) {
            throw new Exception("Categoria inválida");
        }
    }

    private boolean isTipoProdutoValido(String tipoProduto) {
        // Verifica se o tipo do produto é válido
        return tipoProduto.equals("Ração") ||
                tipoProduto.equals("Antiparasitário") ||
                tipoProduto.equals("Antipulgas");
    }

    private boolean isAnimalValido(String animal) {
        // Verifica se o animal é válido
        return animal.equals("Cachorro") || animal.equals("Gato");
    }

    private boolean isCategoriaValida(String categoria) {
        // Verifica se a categoria é válida
        return categoria.equals("Filhote") || categoria.equals("Adulto");
    }

    private boolean verificarAceitacaoAnimal(Armazem armazem, String animal) {
        // Verifica se o local de armazenamento aceita produtos para o animal especificado
        return armazem.getAnimaisAceitos().contains(animal);
    }
}
