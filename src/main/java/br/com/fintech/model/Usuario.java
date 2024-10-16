package br.com.fintech.model;

import java.util.Date;

public class Usuario {    private int idUsuario;
    private String nmUsuario;
    private String dsEmail;
    private String dtSenha;
    private Date dtCadastro;
    private String tpUsuario;

    // Construtor vazio
    public Usuario() {}

    // Construtor com parâmetros
    public Usuario(int idUsuario, String nmUsuario, String dsEmail, String dtSenha, Date dtCadastro, String tpUsuario) {
        this.idUsuario = idUsuario;
        this.nmUsuario = nmUsuario;
        this.dsEmail = dsEmail;
        this.dtSenha = dtSenha;
        this.dtCadastro = dtCadastro;
        this.tpUsuario = tpUsuario;
    }

    // Getters e Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNmUsuario() {
        return nmUsuario;
    }

    public void setNmUsuario(String nmUsuario) {
        this.nmUsuario = nmUsuario;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    public String getDtSenha() {
        return dtSenha;
    }

    public void setDtSenha(String dtSenha) {
        this.dtSenha = dtSenha;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public String getTpUsuario() {
        return tpUsuario;
    }

    public void setTpUsuario(String tpUsuario) {
        this.tpUsuario = tpUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nmUsuario='" + nmUsuario + '\'' +
                ", dsEmail='" + dsEmail + '\'' +
                ", dtSenha='" + dtSenha + '\'' +
                ", dtCadastro=" + dtCadastro +
                ", tpUsuario='" + tpUsuario + '\'' +
                '}';
    }
}
