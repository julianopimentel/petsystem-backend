package br.com.demo.devinAdotion.servicos;

import br.com.demo.devinAdotion.repositorios.EstoqueRepositorio;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class DashboardServicoTest {

    @Mock
    private EstoqueRepositorio estoqueRepositorio;

    @InjectMocks
    private DashboardServico dashboardServico;

    @Test
    public void testCountAnimais() {
        // Dados de teste
        String animal = "cachorro";
        String categoria = "filhote";
        long totalAnimais = 10;

        // Definir comportamento do mock
        when(estoqueRepositorio.countByTipoAnimal(animal, categoria)).thenReturn(totalAnimais);

        // Executar o método a ser testado
        long total = dashboardServico.countAnimais(animal, categoria);

        // Verificar o resultado
        assertEquals(totalAnimais, total);
    }

    @Test
    public void testCountByTipoAndAntipulgas() {
        // Dados de teste
        String animal = "cachorro";
        String categoria = "filhote";
        long totalComAntipulgas = 5;

        // Definir comportamento do mock
        when(estoqueRepositorio.countByTipo(animal, categoria, "antipulgas")).thenReturn(totalComAntipulgas);

        // Executar o método a ser testado
        long total = dashboardServico.countByTipoAndAntipulgas(animal, categoria);

        // Verificar o resultado
        assertEquals(totalComAntipulgas, total);
    }

    @Test
    public void testCalculateMediaRacaoByTipo() {
        // Dados de teste
        String animal = "cachorro";
        String categoria = "filhote";
        double mediaRacao = 31.42;

        // Definir comportamento do mock
        when(estoqueRepositorio.calcularMedia(animal, categoria)).thenReturn(mediaRacao);

        // Executar o método a ser testado
        double media = dashboardServico.calculateMediaRacaoByTipo(animal, categoria);

        // Verificar o resultado
        assertEquals(mediaRacao, media);
    }

    @Test
    public void testCountByTipoAndAntiparasitario() {
        // Dados de teste
        String animal = "cachorro";
        String categoria = "filhote";
        long totalComAntiparasitario = 3;

        // Definir comportamento do mock
        when(estoqueRepositorio.countByTipo(animal, categoria, "antiparasitario")).thenReturn(totalComAntiparasitario);

        // Executar o método a ser testado
        long total = dashboardServico.countByTipoAndAntiparasitario(animal, categoria);

        // Verificar o resultado
        assertEquals(totalComAntiparasitario, total);
    }
}