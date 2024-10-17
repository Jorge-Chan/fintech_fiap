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

        switch (opcao) {
            case 1:
                listarTodasPessoasFisicas(pessoaFisicaDAO);
                break;
            case 2:
                buscarPessoaFisicaPorId(pessoaFisicaDAO);
                break;
            case 3:
                adicionarPessoaFisica(pessoaFisicaDAO);
                break;
            case 4:
                atualizarPessoaFisica(pessoaFisicaDAO);
                break;
            case 5:
                removerPessoaFisica(pessoaFisicaDAO);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    // Método para listar todas as Pessoas Físicas
    public static void listarTodasPessoasFisicas(PessoaFisicaDAO pessoaFisicaDAO) {
        try {
            System.out.println("Implementação pendente de listar todas as pessoas físicas.");
        } catch (Exception e) {
            System.out.println("Erro ao listar pessoas físicas: " + e.getMessage());
        }
    }

    // Método para buscar uma Pessoa Física por ID
    public static void buscarPessoaFisicaPorId(PessoaFisicaDAO pessoaFisicaDAO) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite o ID da Pessoa Física que deseja buscar: ");
            int idPessoa = scanner.nextInt();

            PessoaFisica pessoaFisica = pessoaFisicaDAO.buscarPorId(idPessoa);

            if (pessoaFisica == null) {
                System.out.println("Pessoa Física com ID " + idPessoa + " não foi encontrada.");
            } else {
                System.out.println("Detalhes da Pessoa Física:");
                System.out.println(pessoaFisica);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar pessoa física: " + e.getMessage());
        }
    }

    // Método para adicionar uma nova Pessoa Física
    public static void adicionarPessoaFisica(PessoaFisicaDAO pessoaFisicaDAO) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite o ID da Pessoa: ");
            int idPessoa = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do Scanner

            System.out.print("Digite o CPF: ");
            String dsCpf = scanner.nextLine();

            System.out.print("Digite a data de nascimento (yyyy-mm-dd): ");
            String dtNascimentoInput = scanner.nextLine();
            Date dtNascimento = java.sql.Date.valueOf(dtNascimentoInput); // Converte para java.sql.Date

            PessoaFisica novaPessoaFisica = new PessoaFisica(idPessoa, dsCpf, (java.sql.Date) dtNascimento);
            pessoaFisicaDAO.adicionar(novaPessoaFisica);

            System.out.println("Pessoa física adicionada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao adicionar pessoa física: " + e.getMessage());
        }
    }

    // Método para atualizar uma Pessoa Física
    public static void atualizarPessoaFisica(PessoaFisicaDAO pessoaFisicaDAO) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite o ID da Pessoa Física a ser atualizada: ");
            int idPessoa = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do Scanner

            System.out.print("Digite o novo CPF: ");
            String dsCpf = scanner.nextLine();

            System.out.print("Digite a nova data de nascimento (yyyy-mm-dd): ");
            String dtNascimentoInput = scanner.nextLine();
            Date dtNascimento = java.sql.Date.valueOf(dtNascimentoInput); // Converte para java.sql.Date

            PessoaFisica pessoaFisica = pessoaFisicaDAO.buscarPorId(idPessoa);
            if (pessoaFisica == null) {
                System.out.println("Pessoa Física com ID " + idPessoa + " não encontrada.");
                return;
            }

            pessoaFisica.setDsCpf(dsCpf);
            pessoaFisica.setDtNascimento(dtNascimento);

            pessoaFisicaDAO.atualizar(pessoaFisica);

            System.out.println("Pessoa física atualizada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar pessoa física: " + e.getMessage());
        }
    }

    // Método para remover uma Pessoa Física
    public static void removerPessoaFisica(PessoaFisicaDAO pessoaFisicaDAO) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite o ID da Pessoa Física a ser removida: ");
            int idPessoa = scanner.nextInt();

            pessoaFisicaDAO.remover(idPessoa);

            System.out.println("Pessoa física removida com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao remover pessoa física: " + e.getMessage());
        }
    }
}
