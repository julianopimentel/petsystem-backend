package br.com.demo.devinAdotion.controles;

import br.com.demo.devinAdotion.dto.EstatisticasAnimais;
import br.com.demo.devinAdotion.servicos.DashboardServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.text.DecimalFormat;


@RestController
@RequestMapping("/estatisticas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DashboardControle {

    @Autowired
    private DashboardServico dashboardServico;

    //o animal e a categoria são passados como parâmetro na url
    @GetMapping("{animal}/{categoria}")
    public EstatisticasAnimais getQuantidadeCachorroFilhote(@PathVariable String animal, @PathVariable String categoria) {

        //converte para minúsculo
        animal = animal.toLowerCase();
        categoria = categoria.toLowerCase();

        //verificar se o animal e a categoria são válidos
        if (!animal.equals("cachorro") && !animal.equals("gato")) {
            throw new IllegalArgumentException("Preencher animal é obrigatório. Escolha gato ou cachorro.");
        }

        if (!categoria.equals("filhote") && !categoria.equals("adulto")) {
            throw new IllegalArgumentException("Categoria inválida");
        }


        long total= dashboardServico.countAnimais(animal, categoria);
        long totalComAntipulgas = dashboardServico.countByTipoAndAntipulgas(animal, categoria);
        long totalComAntiparasitario = dashboardServico.countByTipoAndAntiparasitario(animal, categoria);
        long totalRacao = dashboardServico.calculateTotalRacaoByTipo(animal, categoria);


        //retorna um objeto com as estatísticas
        return new EstatisticasAnimais(total, totalComAntipulgas, totalComAntiparasitario, totalRacao);
    }


}
