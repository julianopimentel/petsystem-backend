package br.com.demo.devinAdotion.controles;

import br.com.demo.devinAdotion.modelos.Usuario;
import br.com.demo.devinAdotion.servicos.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioControle {

    private final UsuarioServico usuarioServico;

    @Autowired
    public UsuarioControle(UsuarioServico usuarioServico) {
        this.usuarioServico = usuarioServico;
    }

    // Endpoint para cadastrar um usuário
    @PostMapping("/cadastro")
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioServico.cadastrarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    // Endpoint para entrar na plataforma
    @PostMapping("/login")
    public ResponseEntity<Usuario> logarUsuario(@RequestBody Usuario usuario) {
        boolean usuarioLogado = usuarioServico.autenticarUsuario(usuario.getEmail(), usuario.getSenha());

        if (usuarioLogado) {
            Usuario usuarioLogadoObjeto = usuarioServico.buscarDadosUsuario(usuario.getEmail());
            return ResponseEntity.ok(usuarioLogadoObjeto);
        }
        return ResponseEntity.notFound().build();
    }

    // Endpoint para retonar que a conexão está ok com o bankend
    @GetMapping("/login")
    public ResponseEntity verificarconexao() {
        //retornar um ok no formato do json
        return ResponseEntity.ok("{\"mensagem\": \"ok\"}");
    }
    @GetMapping("/cadastro")
    public ResponseEntity verificarconexaoCadastro() {
        //retornar um ok no formato do json
        return ResponseEntity.ok("{\"mensagem\": \"ok\"}");
    }
}



