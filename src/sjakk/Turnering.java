package sjakk;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Turnering {
    
    
    private static Manager manager;
    
    ObservableList<Parti> partiListe;
    ObservableList<Spiller> rangeringListe;
    
    public Turnering(){
        manager = new Manager();
        
    }
    
    
    public void leggTilParti(Spiller spiller1,
                             Spiller spiller2,
                             String dato, 
                             String klokkeSlett,
                             String vinner, 
                             String trekk) {
        
    
        manager.oppdaterParti(new Parti(
                                      spiller1,
                                      spiller2, 
                                      dato,
                                      klokkeSlett,
                                      vinner,
                                      trekk));
        
        //oppdaterer partiListe etter ny lagt til
        partiListe = getPartier();
    
    }
    
    public ObservableList<Parti> getPartier(){
        
        ArrayList<Parti> liste = manager.lastInnParti();
        partiListe = FXCollections.observableArrayList(liste);
        
        return partiListe;
    }
     public ObservableList<Spiller> getRangering(){
        
        ArrayList<Spiller> liste = manager.LastInnSpillere();
        rangeringListe = FXCollections.observableArrayList(liste);
        
        return rangeringListe;
    }
  
    
    
    public static Manager getManager() {
        return manager;
    } 
}

