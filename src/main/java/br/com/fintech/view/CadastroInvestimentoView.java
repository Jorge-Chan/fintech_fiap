package br.com.fintech.view;

import br.com.fintech.dao.InvestimentoDAO;
import br.com.fintech.factory.ConnectionFactory;
import br.com.fintech.model.Investimento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CadastroInvestimentoView {

    private Connection connection;

    // Construtor que recebe a conexão com o banco de dados
    public CadastroInvestimentoView(ConnectionFactory connectionFactory) throws SQLException, ClassNotFoundException {
        this.connection = connectionFactory.getConnection(); // Inicializando a conexão
    }

    // Método para cadastrar um investimento (sem datas)
    public void cadastrarInvestimento() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Cadastro de Investimento ===");

        System.out.print("ID do Usuário: ");
        int idUsuario = scanner.nextInt();

        System.out.print("Tipo de Investimento: ");
        String tipoInvestimento = scanner.next();

        System.out.print("Nome do Investimento: ");
        String nomeInvestimento = scanner.next();

        System.out.print("Valor Inicial: ");
        float valorInicial = scanner.nextFloat();

        System.out.print("Valor de Rentabilidade: ");
        float valorRentabilidade = scanner.nextFloat();

        System.out.print("Descrição do Risco: ");
        String descricaoRisco = scanner.next();

        try {
            // Preparando a consulta SQL para inserir um investimento (sem datas)
            String sql = "INSERT INTO TB_FIN_INVESTIMENTO (id_usuario, tp_investimo, nm_investimento, vl_inicial, vl_rentabilidade, ds_risco) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idUsuario);
            stmt.setString(2, tipoInvestimento);
            stmt.setString(3, nomeInvestimento);
            stmt.setFloat(4, valorInicial);
            stmt.setFloat(5, valorRentabilidade);
            stmt.setString(6, descricaoRisco);

            // Executando a inserção no banco de dados
            stmt.executeUpdate();
            stmt.close();

            System.out.println("Investimento cadastrado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao cadastrar o investimento.");
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory(); // Inicializando a ConnectionFactory
        CadastroInvestimentoView view = new CadastroInvestimentoView(connectionFactory); // Instanciando a view
        view.cadastrarInvestimento(); // Chamando o método de cadastro
    }
}
