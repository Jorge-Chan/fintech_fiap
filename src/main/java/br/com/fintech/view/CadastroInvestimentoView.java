package br.com.fintech.view;
import br.com.fintech.dao.InvestimentoDAO;
import br.com.fintech.factory.ConnectionFactory;
import br.com.fintech.model.Investimento;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;
public class CadastroInvestimentoView {
    public static void main(String[] args) {
        try {
            // Obtém a conexão usando a ConnectionFactory
            Connection connection = ConnectionFactory.getConnection();

            // Cria a instância da DAO para operações no banco de dados
            InvestimentoDAO investimentoDAO = new InvestimentoDAO(connection);

            // Captura os dados do novo investimento
            Scanner scanner = new Scanner(System.in);

            System.out.println("Cadastro de Investimento");

            System.out.print("Digite o ID do Investimento: ");
            int idInvestimento = scanner.nextInt();

            System.out.print("Digite o ID do Usuário: ");
            int idUsuario = scanner.nextInt();
            scanner.nextLine(); // consome a quebra de linha

            System.out.print("Digite a Tipo de Investimento: ");
            String tbInvestimento = scanner.nextLine();

            System.out.print("Digite a Modalidade de Investimento: ");
            String mnInvestimento = scanner.nextLine();

            System.out.print("Digite o Valor Inicial: ");
            float vlInicial = scanner.nextFloat();

            System.out.print("Digite a Data do Investimento (Formato: YYYY-MM-DD): ");
            String dtInvestimentoStr = scanner.next();
            Date dtInvestimento = java.sql.Date.valueOf(dtInvestimentoStr);

            System.out.print("Digite a Rentabilidade: ");
            float vlRentabilidade = scanner.nextFloat();

            scanner.nextLine(); // consome a quebra de linha
            System.out.print("Digite a Descrição do Risco: ");
            String dsRisco = scanner.nextLine();

            System.out.print("Digite a Data de Vencimento (Formato: YYYY-MM-DD): ");
            String dtVencimentoStr = scanner.next();
            Date dtVencimento = java.sql.Date.valueOf(dtVencimentoStr);

            // Cria uma nova instância de Investimento
            Investimento investimento = new Investimento(idInvestimento, idUsuario, tbInvestimento, mnInvestimento,
                    vlInicial, dtInvestimento, vlRentabilidade, dsRisco, dtVencimento);

            // Adiciona o investimento ao banco de dados
            investimentoDAO.inserirInvestimento(investimento);

            System.out.println("Investimento cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados ou ao cadastrar o investimento.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao carregar o driver de banco de dados.");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao converter a data. Por favor, utilize o formato correto.");
            e.printStackTrace();
        }
    }
}
