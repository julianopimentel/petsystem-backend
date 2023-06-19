package br.com.demo.devinAdotion.servicos;

import br.com.demo.devinAdotion.modelos.Armazem;
import br.com.demo.devinAdotion.repositorios.ArmazemRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArmazemServico {

    @Autowired
    private ArmazemRepositorio armazemRepositorio;

    public Armazem cadastro(Armazem armazem) throws Exception {


        Armazem armazemBanco = new Armazem(1L, "armazem1", "Gato", true);
        if (armazem.getId() != null) {
            armazemBanco = buscarPorId(armazem.getId());
        }

        if (armazem.getNome() == null || armazem.getNome().isEmpty()) {
            throw new Exception("Nome é obrigatório");
        }

        if (armazem.getAnimal() == null) {
            throw new Exception("Gato ou Cachorro?");
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



    public boolean desativar(Long id) {
        try {
            Armazem armazem = buscarPorId(id);
            armazemRepositorio.delete(armazem);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}