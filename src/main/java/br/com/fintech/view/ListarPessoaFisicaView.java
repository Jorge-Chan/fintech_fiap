package br.com.fintech.view;

import br.com.fintech.dao.PessoaFisicaDAO;
import br.com.fintech.factory.ConnectionFactory;
import br.com.fintech.model.PessoaFisica;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class ListarPessoaFisicaView {

    public static void main(String[] args) {
        try {
            // Obtém a conexão usando a ConnectionFactory
            Connection connection = ConnectionFactory.getConnection();

            // Cria a instância do DAO para operações no banco de dados
            PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO(connection);

            // Menu para listar, buscar, adicionar, atualizar ou remover uma Pessoa Física
            menu(pessoaFisicaDAO);

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados ou realizar operações.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao carregar o driver de banco de dados.");
            e.printStackTrace();
        }
    }

    // Menu de opções para listar, buscar, adicionar, atualizar ou remover Pessoa Física
    public static void menu(PessoaFisicaDAO pessoaFisicaDAO) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha uma opção:");
        System.out.println("1. Listar todas as pessoas físicas");
        System.out.println("2. Buscar pessoa física por ID");
        System.out.println("3. Adicionar nova pessoa física");
        System.out.println("4. Atualizar pessoa física");
        System.out.println("5. Remover pessoa física");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();

    }

    // Método para listar todas as Pessoas Físicas
    public static void listarTodasPessoasFisicas(PessoaFisicaDAO pessoaFisicaDAO) {
        try {
            System.out.println("Implementação pendente de listar todas as pessoas físicas.");
        } catch (Exception e) {
            System.out.println("Erro ao listar pessoas físicas: " + e.getMessage());
        }
    }

}