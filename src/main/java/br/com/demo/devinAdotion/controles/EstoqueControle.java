package br.com.demo.devinAdotion.controles;

import br.com.demo.devinAdotion.modelos.Estoque;
import br.com.demo.devinAdotion.servicos.EstoqueServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/estoque")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EstoqueControle {

    @Autowired
    private EstoqueServico estoqueServico;

    @GetMapping
    public  ResponseEntity<List<Estoque>> buscarTodos() {
        return  ResponseEntity.status(HttpStatus.OK).body(estoqueServico.buscarTodos());
    }

    // buscar por id
    @GetMapping("{id}")
    public ResponseEntity<?> getId(@PathVariable Long id){
        try {
            return ResponseEntity.ok(estoqueServico.buscarId(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // cadastro produto no estoque
    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Estoque estoque) {
        try {
            Estoque estoqueSalvo = estoqueServico.salvar(estoque);
            return ResponseEntity.ok().body(estoqueSalvo);
        } catch (Exception e) {
            // Erro interno do servidor: 500 Internal Server Error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // editar somente produto e quantidade
    @PutMapping("{id}")
    public ResponseEntity editar(@PathVariable Long id, @RequestBody Estoque estoqueEditado) throws Exception {
        //buscar o estoque pelo id
        Estoque estoque = estoqueServico.buscarId(id);
        //verificar se o estoque existe
        if (estoque == null) {
            return ResponseEntity.notFound().build();
        }

        estoque.setProduto(estoqueEditado.getProduto());
        estoque.setQuantidade(estoqueEditado.getQuantidade());

        try {
            //fazer o update somente dos dados do produto e quantidade
            estoqueServico.editarProduto(estoque);
            //buscar os dados atualizados
            Estoque estoqueAtualizado = estoqueServico.buscarId(id);
            //retornar os dados atualizados
            return ResponseEntity.ok(estoqueAtualizado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao editar o Estoque");
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletarId(@PathVariable Long id){
        estoqueServico.deletarId(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}












