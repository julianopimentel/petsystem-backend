package br.com.demo.devinAdotion.controles;

import br.com.demo.devinAdotion.modelos.Armazem;
import br.com.demo.devinAdotion.servicos.ArmazemServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/armazem")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ArmazemControle {

    @Autowired
    private ArmazemServico armazemServico;

    // listar todos
    @GetMapping
    public ResponseEntity<?> Listar(){
        try{
            return ResponseEntity.ok(armazemServico.buscarTodos());
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // buscar por id
    @GetMapping("{id}")
    public ResponseEntity<?> getId(@PathVariable Long id){
        try {
            return ResponseEntity.ok(armazemServico.buscarPorId(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // cadastro de armazem
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Armazem armazem){
        try {
            return ResponseEntity.ok(armazemServico.cadastro(armazem));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // alterar armazem
    @PutMapping("{id}")
    public ResponseEntity<?> put(@PathVariable Long id, @RequestBody Armazem armazem) {

        try {
            if (id == null){
                throw new Exception("Escolha o id de um armazem");
            }
            armazem.setId(id);
            return ResponseEntity.ok(armazemServico.update(armazem));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //desativar armazem
    @PutMapping("/desativar/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if (id == null){
            throw new RuntimeException("Escolha o id de um armazem");
        }
        try {
            return ResponseEntity.ok(armazemServico.alterarSituacao(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
