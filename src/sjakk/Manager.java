package sjakk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Manager {
    private List<Parti> partier;

    private static final String TURNERING_FIL = "turnering.dat";

    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;
    
    public Manager() {
        partier = new ArrayList<>();
    }
    
    public ObservableList<Parti> getPartier() {
        lastInnFil();
        ObservableList<Parti> partiListe = FXCollections.observableArrayList(partier);
        
       
        return partiListe;
    }  
    
    public void leggTilParti(Spiller spiller1, Spiller spiller2, String dato, String klokkeSlett, String vinner, String trekk) {
        lastInnFil();
        partier.add(new Parti(spiller1, spiller2, dato, klokkeSlett, vinner, trekk));
        oppdaterFil();
    }
    
    public void lastInnFil() {
        try {
            inputStream = new ObjectInputStream(new FileInputStream(TURNERING_FIL));
            partier = (List<Parti>) inputStream.readObject();
            
            

        } catch (FileNotFoundException e) {
            System.out.println("[Last inn] FNF Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("[Last inn] IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("[Last inn] CNF Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Last inn] IO Error: " + e.getMessage());
            }
        }
    }
    
    public void oppdaterFil() {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(TURNERING_FIL));
            outputStream.writeObject(partier);

        } catch (FileNotFoundException e) {
            System.out.println("[Oppdatering] FNF Error: " + e.getMessage() + ", programmet lager ny fil!");
        } catch (IOException e) {
            System.out.println("[Oppdatering] IO Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Oppdatering] Error: " + e.getMessage());
            }
        }
    }
    
    public String getPartierUtTekst() {
        String partiString = "";

        List<Parti> parti;
        parti = getPartier();

        int i = 0;
        for(Parti p: parti) {
            partiString +=  parti.get(i).getDato() + " " + parti.get(i).getKlokkeSlett() + " "  
                 + parti.get(i).getSpiller1().getNavn() + " " + parti.get(i).getSpiller2().getNavn() + " " 
                 + parti.get(i).getResultat() + " " + parti.get(i).getTrekk() + ";" + "\n";
            i++;
        }
        return partiString;
    }
    
    
      public static ObservableList<Spiller> getSpillere() {
        
        ObservableList<Spiller> spillere = FXCollections.observableArrayList();
        
        File file = new File("src/sjakk/DummyRank.txt");
        try(Scanner sc = new Scanner(file);){
            
            double poeng;
            String navn;
            while(sc.hasNextLine()){
                navn = sc.next();
                poeng = sc.nextDouble();
            
            spillere.add(new Spiller(navn,poeng));
                              
            }
        sc.close();
        }catch(Exception e){
            
             e.printStackTrace(System.out);
        }
       
        
        return spillere;
        }
        
    
}
