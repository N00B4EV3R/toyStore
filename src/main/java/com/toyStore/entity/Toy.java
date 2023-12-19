package com.toyStore.entity;

import jakarta.persistence.*;

@Entity
@Table(name="datele")
public class Toy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String den, tara;
    private int pret, varsta, cantitate, pr_vandute;

    public Toy(String den, String tara, int pret, int varsta, int cantitate, int pr_vandute) {
        this.den = den;
        this.tara = tara;
        this.pret = pret;
        this.varsta = varsta;
        this.cantitate = cantitate;
        this.pr_vandute = pr_vandute;
    }
    public Toy(){}

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDen() {
        return den;
    }

    public void setDen(String den) {
        this.den = den;
    }

    public String getTara() {
        return tara;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public int getPr_vandute() {
        return pr_vandute;
    }

    public void setPr_vandute(int pr_vandute) {
        this.pr_vandute = pr_vandute;
    }
}
