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
        if (usuarioRepositorio.existsByEmail(usuario.getEmail())) {
            throw new IllegalArgumentException("E-mail já cadastrado");
        }

        // Aqui ele vai verificar se todos os campos foram informados
        if (usuario.getNome() == null || usuario.getEmail() == null || usuario.getSenha() == null) {
            throw new IllegalArgumentException("Todos os campos devem ser informados");
        }

        // Aqui a lógica para salvar o usuário no banco de dados
        return usuarioRepositorio.save(usuario);
    }

    public boolean autenticarUsuario(String email, String senha) {
        if (email == null || senha == null) {
            throw new IllegalArgumentException("E-mail e senha devem ser informados");
        }

        Usuario usuario = usuarioRepositorio.findByEmail(email);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            return new AutenticacaoResposta(true, "Autenticação bem-sucedida").isAutenticado();
        }
        return new AutenticacaoResposta(false, "Credenciais inválidas").isAutenticado();
    }
}
