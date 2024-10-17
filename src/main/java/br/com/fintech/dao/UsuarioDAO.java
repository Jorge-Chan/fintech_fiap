package br.com.fintech.dao;

import br.com.fintech.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class UsuarioDAO {
    private Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para inserir um novo usuário
    public void inserirUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO TB_FIN_USUARIO (id_usuario, nm_usuario, ds_email, dt_senha, dt_cadastro, tp_usuario) VALUES (1, 'Dante', 'ahahahaha', 'ajajajaj', 2024-10-30, 'aaaaa')";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, usuario.getIdUsuario());
            stmt.setString(2, usuario.getNmUsuario());
            stmt.setString(3, usuario.getDsEmail());
            stmt.setString(4, usuario.getDtSenha());
            stmt.setDate(5, new java.sql.Date(usuario.getDtCadastro().getTime()));
            stmt.setString(6, usuario.getTpUsuario());
            stmt.executeUpdate();
        }
    }

    // Método para buscar um usuário por ID
    public Usuario buscarUsuarioPorId(int id) throws SQLException {
        String sql = "SELECT id_usuario, nm_usuario, ds_email, dt_senha, dt_cadastro, tp_usuario FROM TB_FIN_USUARIO WHERE id_usuario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setIdUsuario(rs.getInt("id_usuario"));
                    usuario.setNmUsuario(rs.getString("nm_usuario"));
                    usuario.setDsEmail(rs.getString("ds_email"));
                    usuario.setDtSenha(rs.getString("dt_senha"));
                    usuario.setDtCadastro(rs.getDate("dt_cadastro"));
                    usuario.setTpUsuario(rs.getString("tp_usuario"));
                    return usuario;
                }
            }
        }
        return null;
    }

    // Método para atualizar um usuário
    public void atualizarUsuario(Usuario usuario) throws SQLException {
        String sql = "UPDATE TB_FIN_USUARIO SET nm_usuario = ?, ds_email = ?, dt_senha = ?, dt_cadastro = ?, tp_usuario = ? WHERE id_usuario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNmUsuario());
            stmt.setString(2, usuario.getDsEmail());
            stmt.setString(3, usuario.getDtSenha());
            stmt.setDate(4, new java.sql.Date(usuario.getDtCadastro().getTime()));
            stmt.setString(5, usuario.getTpUsuario());
            stmt.setInt(6, usuario.getIdUsuario());
            stmt.executeUpdate();
        }
    }

    // Método para excluir um usuário
    public void excluirUsuario(int id) throws SQLException {
        String sql = "DELETE FROM TB_FIN_USUARIO WHERE id_usuario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}





