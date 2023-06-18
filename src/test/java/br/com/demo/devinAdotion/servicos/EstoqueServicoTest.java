package br.com.demo.devinAdotion.servicos;

import br.com.demo.devinAdotion.modelos.Armazem;
import br.com.demo.devinAdotion.modelos.Estoque;
import br.com.demo.devinAdotion.repositorios.ArmazemRepositorio;
import br.com.demo.devinAdotion.repositorios.EstoqueRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EstoqueServicoTest  {

    @Mock
    private EstoqueRepositorio estoqueRepositorio;

    @InjectMocks
    private  EstoqueServico estoqueServico;

    @Mock
    private  ArmazemServico armazemServico;
    @Test
    void buscarTodos() {

        Armazem armazem = new Armazem(1L, "Armazem", "Cachorro", true);
        Estoque estoque = new Estoque(1L, "Ração", 5, "Cachorro", "Filhote", armazem);

        List<Estoque> estoques = List.of(estoque);

        when(estoqueRepositorio.findAll()).thenReturn(estoques);

        List<Estoque> estoqueList = estoqueServico.buscarTodos();

        assertEquals("Ração",estoqueList.get(0).getProduto());
        assertEquals(5,estoqueList.get(0).getQuantidade());

    }

    @Test
    void buscarId() {
        Armazem armazem = new Armazem(1L, "Armazem", "Cachorro", true);
        Estoque estoque = new Estoque(1L, "Ração", 5, "Cachorro", "Filhote", armazem);

        when(estoqueRepositorio.findById(anyLong())).thenReturn(Optional.of(estoque));

        Estoque estoque1 = estoqueServico.buscarId(1L);

        Assertions.assertEquals("Filhote", estoque1.getCategoria_animal());


    }

    @Test
    void salvar()  throws Exception {

        Armazem armazem = new Armazem(1L, "Armazem", "Cachorro", true);
        Estoque estoque = new Estoque(1L, "Ração", 5, "Cachorro", "Filhote", armazem);

        when(estoqueRepositorio.save(any())).thenReturn(estoque);

        Long novoEstoque = estoqueServico.salvar(1L,"Antipulga", 2, "Cachorro", "Adulto");

        assertNotNull(novoEstoque);
    }

    @Test
    void editar() {

//        Armazem armazem = new Armazem(1L, "Armazem", "Cachorro", true);
//        Estoque estoque = new Estoque(1L, "Ração", 5, "Cachorro", "Filhote", armazem);
//
//        when(estoqueRepositorio.findById(anyLong())).thenReturn(Optional.of(estoque));
//
//        Estoque estoqueEditado = new Estoque(1L,"Ração", 5, "Cachorro", "Adulto", armazem );
//
//        estoqueServico.editar(estoqueEditado);
//
//        Assertions.assertEquals("Adulto", estoqueEditado.getCategoria_animal());

    }

    @Test
    void deletarId() {

        Armazem armazem = new Armazem(1L, "Armazem", "Cachorro", true);
        Estoque estoque = new Estoque(1L, "Ração", 5, "Cachorro", "Filhote", armazem);

        estoqueServico.deletarId(estoque.getId());

        Assertions.assertEquals(1L,estoque.getId());
    }
}