package br.com.fintech.view;

import br.com.fintech.dao.PessoaJuridicaDAO;
import br.com.fintech.factory.ConnectionFactory;
import br.com.fintech.model.PessoaJuridica;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class CadastroPessoaJuridicaView {   public static void main(String[] args) {
    try {
        // Obtém a conexão usando a ConnectionFactory
        Connection connection = ConnectionFactory.getConnection();

        // Cria a instância da DAO
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO(connection);

        // Captura os dados da nova Pessoa Jurídica
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cadastro de Pessoa Jurídica");

        System.out.print("Digite o nome da Pessoa: ");
        String nmPessoa = scanner.nextLine();

        System.out.print("Digite o Endereço: ");
        String dsEndereco = scanner.nextLine();

        System.out.print("Digite o Telefone: ");
        String nrTelefone = scanner.nextLine();

        System.out.print("Digite o CNPJ: ");
        String dsCnpj = scanner.nextLine();

        System.out.print("Digite a Razão Social: ");
        String nmRazaoSocial = scanner.nextLine();

        // Cria uma nova instância de PessoaJuridica com todos os parâmetros necessários
        PessoaJuridica pessoaJuridica = new PessoaJuridica(
                 nmPessoa, dsEndereco, nrTelefone, dsCnpj, nmRazaoSocial);

        // Adiciona a Pessoa Jurídica ao banco de dados
        pessoaJuridicaDAO.adicionar(pessoaJuridica);

        System.out.println("Pessoa Jurídica cadastrada com sucesso!");

    } catch (SQLException e) {
        System.out.println("Erro ao conectar ao banco de dados ou ao cadastrar Pessoa Jurídica.");
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        System.out.println("Erro ao carregar o driver de banco de dados.");
        e.printStackTrace();
    }
}
}
