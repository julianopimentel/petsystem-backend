package br.com.demo.devinAdotion.controles;

import br.com.demo.devinAdotion.dto.EstatisticasAnimais;
import br.com.demo.devinAdotion.servicos.DashboardServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.text.DecimalFormat;


@RestController
@RequestMapping("/estatisticas")
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
            throw new IllegalArgumentException("Animal inválido");
        }

        if (!categoria.equals("filhote") && !categoria.equals("adulto")) {
            throw new IllegalArgumentException("Categoria inválida");
        }

        try {
        long total= dashboardServico.countAnimais(animal, categoria);
        long totalComAntipulgas = dashboardServico.countByTipoAndAntipulgas(animal, categoria);
        long totalComAntiparasitario = dashboardServico.countByTipoAndAntiparasitario(animal, categoria);
        double consultaMediaRacao = dashboardServico.calculateMediaRacaoByTipo(animal, categoria);

        //formatar a média para duas casas decimais
        DecimalFormat df = new DecimalFormat("#0.00");
        String mediaRacaoFormatada = df.format(consultaMediaRacao).replace(".", ",");
        double mediaRacao = Double.parseDouble(mediaRacaoFormatada.replace(",", "."));

        //retorna um objeto com as estatísticas
        return new EstatisticasAnimais(total, totalComAntipulgas, totalComAntiparasitario, mediaRacao);
        } catch (Exception e) {
            //retornar o EstatisticasAnimais com todos os valores zerados
            return new EstatisticasAnimais(0, 0, 0, 0);
        }
    }


}
