package sjakk;

import java.io.Serializable;
import java.util.Comparator;

public class Spiller implements Serializable,Comparator<Spiller>{
    private String navn;
    private double poeng;
    
    public Spiller() {
        
    }
    
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

    public void setNavn(String navn) {
        this.navn = navn;
    }
     

    @Override
    public int compare(Spiller spiller1, Spiller spiller2) {
        
        double poeng1 = spiller1.getPoeng();
        double poeng2 = spiller2.getPoeng();

        if (poeng1 > poeng2) {
            return -1;
        } else if (poeng1 < poeng2) {
            return 1;
        } else {
            return 0;
        }
    }
  }
        
    
 
