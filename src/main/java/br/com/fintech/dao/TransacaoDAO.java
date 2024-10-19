package br.com.fintech.dao;

import br.com.fintech.model.Transacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransacaoDAO {
    private Connection connection;

    public TransacaoDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para inserir uma nova Transacao
    public void inserirTransacao(Transacao transacao) throws SQLException {
        String sql = "INSERT INTO TB_FIN_TRANSACAO (id_transacao, id_usuario, id_categoria, tp_transacao, ds_transacao, vl_transacao) " +
                "VALUES (seq_fintransacao.nextval, ?, ?, ?, ?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, transacao.getIdUsuario());      // ID do usuário
            stmt.setInt(2, transacao.getIdCategoria());    // ID da categoria
            stmt.setString(3, transacao.getTpTransacao()); // Tipo da transação
            stmt.setString(4, transacao.getDsTransacao()); // Descrição da transação
            stmt.setFloat(5, transacao.getVlTransacao());   // Valor da transação

            stmt.executeUpdate();  // Executa a inserção
        }
    }

}
