package br.com.demo.devinAdotion.controles;

import br.com.demo.devinAdotion.dto.EstatisticasAnimais;
import br.com.demo.devinAdotion.servicos.DashboardServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estatisticas")
public class DashboardControle {

    @Autowired
    private DashboardServico dashboardServico;

    //o animal e a categoria são passados como parâmetro na url
    @GetMapping("{animal}/{categoria}")
    public EstatisticasAnimais getQuantidadeCachorroFilhote(@PathVariable String animal, @PathVariable String categoria) {

        long total= dashboardServico.countAnimais(animal, categoria);
        long totalComAntipulgas = dashboardServico.countByTipoAndAntipulgas(animal, categoria);
        long totalComAntiparasitario = dashboardServico.countByTipoAndAntiparasitario(animal, categoria);
        double mediaRacao = dashboardServico.calculateMediaRacaoByTipo(animal, categoria);
        return new EstatisticasAnimais(total, totalComAntipulgas, totalComAntiparasitario, mediaRacao);

    }


}
