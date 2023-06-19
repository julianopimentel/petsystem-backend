package br.com.demo.devinAdotion.servicos;

import br.com.demo.devinAdotion.repositorios.EstoqueRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardServico {

    @Autowired
    private EstoqueRepositorio estoqueRepositorio;

    public long countAnimais(String animal, String categoria) {
        return estoqueRepositorio.countByTipoAnimal(animal, categoria);
    }

    public long countByTipoAndAntipulgas(String animal, String categoria) {
        return estoqueRepositorio.countByTipo(animal, categoria, "antipulgas");
    }


    public double calculateMediaRacaoByTipo(String animal, String categoria) {
        return estoqueRepositorio.calcularMedia(animal, categoria);
    }

    public long countByTipoAndAntiparasitario(String animal, String categoria) {
        return estoqueRepositorio.countByTipo(animal, categoria, "antiparasitario");

    }
}
