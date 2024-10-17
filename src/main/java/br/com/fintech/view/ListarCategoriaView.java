package br.com.fintech.view;

import br.com.fintech.dao.CategoriaDAO;
import br.com.fintech.factory.ConnectionFactory;
import br.com.fintech.model.Categoria;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ListarCategoriaView {

    public static void main(String[] args) {
        try {
            // Obtém a conexão usando a ConnectionFactory
            Connection connection = ConnectionFactory.getConnection();

            // Cria a instância da DAO para operações no banco de dados
            CategoriaDAO categoriaDAO = new CategoriaDAO(connection);

            // Listar todas as categorias
            listarCategorias(categoriaDAO);

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados ou realizar operações.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao carregar o driver de banco de dados.");
            e.printStackTrace();
        }
    }

    // Método para listar todas as categorias
    public static void listarCategorias(CategoriaDAO categoriaDAO) {
        try {
            // Busca todas as categorias no banco de dados
            List<Categoria> categorias = categoriaDAO.listarTodasCategorias();

            // Exibe a lista de categorias
            if (categorias.isEmpty()) {
                System.out.println("Nenhuma categoria encontrada.");
            } else {
                System.out.println("Lista de Categorias:");
                for (Categoria categoria : categorias) {
                    System.out.println(categoria);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar categorias: " + e.getMessage());
        }
    }
}
