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
            stmt.setInt(1, pessoa.getIdPessoa());
            stmt.setString(2, pessoa.getNmPessoa());
            stmt.setString(3, pessoa.getDsEndereco());
            stmt.setString(4, pessoa.getNrTelefone());
            stmt.setInt(5, pessoa.getIdUsuario());

            stmt.executeUpdate();
        }
    }

    // Método para buscar uma Pessoa por ID
    public Pessoa buscarPessoaPorId(int id) throws SQLException {
        String sql = "SELECT id_pessoa, nm_pessoa, ds_endereco, nr_telefone, id_usuario FROM TB_FIN_PESSOA WHERE id_pessoa = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Pessoa pessoa = new Pessoa();
                    pessoa.setIdPessoa(rs.getInt("id_pessoa"));
                    pessoa.setNmPessoa(rs.getString("nm_pessoa"));
                    pessoa.setDsEndereco(rs.getString("ds_endereco"));
                    pessoa.setNrTelefone(rs.getString("nr_telefone"));
                    pessoa.setIdUsuario(rs.getInt("id_usuario"));

                    return pessoa;
                }
            }
        }
        return null;
    }

    // Método para listar todas as Pessoas
    public List<Pessoa> listarTodasPessoas() throws SQLException {
        List<Pessoa> pessoas = new ArrayList<>();
        String sql = "SELECT id_pessoa, nm_pessoa, ds_endereco, nr_telefone, id_usuario FROM TB_FIN_PESSOA";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setIdPessoa(rs.getInt("id_pessoa"));
                pessoa.setNmPessoa(rs.getString("nm_pessoa"));
                pessoa.setDsEndereco(rs.getString("ds_endereco"));
                pessoa.setNrTelefone(rs.getString("nr_telefone"));
                pessoa.setIdUsuario(rs.getInt("id_usuario"));

                pessoas.add(pessoa);
            }
        }
        return pessoas;
    }

    // Método para atualizar uma Pessoa
    public void atualizarPessoa(Pessoa pessoa) throws SQLException {
        String sql = "UPDATE TB_FIN_PESSOA SET nm_pessoa = ?, ds_endereco = ?, nr_telefone = ?, id_usuario = ? WHERE id_pessoa = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, pessoa.getNmPessoa());
            stmt.setString(2, pessoa.getDsEndereco());
            stmt.setString(3, pessoa.getNrTelefone());
            stmt.setInt(4, pessoa.getIdUsuario());
            stmt.setInt(5, pessoa.getIdPessoa());

            stmt.executeUpdate();
        }
    }

    // Método para excluir uma Pessoa
    public void excluirPessoa(int id) throws SQLException {
        String sql = "DELETE FROM TB_FIN_PESSOA WHERE id_pessoa = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}