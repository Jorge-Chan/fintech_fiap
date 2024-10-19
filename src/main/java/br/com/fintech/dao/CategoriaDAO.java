package br.com.fintech.dao;

import br.com.fintech.model.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    private Connection connection;

    public CategoriaDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para inserir uma nova Categoria
    public void inserirCategoria(Categoria categoria) throws SQLException {
        String sql = "INSERT INTO TB_FIN_CATEGORIA (id_categoria, nm_categoria, tp_categoria) VALUES (seq_categoria.nextval,?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, categoria.getNmCategoria());
            stmt.setString(2, categoria.getTpCategoria());

            stmt.executeUpdate();
        }
    }





}