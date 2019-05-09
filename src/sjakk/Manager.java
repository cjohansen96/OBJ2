package sjakk;


import java.util.*;
import java.io.*;


public class Manager {
    
    private static final String TURNERING_FIL = "turnering.dat";
    private static final File RANGERING_FIL = new File("rangering.dat");
    private static final File SIKKERHETSKOPIERING = new File("sikkerhetskopiering.txt"); 

    private ArrayList<Parti> partier;
    private ArrayList<Spiller> spillere;

    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;

    public Manager() {
        partier = new ArrayList<>();
        spillere = new ArrayList<>();
    }

    //Partier -->
    public ArrayList<Parti> getPartier() {
        lastPartier();
        return partier;
    }

    public void addParti(Spiller spiller1, Spiller spiller2, String dato, String kl, String vinner, String trekk) {
        lastPartier();
        partier.add(new Parti(spiller1, spiller2, dato, kl, vinner, trekk));
        oppdaterPartier();
    }
    
    //Spillere -->
    public ArrayList<Spiller> getSpillere() {
        lastRangering();
        sort();
        return spillere;
    }
    
    public void addSpill(String navn, double poeng) {
        lastRangering();
        spillere.add(new Spiller(navn, poeng));
        oppdaterRangering();
    }
    
    private void sort() {
        Spiller spiller = new Spiller();
        Collections.sort(spillere, spiller);
    }
    
    public TreeMap<String, Double> getSpillereMap() {
        ArrayList<Spiller> spillere = getSpillere();
        
        ArrayList<String> keys = new ArrayList<>();
        ArrayList<Double> values = new ArrayList<>();
       
        for(Spiller s : spillere){
            values.add(s.getPoeng());
            keys.add(s.getNavn());
        }
        
        TreeMap<String, Double> tm = new TreeMap<>();
        
        Iterator<Double> valueIterator = values.iterator();
        Iterator<String> keyIterator = keys.iterator();
        
        int i=0;
        try {
            while (valueIterator.hasNext() && keyIterator.hasNext()){
                tm.put(keys.get(i), values.get(i));
                i++;
            }
        }
        catch(IndexOutOfBoundsException e) {
            
        }
        
        return tm;
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
    
    // Rangering
    public void lastRangering() {
        try {
            inputStream = new ObjectInputStream(new FileInputStream(RANGERING_FIL));
            spillere = (ArrayList<Spiller>) inputStream.readObject();

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
    
    public void oppdaterRangering() {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(RANGERING_FIL));
            outputStream.writeObject(spillere);

        } catch (FileNotFoundException e) {
            
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
 
    
    public void sikkerhetsKopiering(Spiller spiller1, Spiller spiller2, String dato, String kl, String vinner, String trekk){
        try {
            SIKKERHETSKOPIERING.createNewFile();
            BufferedWriter fw = null;
            fw = new BufferedWriter(new FileWriter(SIKKERHETSKOPIERING, true));
            
            // Skriver til fil
            fw.write("Parti: " + spiller1.getNavn() + " vs " + spiller2.getNavn() + "\r\nDato: " + dato + "  Kl: " + kl + 
                        "\r\nHVIT " + vinner + "\r\nTrekk: " + trekk + "\r\n");
            
            fw.newLine();
            fw.flush();
            fw.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }catch (IOException e) {
            System.out.println("Error initializing stream");
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
            partier.get(i).getDato() + " " + partier.get(i).getKlokkeSlett() + 
            " " + partier.get(i).getResultat() + " " + partier.get(i).getTrekk() + "\n";
            i++;
        }
        return partiString;
    }
    
    public String getSpillerString() {
        String spillerString = "";

        ArrayList<Spiller> spillere;
        spillere = getSpillere();

        int i = 0;
        while (i < spillere.size()) {
            spillerString += spillere.get(i).getNavn() + " " + spillere.get(i).getPoeng() + "\n";
            i++;
        }
        return spillerString;
    }
}