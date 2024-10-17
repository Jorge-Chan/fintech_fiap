package br.com.fintech.view;

import br.com.fintech.dao.TransacaoDAO;
import br.com.fintech.factory.ConnectionFactory;
import br.com.fintech.model.Transacao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ListarTransacaoView {

    public static void main(String[] args) {
        try {
            // Obtém a conexão usando a ConnectionFactory
            Connection connection = ConnectionFactory.getConnection();

            // Cria a instância da DAO para operações no banco de dados
            TransacaoDAO transacaoDAO = new TransacaoDAO(connection);

            // Listar todas as transações
            listarTransacoes(transacaoDAO);

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados ou realizar operações.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao carregar o driver de banco de dados.");
            e.printStackTrace();
        }
    }

    // Método para listar todas as transações
    public static void listarTransacoes(TransacaoDAO transacaoDAO) {
        try {
            // Busca todas as transações no banco de dados
            List<Transacao> transacoes = transacaoDAO.listarTodasTransacoes();

            // Exibe a lista de transações
            if (transacoes.isEmpty()) {
                System.out.println("Nenhuma transação encontrada.");
            } else {
                System.out.println("Lista de Transações:");
                for (Transacao transacao : transacoes) {
                    System.out.println(transacao);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar transações: " + e.getMessage());
        }
    }
}
