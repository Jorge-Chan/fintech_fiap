package br.com.fintech.dao;

import br.com.fintech.model.Transacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransacaoDAO {
    private Connection connection;

    public TransacaoDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para inserir uma nova Transacao
    public void inserirTransacao(Transacao transacao) throws SQLException {
        String sql = "INSERT INTO TB_FIN_TRANSACAO (id_transacao, id_usuario, id_categoria, tp_transacao, ds_transacao, vl_transacao, dt_transacao) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, transacao.getIdTransacao());
            stmt.setInt(2, transacao.getIdUsuario());
            stmt.setInt(3, transacao.getIdCategoria());
            stmt.setString(4, transacao.getTpTransacao());
            stmt.setString(5, transacao.getDsTransacao());
            stmt.setFloat(6, transacao.getVlTransacao());
            stmt.setDate(7, (java.sql.Date) new Date(transacao.getDtTransacao().getTime()));

            stmt.executeUpdate();
        }
    }

    // Método para buscar uma Transacao por ID
    public Transacao buscarTransacaoPorId(int id) throws SQLException {
        String sql = "SELECT id_transacao, id_usuario, id_categoria, tp_transacao, ds_transacao, vl_transacao, dt_transacao FROM TB_FIN_TRANSACAO WHERE id_transacao = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Transacao transacao = new Transacao();
                    transacao.setIdTransacao(rs.getInt("id_transacao"));
                    transacao.setIdUsuario(rs.getInt("id_usuario"));
                    transacao.setIdCategoria(rs.getInt("id_categoria"));
                    transacao.setTpTransacao(rs.getString("tp_transacao"));
                    transacao.setDsTransacao(rs.getString("ds_transacao"));
                    transacao.setVlTransacao(rs.getFloat("vl_transacao"));
                    transacao.setDtTransacao(rs.getDate("dt_transacao"));

                    return transacao;
                }
            }
        }
        return null;
    }

    // Método para listar todas as Transacoes
    public List<Transacao> listarTodasTransacoes() throws SQLException {
        List<Transacao> transacoes = new ArrayList<>();
        String sql = "SELECT id_transacao, id_usuario, id_categoria, tp_transacao, ds_transacao, vl_transacao, dt_transacao FROM TB_FIN_TRANSACAO";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Transacao transacao = new Transacao();
                transacao.setIdTransacao(rs.getInt("id_transacao"));
                transacao.setIdUsuario(rs.getInt("id_usuario"));
                transacao.setIdCategoria(rs.getInt("id_categoria"));
                transacao.setTpTransacao(rs.getString("tp_transacao"));
                transacao.setDsTransacao(rs.getString("ds_transacao"));
                transacao.setVlTransacao(rs.getFloat("vl_transacao"));
                transacao.setDtTransacao(rs.getDate("dt_transacao"));

                transacoes.add(transacao);
            }
        }
        return transacoes;
    }

    // Método para atualizar uma Transacao
    public void atualizarTransacao(Transacao transacao) throws SQLException {
        String sql = "UPDATE TB_FIN_TRANSACAO SET id_usuario = ?, id_categoria = ?, tp_transacao = ?, ds_transacao = ?, vl_transacao = ?, dt_transacao = ? WHERE id_transacao = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, transacao.getIdUsuario());
            stmt.setInt(2, transacao.getIdCategoria());
            stmt.setString(3, transacao.getTpTransacao());
            stmt.setString(4, transacao.getDsTransacao());
            stmt.setFloat(5, transacao.getVlTransacao());
            stmt.setDate(6, (java.sql.Date) new Date(transacao.getDtTransacao().getTime()));
            stmt.setInt(7, transacao.getIdTransacao());

            stmt.executeUpdate();
        }
    }

    // Método para excluir uma Transacao
    public void excluirTransacao(int id) throws SQLException {
        String sql = "DELETE FROM TB_FIN_TRANSACAO WHERE id_transacao = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
