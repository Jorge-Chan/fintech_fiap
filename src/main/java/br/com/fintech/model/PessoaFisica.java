package br.com.fintech.model;

import java.util.Date;

public class PessoaFisica extends Pessoa{ private String dsCpf;
    private Date dtNascimento;

    // Construtor vazio
    public PessoaFisica() {}

    // Construtor com parâmetros
    public PessoaFisica(int idPessoa, String nmPessoa, String dsEndereco, String nrTelefone, int idUsuario, String dsCpf, Date dtNascimento) {
        super(idPessoa, nmPessoa, dsEndereco, nrTelefone, idUsuario);
        this.dsCpf = dsCpf;
        this.dtNascimento = dtNascimento;
    }

    // Getters e Setters
    public String getDsCpf() {
        return dsCpf;
    }

    public void setDsCpf(String dsCpf) {
        this.dsCpf = dsCpf;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    @Override
    public String toString() {
        return "PessoaFisica{" +
                "dsCpf='" + dsCpf + '\'' +
                ", dtNascimento=" + dtNascimento +
                "} " + super.toString();
    }
}
