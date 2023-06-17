package br.com.demo.devinAdotion.controles;

import br.com.demo.devinAdotion.modelos.Estoque;
import br.com.demo.devinAdotion.servicos.EstoqueServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/estoque")
public class EstoqueControle {

    @Autowired
    private EstoqueServico estoqueServico;

    // Busca/consulta estoque por ID
    @GetMapping
    public ResponseEntity<?> get(){
        try{
           return ResponseEntity.ok(estoqueServico.buscarTodos());
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //Envio/cadastro de estoque
/*    @PostMapping
    public ResponseEntity<?> post(@RequestBody Estoque estoque){
        try {
            estoque.setId(null);
            return ResponseEntity.ok(estoqueServico.cadastro(estoque));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }*/
}












