package br.com.fintech.dao;

import br.com.fintech.model.PessoaJuridica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaJuridicaDAO {
    private Connection connection;

    public PessoaJuridicaDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para adicionar uma nova PessoaJuridica
    public void adicionar(PessoaJuridica pessoaJuridica) throws SQLException {
        String sql = "INSERT INTO TB_FIN_PESSOA_JURIDICA (id_pessoa, ds_cnpj, nm_razao_social) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, pessoaJuridica.getIdPessoa());
            stmt.setString(2, pessoaJuridica.getDsCnpj());
            stmt.setString(3, pessoaJuridica.getNmRazaoSocial());
            stmt.executeUpdate();
        }
    }

    // Método para buscar PessoaJuridica pelo ID
    public PessoaJuridica buscarPorId(int idPessoa) throws SQLException {
        String sql = "SELECT * FROM TB_FIN_PESSOA_JURIDICA WHERE id_pessoa = ?";
        PessoaJuridica pessoaJuridica = null;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idPessoa);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    pessoaJuridica = new PessoaJuridica(
                            rs.getInt("id_pessoa"),
                            rs.getString("ds_cnpj"),
                            rs.getString("nm_razao_social")
                    );
                }
            }
        }
        return pessoaJuridica;
    }

    // Método para atualizar PessoaJuridica
    public void atualizar(PessoaJuridica pessoaJuridica) throws SQLException {
        String sql = "UPDATE TB_FIN_PESSOA_JURIDICA SET ds_cnpj = ?, nm_razao_social = ? WHERE id_pessoa = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, pessoaJuridica.getDsCnpj());
            stmt.setString(2, pessoaJuridica.getNmRazaoSocial());
            stmt.setInt(3, pessoaJuridica.getIdPessoa());
            stmt.executeUpdate();
        }
    }

    // Método para remover PessoaJuridica
    public void remover(int idPessoa) throws SQLException {
        String sql = "DELETE FROM TB_FIN_PESSOA_JURIDICA WHERE id_pessoa = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idPessoa);
            stmt.executeUpdate();
        }
    }
}
