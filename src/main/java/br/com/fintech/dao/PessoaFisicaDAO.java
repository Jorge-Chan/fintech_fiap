package br.com.fintech.dao;

import br.com.fintech.model.PessoaFisica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PessoaFisicaDAO {
    private Connection connection;

    public PessoaFisicaDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para adicionar uma nova PessoaFisica
    public void adicionar(PessoaFisica pessoaFisica) throws SQLException {
        String sql = "INSERT INTO TB_FIN_PESSOA_FISICA (id_pessoa, nm_pessoa, ds_endereco, nr_telefone, ds_cpf) " +
                "VALUES (seq_pessoafisica2.nextval, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            // Define os parâmetros do PreparedStatement
            stmt.setString(1, pessoaFisica.getNmPessoa());     // Primeiro parâmetro: nome da pessoa
            stmt.setString(2, pessoaFisica.getDsEndereco());   // Segundo parâmetro: endereço
            stmt.setString(3, pessoaFisica.getNrTelefone());   // Terceiro parâmetro: telefone
            stmt.setString(4, pessoaFisica.getDsCpf());        // Quarto parâmetro: CPF

            // Executa a inserção no banco de dados
            stmt.executeUpdate();
        }
    }
}
