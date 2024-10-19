package br.com.fintech.dao;

import br.com.fintech.model.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

    private Connection connection;

    public PessoaDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para inserir uma nova Pessoa
    public void inserirPessoa(Pessoa pessoa) throws SQLException {
        String sql = "INSERT INTO TB_FIN_PESSOA (id_pessoa, nm_pessoa, ds_endereco, nr_telefone, id_usuario) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(2, pessoa.getNmPessoa());
            stmt.setString(3, pessoa.getDsEndereco());
            stmt.setString(4, pessoa.getNrTelefone());
            stmt.setInt(5, pessoa.getIdUsuario());

            stmt.executeUpdate();
        }
    }


}