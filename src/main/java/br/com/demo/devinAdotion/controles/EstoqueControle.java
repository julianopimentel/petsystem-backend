package br.com.demo.devinAdotion.controles;

import br.com.demo.devinAdotion.modelos.Armazem;
import br.com.demo.devinAdotion.modelos.Estoque;
import br.com.demo.devinAdotion.servicos.EstoqueServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/estoque")
public class EstoqueControle {

    @Autowired
    private EstoqueServico estoqueServico;

    // Busca/consulta estoque por ID
    //  GET - Listagem do estoque (findAll)

    /*
    @GetMapping
    public ResponseEntity<?> get(){
        try{
           return ResponseEntity.ok(estoqueServico.buscarTodos());
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    */


    // ver se prefere o GET buscarTodos como acima ou abaixo
    @GetMapping
    public  ResponseEntity<List<Estoque>> buscarTodos() {
        return  ResponseEntity.status(HttpStatus.OK).body(estoqueServico.buscarTodos());
    }

    // buscar por id
    @GetMapping("{id}")
    public ResponseEntity<Estoque> buscarId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(estoqueServico.buscarId(id));
    }
    // cadastro produto no estoque

        // testar assim
//    @PostMapping(value = "/cadastro_produto")
//    public Long salvar (@RequestParam("armazem_id") Long armazem_id,
//                     @RequestParam("produto") String produto,
//                     @RequestParam("quantidade") Integer quantidade,
//                     @RequestParam("animal") String animal,
//                     @RequestParam("categoria_animal") String categoria_animal) throws Exception {
//        return ResponseEntity.ok().body(estoqueServico.salvar(armazem_id,produto,quantidade,animal,categoria_animal)).getBody();
//    }

            // ou assim
    @PostMapping(value = "/cadastro")
    public ResponseEntity<Long> salvar(@RequestParam("armazem_id") Long armazem_id,
                                       @RequestParam("produto") String produto,
                                       @RequestParam("quantidade") Integer quantidade,
                                       @RequestParam("animal") String animal,
                                       @RequestParam("categoria_animal") String categoria_animal) throws Exception {
        return ResponseEntity.ok().body(estoqueServico.salvar(armazem_id, produto, quantidade, animal, categoria_animal));
    }

    // edita todos os campos
    @PutMapping("/editar/{id}")
    ResponseEntity<Estoque> editar(@RequestBody Estoque estoque){
        return ResponseEntity.status(HttpStatus.OK).body(estoqueServico.editar(estoque));
    }

    // editar somente produto e quantidade

    @PutMapping("/editar_produto/{id}")
    public ResponseEntity<Estoque> editar(@PathVariable Long id, @RequestBody Estoque estoqueAtualizado) {
        Estoque estoque = estoqueServico.buscarId(id);
        if (estoque == null) {
            return ResponseEntity.notFound().build();
        }

        estoque.setProduto(estoqueAtualizado.getProduto());
        estoque.setQuantidade(estoqueAtualizado.getQuantidade());

        //Estoque estoqueAtualizado = estoqueServico.salvar(estoque);
        return ResponseEntity.status(HttpStatus.OK).body(estoqueServico.editar(estoque));
        //return ResponseEntity.ok(estoqueAtualizado);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletarId(@PathVariable Long id){
        estoqueServico.deletarId(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }




}












