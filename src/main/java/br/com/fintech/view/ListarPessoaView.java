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



        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados ou realizar operações.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao carregar o driver de banco de dados.");
            e.printStackTrace();
        }
    }



}
