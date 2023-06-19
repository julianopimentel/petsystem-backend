package br.com.demo.devinAdotion.controle;

import br.com.demo.devinAdotion.controles.DashboardControle;
import br.com.demo.devinAdotion.dto.EstatisticasAnimais;
import br.com.demo.devinAdotion.servicos.DashboardServico;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class DashboardControleTest {

    @Mock
    private DashboardServico dashboardServico;

    @InjectMocks
    private DashboardControle dashboardControle;

    @Test
    public void testGetEstatisticas() {
        // Dados de teste
        String animal = "cachorro";
        String categoria = "filhote";
        long totalAnimais = 10;
        long totalAntipulgas = 5;
        long totalAntiparasitario = 3;
        double mediaRacao = 31.42;

        // Definir comportamento do mock
        when(dashboardServico.countAnimais(animal, categoria)).thenReturn(totalAnimais);
        when(dashboardServico.countByTipoAndAntipulgas(animal, categoria)).thenReturn(totalAntipulgas);
        when(dashboardServico.countByTipoAndAntiparasitario(animal, categoria)).thenReturn(totalAntiparasitario);
        when(dashboardServico.calculateMediaRacaoByTipo(animal, categoria)).thenReturn(mediaRacao);

        // Executar o método a ser testado
        EstatisticasAnimais estatisticas = dashboardControle.getQuantidadeCachorroFilhote(animal, categoria);

        // Verificar os resultados
        assertEquals(totalAnimais, estatisticas.getTotal());
        assertEquals(totalAntipulgas, estatisticas.getTotalComAntipulgas());
        assertEquals(totalAntiparasitario, estatisticas.getTotalComAntiparasitario());
        assertEquals(mediaRacao, estatisticas.getMediaRacao());
    }
}