package br.com.demo.devinAdotion.servicos;

import br.com.demo.devinAdotion.modelos.Armazem;
import br.com.demo.devinAdotion.modelos.Estoque;
import br.com.demo.devinAdotion.repositorios.ArmazemRepositorio;
import br.com.demo.devinAdotion.repositorios.EstoqueRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArmazemServico {

    @Autowired
    private ArmazemRepositorio armazemRepositorio;

    @Autowired
    private EstoqueRepositorio estoqueRepositorio;

    public Armazem cadastro(Armazem armazem) throws Exception {


        Armazem armazemBanco = new Armazem();

        if (armazem.getNome() == null || armazem.getNome().isEmpty()) {
            throw new Exception("Nome é obrigatório");
        }

        if (armazem.getAnimal() == null) {
            throw new Exception("Gato ou Cachorro?");
        }

        //converte para minúsculo o getanimal
        armazem.setAnimal(armazem.getAnimal().toLowerCase());

        //verificar se o animal e a categoria são válidos
        if (!armazem.getAnimal().equals("cachorro") && !armazem.getAnimal().equals("gato")) {
            throw new IllegalArgumentException("Animal inválido");
        }

        armazemBanco.setNome(armazemBanco.getNome());
        armazemBanco.setAnimal(armazemBanco.getAnimal());

        return armazemRepositorio.save(armazem);
    }

    public List<Armazem> buscarTodos() {
        return armazemRepositorio.findAll();
    }

    public Armazem buscarPorId(Long id) throws Exception {
        Optional<Armazem> armazemOpcional = armazemRepositorio.findById(id);
        if (armazemOpcional.isEmpty()) {
            throw new Exception("Armazem não encontrado");
        }
        return armazemOpcional.get();
    }


    public Armazem alterarSituacao(Long id) {
        Armazem armazem = armazemRepositorio.findById(id).get();
        if(armazem == null || armazem.getSituacao() == false){
            throw new RuntimeException("Armazem não encontrado ou já está desativado");
        }

        long estoqueAtivo = estoqueRepositorio.CountVerificarArmazemAtivo(id);
        if (estoqueAtivo > 0){
            throw new RuntimeException("Não é possível desativar um armazem com estoque ativo");
        }
        else
        armazem.setSituacao(false);
        return armazemRepositorio.save(armazem);
    }

    public Armazem update(Armazem armazem) throws Exception {
        Armazem armazemBanco = armazemRepositorio.findById(armazem.getId()).get();
        if (armazemBanco == null) {
            throw new RuntimeException("Armazem não encontrado");
        }
        if (armazem.getNome() == null || armazem.getNome().isEmpty()) {
            throw new Exception("Nome é obrigatório");
        }

        if (armazem.getAnimal() == null) {
            throw new Exception("Gato ou Cachorro?");
        }

        //converte para minúsculo o getanimal
        armazem.setAnimal(armazem.getAnimal().toLowerCase());

        //verificar se o animal e a categoria são válidos
        if (!armazem.getAnimal().equals("cachorro") && !armazem.getAnimal().equals("gato")) {
            throw new IllegalArgumentException("Animal inválido");
        }
        armazemBanco.setNome(armazem.getNome());
        armazemBanco.setAnimal(armazem.getAnimal());
        return armazemRepositorio.save(armazemBanco);
    }
}