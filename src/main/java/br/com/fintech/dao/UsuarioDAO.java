package br.com.fintech.dao;

import br.com.fintech.model.Usuario;
import br.com.fintech.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    // Método para inserir usuário (existente)
    public void inserirUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO TB_FIN_USUARIO2 (id_usuario, nm_usuario, ds_email, ds_senha, tp_usuario) " +
                "VALUES (seq_usuario.nextval, ?, ?, ?, ?)";
    }

    // Método para deletar um usuário pelo ID
    public boolean deletarUsuario(int id) throws SQLException {
        String sql = "DELETE FROM TB_FIN_USUARIO2 WHERE id = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // Método para pesquisar um usuário por nome ou email (mantido para referência)
    public Usuario pesquisarUsuario(String identificador) throws SQLException {
        String sql = "SELECT * FROM TB_FIN_USUARIO2 WHERE nome = ? OR email = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, identificador);
            stmt.setString(2, identificador);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Se o usuário for encontrado, cria uma instância de Usuario com os dados
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String senha = rs.getString("senha");
                String tipoUsuario = rs.getString("tipo_usuario");

                return new Usuario(nome, email, senha, tipoUsuario);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null; // Retorna null se o usuário não for encontrado
    }
}