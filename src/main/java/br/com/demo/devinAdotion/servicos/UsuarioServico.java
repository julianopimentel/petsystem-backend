package br.com.demo.devinAdotion.servicos;

import br.com.demo.devinAdotion.dto.AutenticacaoResposta;
import br.com.demo.devinAdotion.modelos.Usuario;
import br.com.demo.devinAdotion.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServico {

    private final UsuarioRepositorio usuarioRepositorio;

    @Autowired
    public UsuarioServico(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        // Verificar se todos os campos foram informados
        isCamposValidos(usuario.getNome(), usuario.getEmail(), usuario.getSenha(), true);

        // Aqui a lógica para salvar o usuário no banco de dados
        return usuarioRepositorio.save(usuario);
    }

    public boolean autenticarUsuario(String email, String senha) {
        // Verificar se todos os campos foram informados
        isCamposValidos(null, email, senha, false);

        Usuario usuario = usuarioRepositorio.findByEmail(email);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            return new AutenticacaoResposta(true, "Autenticação bem-sucedida").isAutenticado();
        }
        return new AutenticacaoResposta(false, "Credenciais inválidas").isAutenticado();
    }

    // Método para buscar o usuário pelo e-mail que foi logado
    public Usuario buscarDadosUsuario(String email) {
        Usuario usuario = usuarioRepositorio.findByEmail(email);
        return usuario;
    }

    // Método para verificar todos os campos
    public void isCamposValidos(String nome, String email, String senha, boolean isCadastro) {
        if(isCadastro){
            // verificar se todos os campos foram informados
            if (nome == null || email == null || senha == null) {
                throw new IllegalArgumentException("Todos os campos devem ser informados");
            }
            // verificar se não tem espaços em branco ou vazio
            if (nome.isBlank() || email.isBlank() || senha.isBlank()) {
                throw new IllegalArgumentException("Todos os campos devem ser informados");
            }
            // verificar se não está vazio
            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                throw new IllegalArgumentException("Todos os campos devem ser informados");
            }
            // Verificar se o e-mail já está cadastrado
            if (usuarioRepositorio.existsByEmail(email)) {
                throw new IllegalArgumentException("E-mail já cadastrado");
            }
            // verificar se o e-mail é válido
            if (!email.contains("@") || !email.contains(".")) {
                throw new IllegalArgumentException("E-mail inválido");
            }
        }
        else {
            // verificar se todos os campos foram informados
            if (email == null || senha == null) {
                throw new IllegalArgumentException("Todos os campos devem ser informados");
            }
            // verificar se não tem espaços em branco ou vazio
            if (email.isBlank() || senha.isBlank()) {
                throw new IllegalArgumentException("Todos os campos devem ser informados");
            }
            // verificar se não está vazio
            if (email.isEmpty() || senha.isEmpty()) {
                throw new IllegalArgumentException("Todos os campos devem ser informados");
            }
            // verificar se o e-mail é válido
            if (!email.contains("@") || !email.contains(".")) {
                throw new IllegalArgumentException("E-mail inválido");
            }
        }
    }
}
