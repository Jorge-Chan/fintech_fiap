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
        scanner.nextLine(); // Consumir a nova linha após o nextInt()

        System.out.print("Tipo de Investimento: ");
        String tipoInvestimento = scanner.nextLine();

        System.out.print("Nome do Investimento: ");
        String nomeInvestimento = scanner.nextLine();

        System.out.print("Valor Inicial: ");
        float valorInicial = scanner.nextFloat();

        System.out.print("Valor de Rentabilidade: ");
        float valorRentabilidade = scanner.nextFloat();
        scanner.nextLine(); // Consumir a nova linha após o nextFloat()

        System.out.print("Descrição do Risco: ");
        String descricaoRisco = scanner.nextLine();

        try {
            // Criando o objeto Investimento com os dados recebidos
            Investimento investimento = new Investimento(idUsuario, tipoInvestimento, nomeInvestimento, valorInicial, valorRentabilidade, descricaoRisco);

            // Preparando a consulta SQL para inserir um investimento (sem datas)
            String sql = "INSERT INTO TB_FIN_INVESTIMENTO (id_investimento, id_usuario, tp_investimento, nm_investimento, vl_inicial, vl_rentabilidade, ds_risco) VALUES (NULL, ?, ?, ?, ?, ?, ?)";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, investimento.getIdUsuario());
            stmt.setString(2, investimento.getTpInvestimento());  // Corrigido para "tpInvestimento"
            stmt.setString(3, investimento.getMnInvestimento());
            stmt.setFloat(4, investimento.getVlInicial());
            stmt.setFloat(5, investimento.getVlRentabilidade());
            stmt.setString(6, investimento.getDsRisco());

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
