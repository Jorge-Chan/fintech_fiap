package br.com.fintech.view;

import br.com.fintech.dao.PessoaDAO;
import br.com.fintech.factory.ConnectionFactory;
import br.com.fintech.model.Pessoa;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ListarPessoaView {

    public static void main(String[] args) {
        try {
            // Obtém a conexão usando a ConnectionFactory
            Connection connection = ConnectionFactory.getConnection();

            // Cria a instância do DAO para operações no banco de dados
            PessoaDAO pessoaDAO = new PessoaDAO(connection);

            // Menu para listar todas as pessoas ou buscar uma por ID
            menu(pessoaDAO);

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados ou realizar operações.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao carregar o driver de banco de dados.");
            e.printStackTrace();
        }
    }

    // Menu de opções para listar todas as pessoas ou buscar uma por ID
    public static void menu(PessoaDAO pessoaDAO) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha uma opção:");
        System.out.println("1. Listar todas as pessoas");
        System.out.println("2. Buscar pessoa por ID");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                listarTodasPessoas(pessoaDAO);
                break;
            case 2:
                buscarPessoaPorId(pessoaDAO);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    // Método para listar todas as pessoas
    public static void listarTodasPessoas(PessoaDAO pessoaDAO) {
        try {
            List<Pessoa> pessoas = pessoaDAO.listarTodasPessoas();
            if (pessoas.isEmpty()) {
                System.out.println("Nenhuma pessoa encontrada.");
            } else {
                System.out.println("Lista de Pessoas:");
                for (Pessoa pessoa : pessoas) {
                    System.out.println(pessoa);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar pessoas: " + e.getMessage());
        }
    }

    // Método para buscar uma pessoa por ID
    public static void buscarPessoaPorId(PessoaDAO pessoaDAO) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite o ID da Pessoa que deseja buscar: ");
            int idPessoa = scanner.nextInt();

            Pessoa pessoa = pessoaDAO.buscarPessoaPorId(idPessoa);

            if (pessoa == null) {
                System.out.println("Pessoa com ID " + idPessoa + " não foi encontrada.");
            } else {
                System.out.println("Detalhes da Pessoa:");
                System.out.println(pessoa);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar pessoa: " + e.getMessage());
        }
    }
}
