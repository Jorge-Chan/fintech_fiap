package br.com.fintech.view;

import br.com.fintech.dao.PessoaFisicaDAO;
import br.com.fintech.factory.ConnectionFactory;
import br.com.fintech.model.PessoaFisica;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class CadastroPessoaFisicaView {
    public static void main(String[] args) {
        try {
            // Obtém a conexão usando a ConnectionFactory
            Connection connection = ConnectionFactory.getConnection();

            // Cria a instância da DAO
            PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO(connection);

            // Captura os dados da nova Pessoa Física
            Scanner scanner = new Scanner(System.in);

            System.out.println("Cadastro de Pessoa Física");
            System.out.print("Digite o ID da Pessoa: ");
            int idPessoa = scanner.nextInt();
            scanner.nextLine(); // consome a quebra de linha

            System.out.print("Digite o nome da Pessoa: ");
            String nmPessoa = scanner.nextLine();

            System.out.print("Digite o Endereço: ");
            String dsEndereco = scanner.nextLine();

            System.out.print("Digite o Telefone: ");
            String nrTelefone = scanner.nextLine();

            System.out.print("Digite o ID do Usuário: ");
            int idUsuario = scanner.nextInt();
            scanner.nextLine(); // consome a quebra de linha

            System.out.print("Digite o CPF: ");
            String dsCpf = scanner.nextLine();

            System.out.print("Digite a Data de Nascimento (dd/MM/yyyy): ");
            String dtNascimentoStr = scanner.nextLine();
            Date dtNascimento = new java.text.SimpleDateFormat("dd/MM/yyyy").parse(dtNascimentoStr);

            // Cria uma nova instância de PessoaFisica com todos os parâmetros necessários
            PessoaFisica pessoaFisica = new PessoaFisica(
                    idPessoa, nmPessoa, dsEndereco, nrTelefone, idUsuario, dsCpf, dtNascimento);

            // Adiciona a Pessoa Física ao banco de dados
            pessoaFisicaDAO.adicionar(pessoaFisica);

            System.out.println("Pessoa Física cadastrada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados ou ao cadastrar Pessoa Física.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao carregar o driver de banco de dados.");
            e.printStackTrace();
        } catch (java.text.ParseException e) {
            System.out.println("Erro ao converter a data de nascimento.");
            e.printStackTrace();
        }
    }
}
