package sjakk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Admapp extends Application{

   private final static int BREDDE = 1000;
    private final static int HOYDE = 600;
    
    BorderPane root;
    StackPane vindu;
    VBox sideMeny;
    TextField spillerNavn, datoFelt;
    Scene sceneEn,sceneTo;
    Label spillerLabel, datoLabel, infoTxt;
    Button knappLeggTil, knappDato, knappNyttParti;
    TableView table;
    
    ObservableList<Spiller> spillerListe = FXCollections.observableArrayList();
    ObservableList<Parti> partiListe = FXCollections.observableArrayList();
    Spiller spiller;
    
    @Override
    public void start(Stage primaryStage){
          
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
      
        knappNyttParti = new Button("Opprett partier");
        knappNyttParti.setPadding(new Insets(8,17,8,17));
        
        
        sideMeny.getChildren().addAll(infoTxt, spillerLabel,spillerNavn,knappLeggTil, knappNyttParti);
        
        table = new TableView();
        TableColumn<Spiller, String> spillerRad = new TableColumn<>("Spiller");
        spillerRad.setMinWidth(200);
        spillerRad.setCellValueFactory(new PropertyValueFactory<>("navn"));
        
        table.setItems(spillerListe);
        table.getColumns().addAll(spillerRad);
       
        knappLeggTil.setOnAction(e
                -> {
            if (!spillerNavn.getText().equals("") || spillerListe.size() < 20) {
                spiller = new Spiller(); 
                spiller.setNavn(spillerNavn.getText());
                spillerListe.add(spiller);
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
                    Parti parti = new Parti(spillere1.get(i), spillere2.get(i), "hei", "hwi");
                    partiListe.add(parti);
                }
                
                for(Parti p : partiListe){
                    System.out.println(p.getSpiller1().getNavn() + " Vs " + p.getSpiller2().getNavn());
                }
                
            }
            else {
                System.out.println("Spillere trenger en motstander!");
            }

        });
       
       root.setLeft(sideMeny);
       vindu.getChildren().add(table);
       root.setCenter(vindu);
       sceneEn= new Scene(root,BREDDE,HOYDE);
       
       
        primaryStage.setTitle("AdminApp");
        primaryStage.setScene(sceneEn);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
        
    }
    
}
