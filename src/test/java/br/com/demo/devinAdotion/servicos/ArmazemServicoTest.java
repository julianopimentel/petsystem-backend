package br.com.demo.devinAdotion.servicos;

import br.com.demo.devinAdotion.modelos.Armazem;
import br.com.demo.devinAdotion.repositorios.ArmazemRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ArmazemServicoTest {

    @Mock
    private ArmazemRepositorio repositorio;

    @InjectMocks
    private ArmazemServico armazemServico;

    @Test
    void cadastro() {
//        Armazem armazem = new Armazem(1L,"scooby","cachorro",true);
//
//        when(repositorio.save(any())).thenReturn(armazem);
//
//        Armazem cadastro = armazemServico.cadastro(
//                new ArmazemRequest(1L,"Scooby","cachorro",true));
//
//        assertNotNull(cadastro);
//        assertEquals("Scooby", cadastro.getNome());
    }

//    @Test
//    void buscarTodos() {
//
//        List<Armazem> armazem = List.of(new Armazem(1L, "scooby", "cachorro", true));
//
//        given(repositorio.findAll()).willReturn(armazem);
//
//        List<Armazem> armazemResultado = armazemServico.buscarTodos();
//
//        Assertions.assertNotEquals("gato", armazemResultado);
//
//        then(repositorio)
//                .should()
//                .findAll();
//    }

    @Test
    void desativar() {
    }
}