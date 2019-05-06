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
    

    private static final String RANGERING_FIL = "rangering.dat";
    private static final String TURNERING_FIL = "turnering.dat";

    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;
    
    public Manager() {
        
    }
    
    
  
    public ArrayList<Parti> lastInnParti() {
        try {
            inputStream = new ObjectInputStream(new FileInputStream(TURNERING_FIL));
            ArrayList<Parti> list = (ArrayList<Parti>)inputStream.readObject();
            
            return list;
            
            

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
        return null;
    }
    
    public void oppdaterParti(Parti nyttParti) {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(TURNERING_FIL));
            outputStream.writeObject(nyttParti);

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
    
  
      public ArrayList<Spiller> LastInnSpillere() {
        
            try {
            inputStream = new ObjectInputStream(new FileInputStream(RANGERING_FIL));
            ArrayList<Spiller> list = (ArrayList<Spiller>)inputStream.readObject();
            
            return list;
            
            

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
        return null;
    }
      
     public void oppdaterRangering(Spiller nySpiller) {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(TURNERING_FIL));
            outputStream.writeObject(nySpiller);

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
