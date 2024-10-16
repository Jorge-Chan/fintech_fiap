package br.com.fintech.dao;

import br.com.fintech.model.Investimento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InvestimentoDAO {
    private Connection connection;

    public InvestimentoDAO(Connection connection) {
        this.connection = connection;
    }

    // Inserir novo investimento
    public void inserirInvestimento(Investimento investimento) throws SQLException {
        String sql = "INSERT INTO TB_INVESTIMENTO (id_investimento, id_usuario, tb_investimento, mn_investimento, vl_inicial, dt_investimento, vl_rentabilidade, ds_risco, dt_vencimento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, investimento.getIdInvestimento());
            stmt.setInt(2, investimento.getIdUsuario());
            stmt.setString(3, investimento.getTbInvestimento());
            stmt.setString(4, investimento.getMnInvestimento());
            stmt.setFloat(5, investimento.getVlInicial());
            stmt.setDate(6, new java.sql.Date(investimento.getDtInvestimento().getTime()));
            stmt.setFloat(7, investimento.getVlRentabilidade());
            stmt.setString(8, investimento.getDsRisco());
            stmt.setDate(9, new java.sql.Date(investimento.getDtVencimento().getTime()));
            stmt.executeUpdate();
        }
    }

    // Buscar investimento por ID
    public Investimento buscarInvestimentoPorId(int id) throws SQLException {
        String sql = "SELECT * FROM TB_INVESTIMENTO WHERE id_investimento = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Investimento investimento = new Investimento();
                    investimento.setIdInvestimento(rs.getInt("id_investimento"));
                    investimento.setIdUsuario(rs.getInt("id_usuario"));
                    investimento.setTbInvestimento(rs.getString("tb_investimento"));
                    investimento.setMnInvestimento(rs.getString("mn_investimento"));
                    investimento.setVlInicial(rs.getFloat("vl_inicial"));
                    investimento.setDtInvestimento(rs.getDate("dt_investimento"));
                    investimento.setVlRentabilidade(rs.getFloat("vl_rentabilidade"));
                    investimento.setDsRisco(rs.getString("ds_risco"));
                    investimento.setDtVencimento(rs.getDate("dt_vencimento"));
                    return investimento;
                }
            }
        }
        return null;
    }

}















