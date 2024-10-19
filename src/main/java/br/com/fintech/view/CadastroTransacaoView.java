package br.com.fintech.view;

import br.com.fintech.dao.TransacaoDAO;
import br.com.fintech.factory.ConnectionFactory;
import br.com.fintech.model.Transacao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class CadastroTransacaoView {
    public static void main(String[] args) {
        try {
            // Obtém a conexão usando a ConnectionFactory
            Connection connection = ConnectionFactory.getConnection();

            // Cria a instância da DAO para operações no banco de dados
            TransacaoDAO transacaoDAO = new TransacaoDAO(connection);
            Scanner scanner = new Scanner(System.in);

            // Chama o método para cadastrar a transação
            cadastrarTransacao(scanner, transacaoDAO);

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao carregar o driver do banco de dados.");
            e.printStackTrace();
        }
    }

    private static void cadastrarTransacao(Scanner scanner, TransacaoDAO transacaoDAO) {
        try {
            System.out.println("Cadastro de Transação");

            System.out.print("Digite o ID do Usuário: ");
            int idUsuario = scanner.nextInt();

            System.out.print("Digite o ID da Categoria: ");
            int idCategoria = scanner.nextInt();
            scanner.nextLine(); // Consome a quebra de linha

            System.out.print("Digite o Tipo de Transação: ");
            String tpTransacao = scanner.nextLine();

            System.out.print("Digite a Descrição da Transação: ");
            String dsTransacao = scanner.nextLine();

            System.out.print("Digite o Valor da Transação: ");
            float vlTransacao = scanner.nextFloat();

            // Criação da instância de Transacao sem o ID e a Data
            Transacao transacao = new Transacao( idUsuario, idCategoria, tpTransacao, dsTransacao, vlTransacao);
            transacaoDAO.inserirTransacao(transacao);

            System.out.println("Transação cadastrada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar a transação.");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao converter a data. Por favor, utilize o formato correto.");
            e.printStackTrace();
        }
    }
}
