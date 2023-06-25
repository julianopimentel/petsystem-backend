package br.com.demo.devinAdotion.servicos;

import br.com.demo.devinAdotion.repositorios.EstoqueRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardServico {

    @Autowired
    private EstoqueRepositorio estoqueRepositorio;

    public long countAnimais(String animal, String categoria) {
        Long sum = estoqueRepositorio.countByTipoAnimal(animal, categoria);
        if(sum != null) {
            return sum;
        }
        return 0;
    }

    public long countByTipoAndAntipulgas(String animal, String categoria) {
        Long sum  = estoqueRepositorio.countByTipo(animal, categoria, "antipulgas");
        if(sum != null) {
            return sum;
        }
        return 0;
    }

    public long countByTipoAndAntiparasitario(String animal, String categoria) {
        Long sum = estoqueRepositorio.countByTipo(animal, categoria, "antiparasitario");
        if(sum != null) {
            return sum;
        }
        return 0;
    }

    public long calculateTotalRacaoByTipo(String animal, String categoria) {
        Long sum = estoqueRepositorio.countByTipo(animal, categoria, "racao");
        if(sum != null) {
            return sum;
        }
        return 0;
    }

}
