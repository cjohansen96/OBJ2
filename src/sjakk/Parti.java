package sjakk;

import java.io.Serializable;

public class Parti implements Serializable{
    Spiller spiller1;
    Spiller spiller2;
    private String dato;
    private String klokkeSlett;
    private String vinner;
    private String trekk;

    
    public Parti(Spiller spiller1, Spiller spiller2, String dato, String klokkeSlett, String vinner) {
        this.spiller1 = spiller1;
        this.spiller2 = spiller2;
        this.dato = dato;
        this.klokkeSlett = klokkeSlett;
        this.vinner = vinner;
        //this.trekk = lagTrekk();
    }
    
    public Parti(Spiller spiller1, Spiller spiller2, String dato, String klokkeSlett) {
        this.spiller1 = spiller1;
        this.spiller2 = spiller2;
        this.dato = dato;
        this.klokkeSlett = klokkeSlett;
    }    
    
    

    public Spiller getSpiller1() {
        return spiller1;
    }

    public Spiller getSpiller2() {
        return spiller2;
    }

    public String getDato() {
        return dato;
    }

    public String getKlokkeSlett() {
        return klokkeSlett;
    }

    public String getResultat() {
        return vinner;
    }

    public String getTrekk() {
        return trekk;
    }

    public void setResultat(String resultat) {
        this.vinner = resultat;
    }

    /*public String lagTrekk(){
        
        
    }
    
    */
    
    
        
}
