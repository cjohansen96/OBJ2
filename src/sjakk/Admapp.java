package sjakk;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Admapp extends Application{

   private final static int BREDDE = 1000;
    private final static int HOYDE = 600;
    
    BorderPane root, rootTo, vinduTo;
    StackPane vindu;
    VBox sideMeny, sideMenyTo;
    TextField spillerNavn, datoFelt;
    Scene sceneEn,sceneTo;
    Label spillerLabel, datoLabel, infoTxt, lagreLabel, infoLabel;
    Button knappLeggTil, knappDato, knappNyttParti, knappLagre, knappNySpiller;
    TableView table, tablePartier, tableSpillere;
    
    ObservableList<Spiller> spillerListe = FXCollections.observableArrayList();
    ObservableList<Parti> partiListe = FXCollections.observableArrayList();
    
    Spiller spiller;
    Manager m;
    
    @Override
    public void start(Stage primaryStage){
       //scene 1 styling   
       root = new BorderPane();
       vindu = new StackPane();
       vindu.setAlignment(Pos.CENTER);
       
       sideMeny = new VBox(5);
       sideMeny.setPadding(new Insets(40.0));
       sideMeny.setStyle("-fx-background-color: #d1d1e0;");
       
        infoTxt = new Label("Legg til navnet for hver enkelt\n"
                + "spiller som er med i turneringen,\n"
                + "og så trykker du på opprett partier.\n"
                + "Sørg for at listen alltid er partall\n"
                + "da hvert parti trenger to spillere.");
        
        spillerLabel = new Label("Legg til spillere:");
        spillerNavn = new TextField();
        
        knappLeggTil = new Button("Legg til spiller");
        knappLeggTil.setPadding(new Insets(8,17,8,17));
        
        Label spaceLabel = new Label("");
        spaceLabel.setPadding(new Insets(200,0,0,0));
        
        knappNyttParti = new Button("Opprett partier");
        knappNyttParti.setPadding(new Insets(8,17,8,17));
        
        
        sideMeny.getChildren().addAll(infoTxt, spillerLabel,spillerNavn,knappLeggTil, spaceLabel, knappNyttParti);
        
        table = new TableView();
        TableColumn<Spiller, String> spillerRad = new TableColumn<>("Spiller");
        spillerRad.setMinWidth(200);
        spillerRad.setCellValueFactory(new PropertyValueFactory<>("navn"));
        
        table.setItems(spillerListe);
        table.getColumns().addAll(spillerRad);
        
        //Scene 2 styling
        rootTo = new BorderPane();
        vinduTo = new BorderPane();
       
        sideMenyTo = new VBox(5);
        sideMenyTo.setPadding(new Insets(40.0));
        sideMenyTo.setStyle("-fx-background-color: #d1d1e0;");
        
        infoLabel = new Label("Legg til nye spillere\n"
                            + "for å legge til nye partier");
        knappNySpiller = new Button("Legg til spillere");
        knappNySpiller.setPadding(new Insets(8,17,8,17));
        
        lagreLabel = new Label("Lagre til fil");
        lagreLabel.setPadding(new Insets(300,0,0,0));
        knappLagre = new Button("Lagre");
        knappLagre.setPadding(new Insets(8,17,8,17));
        
        sideMenyTo.getChildren().addAll(infoLabel, knappNySpiller, lagreLabel, knappLagre);
                
        tablePartier = new TableView();
        
        TableColumn<Parti, String> dato = new TableColumn<>("Dato");
        dato.setMinWidth(100);
        dato.setCellValueFactory(new PropertyValueFactory<>("dato"));
        
        TableColumn<Parti, String> klokkeSlett = new TableColumn<>("Klokkeslett");
        klokkeSlett.setMinWidth(100);
        klokkeSlett.setCellValueFactory(new PropertyValueFactory<>("klokkeSlett"));
        
        tablePartier.setItems(partiListe);
        tablePartier.getColumns().addAll(dato, klokkeSlett);
        
        tableSpillere = new TableView();
        
        TableColumn<Spiller, String> spiller1 = new TableColumn<>("Spiller 1");
        spiller1.setMinWidth(100);
        spiller1.setCellValueFactory(new PropertyValueFactory<>("navn"));
        
        TableColumn<Spiller, String> spiller2 = new TableColumn<>("Spiller 2");
        spiller2.setMinWidth(100);
        spiller2.setCellValueFactory(new PropertyValueFactory<>("navn"));
        
        tableSpillere.setItems(spillerListe);
        tableSpillere.getColumns().addAll(spiller1, spiller2);
        
        //action event på knappene
        knappLeggTil.setOnAction(e
                -> {
            if (!spillerNavn.getText().equals("") || spillerListe.size() < 20) {
                spiller = new Spiller(); 
                spiller.setNavn(spillerNavn.getText());
                spillerListe.add(spiller);
                spillerNavn.setText("");
            }
            else {
                System.out.println("feil");
            }

        });
               
        knappNyttParti.setOnAction(e
                -> {
            Collections.shuffle(spillerListe);
            if((spillerListe.size()%2) == 0  ) {
                int lengde = spillerListe.size();
                List<Spiller> spillere1;
                List<Spiller> spillere2;
                
                spillere1 = spillerListe.subList(0, (lengde/2));
                spillere2 = spillerListe.subList((lengde/2), lengde);
                
                for(int i=0; i<lengde/2; i++) {
                    GregorianCalendar calender = randomDato(1, 20);
                    String tidsPunkt = randomDoubleMellom(10.00, 16.00);
                    String datoStart = getStringDato(calender);
                    
                    String[] fullDato = datoStart.split("-");
                    String dagDato = fullDato[0];
                    int datoStartInt = Integer.parseInt(dagDato);
                    double tidsPunktDouble = Double.parseDouble(tidsPunkt);
                    
                    boolean datoTidMatch = sjekkDatoOgTid(datoStartInt, tidsPunktDouble);
                    //Så lnge datoTidMatch er false ikke gjør noe, hvis den er true bytt
                    while(datoTidMatch) {
                        calender = randomDato(1, 20);
                        randomDoubleMellom(10.00, 16.00);
                        getStringDato(calender);
                        datoTidMatch = sjekkDatoOgTid(datoStartInt, tidsPunktDouble);
                    }
                    
                    Parti parti = new Parti(spillere1.get(i), spillere2.get(i), datoStart, tidsPunkt);
                    partiListe.add(parti);
                } 
                
                primaryStage.setScene(sceneTo);
                
                for(Parti p : partiListe){
                    System.out.println(p.getSpiller1().getNavn() + " Vs " + p.getSpiller2().getNavn());
                    int random = (int)(Math.random() * 3 + 1);
                    
                    if(random == 1)
                        System.out.println("Hvit");
                    else if (random == 2)
                        System.out.println("Remis");
                    else 
                        System.out.println("Svart");
                }
                
            }
            else {
                System.out.println("Spillere trenger en motstander!");
            }

        });
        
        knappLagre.setOnAction(e
                -> {
            try {
                for(Parti p : partiListe) {
                    m = new Manager();
                    m.addParti(p.getSpiller1(), p.getSpiller2(), p.getDato(), p.getKlokkeSlett(), "HVIT", "BondeE3,BondeD5,BondeE4,BondeD2,BondeE6,BondeD5,BondeE5,BondeD8,HestE7,KongeD5,LøperE3,HestD7,HestE2,DronningD4,DronningE4,KongeD5,LøperE6,DronningD4,KongeE5,HestD7,DronningE4,KongeD5,HestE7,HestD2,LøperE3,TårnD8,TårnE8,LøperD3,LøperE3,DronningD4,TårnE8,DronningD4,TårnE8,HestD2,DronningE4,LøperD3");
                }
            }
            catch(ClassCastException x) {
                System.out.println(x.getMessage());
            }

        });
       
       root.setLeft(sideMeny);
       vindu.getChildren().add(table);
       root.setCenter(vindu);
       sceneEn= new Scene(root,BREDDE,HOYDE);
       
       rootTo.setLeft(sideMenyTo);
       rootTo.setCenter(vinduTo);
       vinduTo.setLeft(tableSpillere);
       vinduTo.setCenter(tablePartier);
       sceneTo= new Scene(rootTo,BREDDE,HOYDE);
       
       
        primaryStage.setTitle("AdminApp");
        primaryStage.setScene(sceneEn);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
           
    }

    public boolean sjekkDatoOgTid(int dag, double klokke) {
        for(Parti p : partiListe) {
            String dato = p.getDato();
            String[] fullDato = dato.split("-");
            String dagDato = fullDato[0];
            int dagDouble = Integer.parseInt(dagDato);
            
            String klokkeSlett = p.getKlokkeSlett();
            double klokkeSlettDouble = Double.parseDouble(klokkeSlett);
            
            if(dagDouble == dag && klokkeSlettDouble == klokke) {
                return true;
            }
            
        }
        return false;
    }
    
    public String getStringDato(GregorianCalendar dato) {
        SimpleDateFormat datoFormat = new SimpleDateFormat("dd-MM-yyyy");  
        datoFormat.setCalendar(dato);
        return datoFormat.format(dato.getTime()); 
    }
    
    public String converterSpillereTilString(Spiller spiller1, Spiller spiller2) {
        return spiller1.getNavn() + " - " + spiller2.getNavn();
    }
    
    public static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }
    
    public static String randomDoubleMellom(double start, double end) {
        double tidsPunkt = start + Math.round(Math.random() * (end - start));
        return Double.toString(tidsPunkt) + "0";
    }

    public static GregorianCalendar randomDato(int startDag, int sluttDag) {
        int dag = createRandomIntBetween(startDag, sluttDag);
        int måned = 4;
        int år = 2019;
        GregorianCalendar gc = new GregorianCalendar(år,måned,dag);
        return gc;
    }
    
}
