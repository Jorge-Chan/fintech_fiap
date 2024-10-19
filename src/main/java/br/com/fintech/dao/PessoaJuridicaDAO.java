package br.com.fintech.dao;

import br.com.fintech.model.PessoaJuridica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PessoaJuridicaDAO {
    private Connection connection;

    public PessoaJuridicaDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para adicionar uma nova PessoaJuridica
    public void adicionar(PessoaJuridica pessoaJuridica) throws SQLException {
        String sql = "INSERT INTO TB_FIN_PESSOA_JURIDICA " +
                "(id_pessoa, nm_pessoa, ds_endereco, nr_telefone, ds_cnpj, nm_razao_social) " +
                "VALUES (aeq_pessoajuridica.nextval, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            // Definindo todos os parâmetros corretamente
            stmt.setString(1, pessoaJuridica.getNmPessoa());          // Nome da pessoa (índice 1)
            stmt.setString(2, pessoaJuridica.getDsEndereco());        // Endereço (índice 2)
            stmt.setString(3, pessoaJuridica.getNrTelefone());        // Telefone (índice 3)
            stmt.setString(4, pessoaJuridica.getDsCnpj());            // CNPJ (índice 4)
            stmt.setString(5, pessoaJuridica.getNmRazaoSocial());     // Razão Social (índice 5)

            stmt.executeUpdate();
        }
    }
}
