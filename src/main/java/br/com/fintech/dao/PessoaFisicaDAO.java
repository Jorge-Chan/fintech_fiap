package br.com.fintech.dao;

import br.com.fintech.model.PessoaFisica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaFisicaDAO {
    private Connection connection;

    public PessoaFisicaDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para adicionar uma nova PessoaFisica
    public void adicionar(PessoaFisica pessoaFisica) throws SQLException {
        String sql = "INSERT INTO TB_FIN_PESSOA_FISICA (id_pessoa, ds_cpf, dt_nascimento) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, pessoaFisica.getIdPessoa());
            stmt.setString(2, pessoaFisica.getDsCpf());
            stmt.setDate(3, new java.sql.Date(pessoaFisica.getDtNascimento().getTime()));
            stmt.executeUpdate();
        }
    }

    // Método para buscar PessoaFisica pelo ID
    public PessoaFisica buscarPorId(int idPessoa) throws SQLException {
        String sql = "SELECT * FROM TB_FIN_PESSOA_FISICA WHERE id_pessoa = ?";
        PessoaFisica pessoaFisica = null;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idPessoa);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    pessoaFisica = new PessoaFisica(
                            rs.getInt("id_pessoa"),
                            rs.getString("ds_cpf"),
                            rs.getDate("dt_nascimento")
                    );
                }
            }
        }
        return pessoaFisica;
    }

    // Método para atualizar PessoaFisica
    public void atualizar(PessoaFisica pessoaFisica) throws SQLException {
        String sql = "UPDATE TB_FIN_PESSOA_FISICA SET ds_cpf = ?, dt_nascimento = ? WHERE id_pessoa = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, pessoaFisica.getDsCpf());
            stmt.setDate(2, new java.sql.Date(pessoaFisica.getDtNascimento().getTime()));
            stmt.setInt(3, pessoaFisica.getIdPessoa());
            stmt.executeUpdate();
        }
    }

    // Método para remover PessoaFisica
    public void remover(int idPessoa) throws SQLException {
        String sql = "DELETE FROM TB_FIN_PESSOA_FISICA WHERE id_pessoa = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idPessoa);
            stmt.executeUpdate();
        }
    }
}
