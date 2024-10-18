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
        String sql = "INSERT INTO TB_FIN_CATEGORIA (id_categoria, nm_categoria, tp_categoria) VALUES (1, 'feifão', 'feijão')";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, categoria.getIdCategoria());
            stmt.setString(2, categoria.getNmCategoria());
            stmt.setString(3, categoria.getTpCategoria());

            stmt.executeUpdate();
        }
    }

    // Método para buscar uma Categoria por ID (id_categoria)
    public Categoria buscarCategoriaPorId(int id) throws SQLException {
        String sql = "SELECT id_categoria, nm_categoria, tp_categoria FROM TB_FIN_CATEGORIA WHERE id_categoria = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Categoria categoria = new Categoria();
                    categoria.setIdCategoria(rs.getInt("id_categoria"));
                    categoria.setNmCategoria(rs.getString("nm_categoria"));
                    categoria.setTpCategoria(rs.getString("tp_categoria"));

                    return categoria;
                }
            }
        }
        return null;
    }

    // Método para listar todas as Categorias
    public List<Categoria> listarTodasCategorias() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT id_categoria, nm_categoria, tp_categoria FROM TB_FIN_CATEGORIA";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setNmCategoria(rs.getString("nm_categoria"));
                categoria.setTpCategoria(rs.getString("tp_categoria"));

                categorias.add(categoria);
            }
        }
        return categorias;
    }
    public void fecharConexao() throws SQLException {
        connection.close();
    }


}