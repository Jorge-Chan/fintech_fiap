package br.com.fintech.view;
import br.com.fintech.dao.CategoriaDAO;
import br.com.fintech.factory.ConnectionFactory;
import br.com.fintech.model.Categoria;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class CadastroCategoriaView { public static void main(String[] args) {
    try {
        // Obtém a conexão usando a ConnectionFactory
        Connection connection = ConnectionFactory.getConnection();

        // Cria a instância da DAO para operar sobre as categorias
        CategoriaDAO categoriaDAO = new CategoriaDAO(connection);

        // Captura os dados da nova Categoria
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cadastro de Categoria");

        System.out.print("Digite o ID da Categoria: ");
        int idCategoria = scanner.nextInt();
        scanner.nextLine(); // consome a quebra de linha

        System.out.print("Digite o Nome da Categoria: ");
        String nmCategoria = scanner.nextLine();

        System.out.print("Digite o Tipo da Categoria (Ex: Receita, Despesa): ");
        String tpCategoria = scanner.nextLine();

        // Cria uma nova instância de Categoria
        Categoria categoria = new Categoria(idCategoria, nmCategoria, tpCategoria);

        // Adiciona a Categoria ao banco de dados
        categoriaDAO.inserirCategoria(categoria);

        System.out.println("Categoria cadastrada com sucesso!");

    } catch (SQLException e) {
        System.out.println("Erro ao conectar ao banco de dados ou ao cadastrar Categoria.");
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        System.out.println("Erro ao carregar o driver de banco de dados.");
        e.printStackTrace();
    }
}
}