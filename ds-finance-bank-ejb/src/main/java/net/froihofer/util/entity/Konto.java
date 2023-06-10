package net.froihofer.util.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "TAB_KONTO")
public class Konto implements Serializable {

    private int kontoNr;
    private double saldo = 0;
    private Kunde besitzer;

    public Konto() {

    }

    @Id
    @GeneratedValue
    public int getKontoNr() {
        return kontoNr;
    }

    public void setKontoNr(int kontoNr) {
        this.kontoNr = kontoNr;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @ManyToOne
    public Kunde getBesitzer() {
        return besitzer;
    }

    public void setBesitzer(Kunde besitzer) {
        this.besitzer = besitzer;
    }

}
