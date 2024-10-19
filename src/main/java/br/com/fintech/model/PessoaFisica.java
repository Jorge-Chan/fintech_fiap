package br.com.fintech.model;

public class PessoaFisica extends Pessoa {
    private String dsCpf;

    // Construtor vazio
    public PessoaFisica() {
        // Chama o construtor da superclasse
        super();
    }

    // Construtor com parâmetros
    public PessoaFisica(String nmPessoa, String dsEndereco, String nrTelefone, String dsCpf) {
        super(nmPessoa, dsEndereco, nrTelefone);
        this.dsCpf = dsCpf;
    }

    // Getters e Setters
    public String getDsCpf() {
        return dsCpf;
    }

    public void setDsCpf(String dsCpf) {
        this.dsCpf = dsCpf;
    }

    @Override
    public String toString() {
        return "PessoaFisica{" +
                "dsCpf='" + dsCpf + '\'' +
                "} " + super.toString();
    }
}
