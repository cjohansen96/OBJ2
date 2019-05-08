package sjakk;


import java.util.*;
import java.io.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Manager {

    private ArrayList<Parti> partier;

    private static final String TURNERING_FIL = "turnering.dat";

    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;

    public Manager() {
        partier = new ArrayList<>();
    }

    /**
     * Denne metoden retunerer arraylisten score, i en sortert rekkefølge
     *
     * @return ArrayList"<"Player">"
     */
    public ArrayList<Parti> getPartier() {
        lastPartier();
        return partier;
    }

    public void addParti(Spiller spiller1, Spiller spiller2, String dato, String kl, String vinner, String trekk) {
        lastPartier();
        partier.add(new Parti(spiller1, spiller2, dato, kl, vinner, trekk));
        oppdaterPartier();
    }
    
    /**
     * Denne funksjonen vil laste inn arraylisten som er i highscorefila, og putte den i score arraylisten
     */
    public void lastPartier() {
        try {
            inputStream = new ObjectInputStream(new FileInputStream(TURNERING_FIL));
            partier = (ArrayList<Parti>) inputStream.readObject();

        } catch (FileNotFoundException e) {
            System.out.println("[Load] FNF Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("[Load] IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("[Laad] CNF Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Load] IO Error: " + e.getMessage());
            }
        }
    }
    
    /**
     * Denne metoden vil skrive scorearraylisten til highscorefilen
     */
    public void oppdaterPartier() {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(TURNERING_FIL));
            outputStream.writeObject(partier);

        } catch (FileNotFoundException e) {
            System.out.println("[Update] FNF Error: " + e.getMessage() + ",the program will try and make a new file");
        } catch (IOException e) {
            System.out.println("[Update] IO Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Update] Error: " + e.getMessage());
            }
        }
    }
    
    /**
     * Denne metoden brukes til å få top 10 liste fra scorearraylisten, og få det ut i en tekstlig format ved hjelp av en string.
     * @return String
     */
    public String getPartiString() {
        String partiString = "";

        ArrayList<Parti> partier;
        partier = getPartier();

        int i = 0;
        while (i < partier.size()) {
            partiString += partier.get(i).getSpiller1().getNavn() + " " + 
            partier.get(i).getSpiller2().getNavn() + " "  + 
            partier.get(i).getDato() + partier.get(i).getKlokkeSlett() + 
            " " + partier.get(i).getResultat() + " " + partier.get(i).getTrekk() + "\n";
            i++;
        }
        return partiString;
    }
}