package sjakk;

import java.io.Serializable;

public class Spiller implements Serializable{
    private String navn;
    private double poeng;
    
    public Spiller(String navn, double poeng) {
        this.navn = navn;
        this.poeng = poeng;
    }

    public String getNavn() {
        return navn;
    }

    public double getPoeng() {
        return poeng;
    }
    
    
}
