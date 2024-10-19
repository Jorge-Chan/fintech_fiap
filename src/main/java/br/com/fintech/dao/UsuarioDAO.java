package br.com.fintech.dao;

import br.com.fintech.exception.EntidadeNaoEcontradaException;
import br.com.fintech.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    private Connection connection;

    // Construtor que aceita a conexão
    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    public UsuarioDAO() {

    }

    // Método para inserir um novo usuário
    public void inserirUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO TB_FIN_USUARIO2 (id_usuario, nm_usuario, ds_email, ds_senha, tp_usuario) " +
                "VALUES (seq_usuario.nextval, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNmUsuario()); // Nome do usuário
            stmt.setString(2, usuario.getDsEmail());   // E-mail
            stmt.setString(3, usuario.getDsSenha());    // Senha
            stmt.setString(4, usuario.getTpUsuario());   // Tipo de usuário
            stmt.executeUpdate();                        // Executa a inserção
        }
    }

    // Método para pesquisar usuário por ID
    public Usuario pesquisar(Long idUsuario) throws SQLException, EntidadeNaoEcontradaException {
        String sql = "SELECT * FROM TB_FIN_USUARIO2 WHERE id_usuario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, idUsuario);
            ResultSet result = stmt.executeQuery();

            if (!result.next()) {
                throw new EntidadeNaoEcontradaException("Usuário não encontrado");
            }

            String nome = result.getString("nm_usuario");
            String email = result.getString("ds_email");
            String senha = result.getString("ds_senha");
            String tipo = result.getString("tp_usuario");

            return new Usuario(idUsuario, nome, email, senha, tipo);
        }
    }
}
