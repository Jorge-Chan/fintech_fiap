package br.com.fintech.view;

import br.com.fintech.dao.UsuarioDAO;
import br.com.fintech.exception.EntidadeNaoEcontradaException;
import br.com.fintech.factory.ConnectionFactory;
import br.com.fintech.model.Usuario;

import java.sql.Connection;
import java.sql.SQLException;

public class PesquisaUsuarioPorIdView {
    public static void main(String[] args) {
        try (Connection connection = ConnectionFactory.getConnection()) { // Cria a conexão
            UsuarioDAO dao = new UsuarioDAO(connection); // Passa a conexão para o DAO
            Usuario usuario = dao.pesquisar(Long.valueOf(1));
            System.out.println(usuario.getIdUsuario() + " " + usuario.getNmUsuario() + ", " + usuario.getDsEmail());
            System.out.println(usuario.getDsSenha() + ", " + usuario.getTpUsuario());
        } catch (SQLException e) {
            System.err.println("Erro ao acessar o banco de dados: " + e.getMessage());
        } catch (EntidadeNaoEcontradaException e) {
            System.err.println("ID não existe na tabela: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
