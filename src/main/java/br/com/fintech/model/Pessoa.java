package br.com.fintech.model;

public class Pessoa {
    private String nmPessoa;
    private String dsEndereco;
    private String nrTelefone;
    private int idUsuario;

    // Construtor vazio
    public Pessoa() {}

    // Construtor com parâmetros
    public Pessoa(String nmPessoa, String dsEndereco, String nrTelefone) {
        this.nmPessoa = nmPessoa;
        this.dsEndereco = dsEndereco;
        this.nrTelefone = nrTelefone;
        this.idUsuario = idUsuario;
    }

    // Getters e Setters


    public String getNmPessoa() {
        return nmPessoa;
    }

    public void setNmPessoa(String nmPessoa) {
        this.nmPessoa = nmPessoa;
    }

    public String getDsEndereco() {
        return dsEndereco;
    }

    public void setDsEndereco(String dsEndereco) {
        this.dsEndereco = dsEndereco;
    }

    public String getNrTelefone() {
        return nrTelefone;
    }

    public void setNrTelefone(String nrTelefone) {
        this.nrTelefone = nrTelefone;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Pessoa{" +

                ", nmPessoa='" + nmPessoa + '\'' +
                ", dsEndereco='" + dsEndereco + '\'' +
                ", nrTelefone='" + nrTelefone + '\'' +
                ", idUsuario=" + idUsuario +
                '}';
    }
}
