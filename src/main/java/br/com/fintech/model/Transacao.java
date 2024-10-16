package br.com.fintech.model;

import java.util.Date;

public class Transacao { private int idTransacao;
    private int idUsuario;
    private int idCategoria;
    private String tpTransacao;
    private String dsTransacao;
    private float vlTransacao;
    private Date dtTransacao;

    // Construtor vazio
    public Transacao() {}

    // Construtor com parâmetros
    public Transacao(int idTransacao, int idUsuario, int idCategoria, String tpTransacao, String dsTransacao, float vlTransacao, Date dtTransacao) {
        this.idTransacao = idTransacao;
        this.idUsuario = idUsuario;
        this.idCategoria = idCategoria;
        this.tpTransacao = tpTransacao;
        this.dsTransacao = dsTransacao;
        this.vlTransacao = vlTransacao;
        this.dtTransacao = dtTransacao;
    }

    // Getters e Setters
    public int getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(int idTransacao) {
        this.idTransacao = idTransacao;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getTpTransacao() {
        return tpTransacao;
    }

    public void setTpTransacao(String tpTransacao) {
        this.tpTransacao = tpTransacao;
    }

    public String getDsTransacao() {
        return dsTransacao;
    }

    public void setDsTransacao(String dsTransacao) {
        this.dsTransacao = dsTransacao;
    }

    public float getVlTransacao() {
        return vlTransacao;
    }

    public void setVlTransacao(float vlTransacao) {
        this.vlTransacao = vlTransacao;
    }

    public Date getDtTransacao() {
        return dtTransacao;
    }

    public void setDtTransacao(Date dtTransacao) {
        this.dtTransacao = dtTransacao;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "idTransacao=" + idTransacao +
                ", idUsuario=" + idUsuario +
                ", idCategoria=" + idCategoria +
                ", tpTransacao='" + tpTransacao + '\'' +
                ", dsTransacao='" + dsTransacao + '\'' +
                ", vlTransacao=" + vlTransacao +
                ", dtTransacao=" + dtTransacao +
                '}';
    }
}
