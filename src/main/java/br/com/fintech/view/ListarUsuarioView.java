package br.com.fintech.view;

import br.com.fintech.dao.UsuarioDAO;
import br.com.fintech.factory.ConnectionFactory;
import br.com.fintech.model.Usuario;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class ListarUsuarioView {

    public static void main(String[] args) {
        try {
            // Obtém a conexão usando a ConnectionFactory
            Connection connection = ConnectionFactory.getConnection();

            // Cria a instância do DAO para operações no banco de dados
            UsuarioDAO usuarioDAO = new UsuarioDAO(connection);

            // Exibe o usuário solicitado
            listarUsuario(usuarioDAO);

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados ou realizar operações.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao carregar o driver de banco de dados.");
            e.printStackTrace();
        }
    }

    // Método para listar um usuário por ID
    public static void listarUsuario(UsuarioDAO usuarioDAO) {
        try {
            // Scanner para capturar o ID do usuário
            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite o ID do Usuário que deseja listar: ");
            int idUsuario = scanner.nextInt();

            // Busca o usuário pelo ID
            Usuario usuario = usuarioDAO.buscarUsuarioPorId(idUsuario);

            // Exibe os detalhes do usuário
            if (usuario == null) {
                System.out.println("Usuário com ID " + idUsuario + " não foi encontrado.");
            } else {
                System.out.println("Detalhes do Usuário:");
                System.out.println(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar usuário: " + e.getMessage());
        }
    }
}
