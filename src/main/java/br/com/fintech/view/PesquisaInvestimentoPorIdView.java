package br.com.fintech.view;

import br.com.fintech.dao.InvestimentoDAO;
import br.com.fintech.exception.EntidadeNaoEcontradaException; // Corrigido
import br.com.fintech.factory.ConnectionFactory;
import br.com.fintech.model.Investimento; // Certifique-se de que o modelo Investimento está importado

import java.sql.Connection;
import java.sql.SQLException;

public class PesquisaInvestimentoPorIdView {
    public static void main(String[] args) {
        try (Connection connection = ConnectionFactory.getConnection()) { // Cria a conexão
            InvestimentoDAO dao = new InvestimentoDAO(connection); // Passa a conexão para o DAO
            Investimento investimento = dao.pesquisar(1L); // Usando 1L para um valor Long

            if (investimento != null) { // Verifica se o investimento foi encontrado
                System.out.println(investimento.getIdInvestimento() + " " + investimento.getIdUsuario() + " " + investimento.getTbInvestimento() + ", " + investimento.getMnInvestimento());
                System.out.printf("R$: %.2f, R$: %.2f%n", investimento.getVlInicial(), investimento.getVlRentabilidade());
            } else {
                System.err.println("Investimento não encontrado.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao acessar o banco de dados: " + e.getMessage());
        } catch (EntidadeNaoEcontradaException e) { // Corrigido
            System.err.println("ID não existe na tabela: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Classe não encontrada: " + e.getMessage(), e);
        }
    }
}