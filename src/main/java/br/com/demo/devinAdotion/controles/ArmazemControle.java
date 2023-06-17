package br.com.demo.devinAdotion.controles;

import br.com.demo.devinAdotion.modelos.Armazem;
import br.com.demo.devinAdotion.servicos.ArmazemServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/armazem")
public class ArmazemControle {

    @Autowired
    private ArmazemServico armazemServico;

    @GetMapping
    public ResponseEntity<?> get(){
        try{
            return ResponseEntity.ok(armazemServico.buscarTodos());
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getId(@PathVariable Long id){
        try {
            return ResponseEntity.ok(armazemServico.buscarPorId(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Armazem armazem){
        try {
            armazem.setId(null);
            return ResponseEntity.ok(armazemServico.cadastro(armazem));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> put(@PathVariable Long id, @RequestBody Armazem armazem) {
        try {
            if (id == null){
                throw new Exception("Escolha o id de um armazem");
            }
            armazem.setId(id);
            return ResponseEntity.ok(armazemServico.cadastro(armazem));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.ok(armazemServico.desativar(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
