package sjakk;

import java.io.Serializable;

public class Spiller implements Serializable,Comparable<Spiller>{
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
    public int compareTo(Spiller s) {
        
    if(this.poeng<s.poeng)
          return -1;
    else if(s.poeng<this.poeng)
          return 1;
    return 0;
}    
  }
        
    
 
