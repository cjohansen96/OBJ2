package sjakk;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Manager {
        private List<Parti> partier;

    private static final String TURNERING_FIL = "tunering.dat";

    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;
    
    public Manager() {
        partier = new ArrayList<>();
    }
    
    public List<Parti> getPartier() {
        lastInnFil();
        return partier;
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
    
}
