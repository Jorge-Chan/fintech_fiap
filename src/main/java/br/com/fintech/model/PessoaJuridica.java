package br.com.fintech.model;

public class PessoaJuridica  extends Pessoa {  private String dsCnpj;
    private String nmRazaoSocial;

    // Construtor vazio
    public PessoaJuridica(int idPessoa, String dsCnpj, String nmRazaoSocial) {}

    // Construtor com parâmetros
    public PessoaJuridica(int idPessoa, String nmPessoa, String dsEndereco, String nrTelefone, int idUsuario, String dsCnpj, String nmRazaoSocial) {
        super(idPessoa, nmPessoa, dsEndereco, nrTelefone, idUsuario);
        this.dsCnpj = dsCnpj;
        this.nmRazaoSocial = nmRazaoSocial;
    }

    // Getters e Setters
    public String getDsCnpj() {
        return dsCnpj;
    }

    public void setDsCnpj(String dsCnpj) {
        this.dsCnpj = dsCnpj;
    }

    public String getNmRazaoSocial() {
        return nmRazaoSocial;
    }

    public void setNmRazaoSocial(String nmRazaoSocial) {
        this.nmRazaoSocial = nmRazaoSocial;
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "dsCnpj='" + dsCnpj + '\'' +
                ", nmRazaoSocial='" + nmRazaoSocial + '\'' +
                "} " + super.toString();
    }
}
