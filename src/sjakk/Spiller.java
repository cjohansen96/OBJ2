package sjakk;

import java.io.Serializable;

public class Spiller implements Serializable{
    private String navn;

    public Spiller(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }
    
    
}
