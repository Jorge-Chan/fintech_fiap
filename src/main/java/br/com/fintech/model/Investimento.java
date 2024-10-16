package br.com.fintech.model;

import java.util.Date;

public class Investimento { private int idInvestimento;
    private int idUsuario;
    private String tbInvestimento;
    private String mnInvestimento;
    private float vlInicial;
    private Date dtInvestimento;
    private float vlRentabilidade;
    private String dsRisco;
    private Date dtVencimento;

    // Construtor vazio
    public Investimento() {}

    // Construtor completo
    public Investimento(int idInvestimento, int idUsuario, String tbInvestimento, String mnInvestimento, float vlInicial,
                        Date dtInvestimento, float vlRentabilidade, String dsRisco, Date dtVencimento) {
        this.idInvestimento = idInvestimento;
        this.idUsuario = idUsuario;
        this.tbInvestimento = tbInvestimento;
        this.mnInvestimento = mnInvestimento;
        this.vlInicial = vlInicial;
        this.dtInvestimento = dtInvestimento;
        this.vlRentabilidade = vlRentabilidade;
        this.dsRisco = dsRisco;
        this.dtVencimento = dtVencimento;
    }

    // Getters e Setters
    public int getIdInvestimento() {
        return idInvestimento;
    }

    public void setIdInvestimento(int idInvestimento) {
        this.idInvestimento = idInvestimento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTbInvestimento() {
        return tbInvestimento;
    }

    public void setTbInvestimento(String tbInvestimento) {
        this.tbInvestimento = tbInvestimento;
    }

    public String getMnInvestimento() {
        return mnInvestimento;
    }

    public void setMnInvestimento(String mnInvestimento) {
        this.mnInvestimento = mnInvestimento;
    }

    public float getVlInicial() {
        return vlInicial;
    }

    public void setVlInicial(float vlInicial) {
        this.vlInicial = vlInicial;
    }

    public Date getDtInvestimento() {
        return dtInvestimento;
    }

    public void setDtInvestimento(Date dtInvestimento) {
        this.dtInvestimento = dtInvestimento;
    }

    public float getVlRentabilidade() {
        return vlRentabilidade;
    }

    public void setVlRentabilidade(float vlRentabilidade) {
        this.vlRentabilidade = vlRentabilidade;
    }

    public String getDsRisco() {
        return dsRisco;
    }

    public void setDsRisco(String dsRisco) {
        this.dsRisco = dsRisco;
    }

    public Date getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(Date dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    @Override
    public String toString() {
        return "Investimento{" +
                "idInvestimento=" + idInvestimento +
                ", idUsuario=" + idUsuario +
                ", tbInvestimento='" + tbInvestimento + '\'' +
                ", mnInvestimento='" + mnInvestimento + '\'' +
                ", vlInicial=" + vlInicial +
                ", dtInvestimento=" + dtInvestimento +
                ", vlRentabilidade=" + vlRentabilidade +
                ", dsRisco='" + dsRisco + '\'' +
                ", dtVencimento=" + dtVencimento +
                '}';
    }
}
