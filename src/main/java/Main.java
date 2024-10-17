
import br.com.fintech.dao.TransacaoDAO;
import br.com.fintech.dao.UsuarioDAO;
import br.com.fintech.factory.ConnectionFactory;

import br.com.fintech.model.Transacao;

import br.com.fintech.model.Usuario;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {public static void main(String[] args) {
    try {
        // Obtém a conexão usando a ConnectionFactory
        Connection connection = ConnectionFactory.getConnection();

        // Cria as instâncias dos DAOs
        UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
        TransacaoDAO transacaoDAO = new TransacaoDAO(connection);

        // Cria um scanner para capturar as entradas do usuário
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            // Exibe o menu principal
            System.out.println("\n=== Sistema Fintech ===");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Listar Usuário");
            System.out.println("3. Cadastrar Transação");
            System.out.println("4. Listar Transações");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    cadastrarUsuario(scanner, usuarioDAO);
                    break;
                case 2:
                    listarUsuario(scanner, usuarioDAO);
                    break;
                case 3:
                    cadastrarTransacao(scanner, transacaoDAO);
                    break;
                case 4:
                    listarTransacoes(transacaoDAO);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 0);

    } catch (SQLException | ClassNotFoundException e) {
        System.out.println("Erro ao conectar ao banco de dados.");
        e.printStackTrace();
    }
}

    // Método para cadastrar um novo usuário
    private static void cadastrarUsuario(Scanner scanner, UsuarioDAO usuarioDAO) {
        try {
            System.out.println("=== Cadastro de Usuário ===");

            System.out.print("Digite o ID do Usuário: ");
            int idUsuario = scanner.nextInt();
            scanner.nextLine(); // consome a quebra de linha

            System.out.print("Digite o Nome do Usuário: ");
            String nmUsuario = scanner.nextLine();

            System.out.print("Digite o E-mail do Usuário: ");
            String dsEmail = scanner.nextLine();

            System.out.print("Digite a Senha do Usuário: ");
            String dtSenha = scanner.nextLine();

            Date dtCadastro = new Date();

            System.out.print("Digite o Tipo de Usuário (Ex: Admin, Padrão): ");
            String tpUsuario = scanner.nextLine();

            // Cria e insere o novo usuário no banco de dados
            Usuario usuario = new Usuario(idUsuario, nmUsuario, dsEmail, dtSenha, dtCadastro, tpUsuario);
            usuarioDAO.inserirUsuario(usuario);

            System.out.println("Usuário cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar o usuário.");
            e.printStackTrace();
        }
    }

    // Método para listar um usuário por ID
    private static void listarUsuario(Scanner scanner, UsuarioDAO usuarioDAO) {
        try {
            System.out.println("=== Listar Usuário ===");

            System.out.print("Digite o ID do Usuário: ");
            int idUsuario = scanner.nextInt();

            Usuario usuario = usuarioDAO.buscarUsuarioPorId(idUsuario);

            if (usuario == null) {
                System.out.println("Usuário com ID " + idUsuario + " não foi encontrado.");
            } else {
                System.out.println("Detalhes do Usuário:");
                System.out.println(usuario);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar o usuário.");
            e.printStackTrace();
        }
    }

    // Método para cadastrar uma nova transação
    private static void cadastrarTransacao(Scanner scanner, TransacaoDAO transacaoDAO) {
        try {
            System.out.println("=== Cadastro de Transação ===");

            System.out.print("Digite o ID da Transação: ");
            int idTransacao = scanner.nextInt();

            System.out.print("Digite o ID do Usuário: ");
            int idUsuario = scanner.nextInt();

            System.out.print("Digite o ID da Categoria: ");
            int idCategoria = scanner.nextInt();
            scanner.nextLine(); // consome a quebra de linha

            System.out.print("Digite o Tipo de Transação: ");
            String tpTransacao = scanner.nextLine();

            System.out.print("Digite a Descrição da Transação: ");
            String dsTransacao = scanner.nextLine();

            System.out.print("Digite o Valor da Transação: ");
            float vlTransacao = scanner.nextFloat();

            System.out.print("Digite a Data da Transação (Formato: YYYY-MM-DD): ");
            String dtTransacaoStr = scanner.next();
            Date dtTransacao = java.sql.Date.valueOf(dtTransacaoStr);

            Transacao transacao = new Transacao(idTransacao, idUsuario, idCategoria, tpTransacao, dsTransacao, vlTransacao, dtTransacao);
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

    // Método para listar todas as transações
    private static void listarTransacoes(TransacaoDAO transacaoDAO) {
        try {
            System.out.println("=== Lista de Transações ===");

            List<Transacao> transacoes = transacaoDAO.listarTodasTransacoes();

            if (transacoes.isEmpty()) {
                System.out.println("Nenhuma transação encontrada.");
            } else {
                for (Transacao transacao : transacoes) {
                    System.out.println(transacao);
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar as transações.");
            e.printStackTrace();
        }
    }
}

