package br.com.fintech.view;

import br.com.fintech.dao.PessoaJuridicaDAO;
import br.com.fintech.factory.ConnectionFactory;
import br.com.fintech.model.PessoaJuridica;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class ListarPessoaJuridicaView {

    public static void main(String[] args) {
        try {
            // Obtém a conexão usando a ConnectionFactory
            Connection connection = ConnectionFactory.getConnection();

            // Cria a instância do DAO para operações no banco de dados
            PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO(connection);

            // Chama o menu para realizar as operações
            menu(pessoaJuridicaDAO);

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados ou realizar operações.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao carregar o driver de banco de dados.");
            e.printStackTrace();
        }
    }

    // Menu de opções para listar, buscar, adicionar, atualizar ou remover Pessoa Jurídica
    public static void menu(PessoaJuridicaDAO pessoaJuridicaDAO) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha uma opção:");
        System.out.println("1. Listar todas as pessoas jurídicas");
        System.out.println("2. Buscar pessoa jurídica por ID");
        System.out.println("3. Adicionar nova pessoa jurídica");
        System.out.println("4. Atualizar pessoa jurídica");
        System.out.println("5. Remover pessoa jurídica");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                listarTodasPessoasJuridicas(pessoaJuridicaDAO);
                break;
            case 2:
                buscarPessoaJuridicaPorId(pessoaJuridicaDAO);
                break;
            case 3:
                adicionarPessoaJuridica(pessoaJuridicaDAO);
                break;
            case 4:
                atualizarPessoaJuridica(pessoaJuridicaDAO);
                break;
            case 5:
                removerPessoaJuridica(pessoaJuridicaDAO);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    // Método para listar todas as Pessoas Jurídicas (implementação pendente)
    public static void listarTodasPessoasJuridicas(PessoaJuridicaDAO pessoaJuridicaDAO) {
        try {
            System.out.println("Implementação pendente de listar todas as pessoas jurídicas.");
        } catch (Exception e) {
            System.out.println("Erro ao listar pessoas jurídicas: " + e.getMessage());
        }
    }

    // Método para buscar uma Pessoa Jurídica por ID
    public static void buscarPessoaJuridicaPorId(PessoaJuridicaDAO pessoaJuridicaDAO) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite o ID da Pessoa Jurídica que deseja buscar: ");
            int idPessoa = scanner.nextInt();

            PessoaJuridica pessoaJuridica = pessoaJuridicaDAO.buscarPorId(idPessoa);

            if (pessoaJuridica == null) {
                System.out.println("Pessoa Jurídica com ID " + idPessoa + " não foi encontrada.");
            } else {
                System.out.println("Detalhes da Pessoa Jurídica:");
                System.out.println(pessoaJuridica);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar pessoa jurídica: " + e.getMessage());
        }
    }

    // Método para adicionar uma nova Pessoa Jurídica
    public static void adicionarPessoaJuridica(PessoaJuridicaDAO pessoaJuridicaDAO) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite o ID da Pessoa: ");
            int idPessoa = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do Scanner

            System.out.print("Digite o CNPJ: ");
            String dsCnpj = scanner.nextLine();

            System.out.print("Digite a Razão Social: ");
            String nmRazaoSocial = scanner.nextLine();

            PessoaJuridica novaPessoaJuridica = new PessoaJuridica(idPessoa, dsCnpj, nmRazaoSocial);
            pessoaJuridicaDAO.adicionar(novaPessoaJuridica);

            System.out.println("Pessoa jurídica adicionada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao adicionar pessoa jurídica: " + e.getMessage());
        }
    }

    // Método para atualizar uma Pessoa Jurídica
    public static void atualizarPessoaJuridica(PessoaJuridicaDAO pessoaJuridicaDAO) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite o ID da Pessoa Jurídica a ser atualizada: ");
            int idPessoa = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do Scanner

            System.out.print("Digite o novo CNPJ: ");
            String dsCnpj = scanner.nextLine();

            System.out.print("Digite a nova Razão Social: ");
            String nmRazaoSocial = scanner.nextLine();

            PessoaJuridica pessoaJuridica = pessoaJuridicaDAO.buscarPorId(idPessoa);
            if (pessoaJuridica == null) {
                System.out.println("Pessoa Jurídica com ID " + idPessoa + " não encontrada.");
                return;
            }

            pessoaJuridica.setDsCnpj(dsCnpj);
            pessoaJuridica.setNmRazaoSocial(nmRazaoSocial);

            pessoaJuridicaDAO.atualizar(pessoaJuridica);

            System.out.println("Pessoa jurídica atualizada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar pessoa jurídica: " + e.getMessage());
        }
    }

    // Método para remover uma Pessoa Jurídica
    public static void removerPessoaJuridica(PessoaJuridicaDAO pessoaJuridicaDAO) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite o ID da Pessoa Jurídica a ser removida: ");
            int idPessoa = scanner.nextInt();

            pessoaJuridicaDAO.remover(idPessoa);

            System.out.println("Pessoa jurídica removida com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao remover pessoa jurídica: " + e.getMessage());
        }
    }
}
