package sjakk;

import java.io.Serializable;
import static sjakk.SpillerAnimasjon.BREDDE;
import static sjakk.SpillerAnimasjon.HOYDE;

public class Parti extends Object implements Serializable{
    public static final int RUTE_STR = 100;
    public static final int BREDDE = 8;
    public static final int HOYDE = 8;
    
    private Rute [][] brett;
    String[] brikkeFørste = {"Tårn","Hest","Løper","Dronning","Konge","Løper","Hest","Tårn"};
    
    
    Spiller spiller1;
    Spiller spiller2;
    private String dato;
    private String klokkeSlett;
    private String vinner;
    private String trekk;
    
    public Parti(Spiller spiller1, Spiller spiller2, String dato, String klokkeSlett, String vinner, String trekk) {
        
        this.spiller1 = spiller1;
        this.spiller2 = spiller2;
        this.dato = dato;
        this.klokkeSlett = klokkeSlett;
        this.vinner = vinner;
        this.trekk = trekk;
       
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
    
    public String lagTrekk(){
        
        int ant = (int)(Math.random() * 10 + 1);
        
        int y = (int)(Math.random() * 2 + 1);
        int brikke;
        String trekk = "";
        
        
        // BONDE
        for(int i=0; i < 8; i++){
           
            if((i%2)==0){
            brikke = (int)(Math.random() *7 + 1);
            
            Rute brikkeFra = brett[brikke][6];
            if(brikkeFra.harBrikke()){
                
               Rute brikkeTil = brett[6-y][brikke];
                  trekk += ""+brikkeFra.getBrikke().getType()+brikkeTil.getrNavn()+","; 
            }
               
            
            
            
            }
            else{
            brikke = (int)(Math.random() *7 + 1);
            Rute brikkeFra = brett[brikke][1];
            if(brikkeFra.harBrikke()){
            Rute brikkeTil = brett[1+y][brikke];
            trekk += ""+brikkeFra.getBrikke().getType()+brikkeTil.getrNavn()+","; 
            }
               
            }
             
         }
        
        // Bakrekka
        for(int i=0; i < 28; i++){
           
            if((i%2)==0){
            brikke = (int)(Math.random() *7 + 1);
            
            Rute brikkeFra = brett[brikke][7];
            if(brikkeFra.harBrikke()){
                
               Rute brikkeTil = brett[6-y][brikke];
                  trekk += ""+brikkeFra.getBrikke().getType()+brikkeTil.getrNavn()+","; 
            }
               
            
            
            
            }
            else{
            brikke = (int)(Math.random() *7 + 1);
            Rute brikkeFra = brett[brikke][0];
            if(brikkeFra.harBrikke()){
            Rute brikkeTil = brett[1+y][brikke];
            trekk += ""+brikkeFra.getBrikke().getType()+brikkeTil.getrNavn()+","; 
            }
               
            }
             
         }
           
        
        return trekk;
    }
    
    
}
