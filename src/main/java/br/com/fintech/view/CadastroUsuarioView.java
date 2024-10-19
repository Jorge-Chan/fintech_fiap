package br.com.fintech.view;
import br.com.fintech.dao.UsuarioDAO;
import br.com.fintech.factory.ConnectionFactory;
import br.com.fintech.model.Usuario;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
public class CadastroUsuarioView {    public static void main(String[] args) {
    try {
        // Obtém a conexão usando a ConnectionFactory
        Connection connection = ConnectionFactory.getConnection();

        // Cria a instância da DAO para operações no banco de dados
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Captura os dados do novo usuário
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cadastro de Usuário");


        System.out.print("Digite o Nome do Usuário: ");
        String nmUsuario = scanner.nextLine();

        System.out.print("Digite o E-mail do Usuário: ");
        String dsEmail = scanner.nextLine();

        System.out.print("Digite a Senha do Usuário: ");
        String dtSenha = scanner.nextLine();


        System.out.print("Digite o Tipo de Usuário (Ex: Admin, Padrão): ");
        String tpUsuario = scanner.nextLine();

        // Cria uma nova instância de Usuario
        Usuario usuario = new Usuario(nmUsuario, dsEmail, dtSenha, tpUsuario);

        // Adiciona o usuário ao banco de dados
        usuarioDAO.inserirUsuario(usuario);

        System.out.println("Usuário cadastrado com sucesso!");

    } catch (SQLException e) {
        System.out.println("Erro ao conectar ao banco de dados ou ao cadastrar o usuário.");
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        System.out.println("Erro ao carregar o driver de banco de dados.");
        e.printStackTrace();
    }
    }
}
