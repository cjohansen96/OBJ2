/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sjakk;


import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
/**
 *
 * @author Markus
 */
public class SpillerApp extends Application {
    
     
    private final static int BREDDE = 1000;
    private final static int HOYDE = 800;
    
    Manager mg;
    //sceneEn
    BorderPane rootEn;
    BorderPane rootTo;
    StackPane vindu;
    VBox sideMeny;
    TextField tekstNavn;
    Scene sceneEn,sceneTo;
    
    
    //sceneTo
    SpillerAnimasjon spillerAnimasjon;
    Label vinner;
    TextArea textArea;
    VBox sideBar;
    
    
    TableView<Spiller> sTable;
    TableView<Parti> pTable;
    
    ObservableList<Spiller> rankListe;
    ObservableList<Parti> partiListe;
    @Override
    public void start(Stage primaryStage) {
        
       mg = new Manager();
       spillerAnimasjon = new SpillerAnimasjon();
       
       rootEn = new BorderPane();
       rootTo = new BorderPane();
       
       
       sceneEn = new Scene(rootEn,BREDDE,HOYDE);
       sceneTo = new Scene(rootTo,BREDDE,HOYDE);
       
       
       vindu = new StackPane();
       vindu.setBorder(new Border(
            new BorderStroke(Color.BROWN, 
            BorderStrokeStyle.SOLID,
            CornerRadii.EMPTY,
            new BorderWidths(3))));
        
       
       
       sideMeny = new VBox(10);
       sideMeny.setPadding(new Insets(60.0));
       
       
       Button knappRang = new Button("Rangering");
       knappRang.setPadding(new Insets(8,17,8,17));
       
       
       
       
        
       Label ledeTekst = new Label("Finn spiller's parti(Stor forbokstav)");
       ledeTekst.setStyle("-fx-font-size: 10pt ");
       ledeTekst.setStyle("-fx-font-weight: bold");
       ledeTekst.setPadding(new Insets(60,0,0,0));
        
       tekstNavn = new TextField();
        
       Button knappSøk = new Button("Søk");
       knappSøk.setPadding(new Insets(8,17,8,17));
        
        
       Label ledeTekstAn = new Label("Se Animasjon av valgt parti");
       ledeTekstAn.setStyle("-fx-font-size: 10pt ");
       ledeTekstAn.setStyle("-fx-font-weight: bold");
       ledeTekstAn.setPadding(new Insets(60,0,0,0));
        
       Button knappStart = new Button("Start");
       knappStart.setPadding(new Insets(8,17,8,17));
     //knappStart.setDisable(true);
     
     
       sideMeny.getChildren().addAll(
       knappRang,
       ledeTekst,
       tekstNavn,
       knappSøk,
       ledeTekstAn,
       knappStart);
       
     
     
      knappStart.setOnAction( e -> {
           
           
           primaryStage.setScene(sceneTo);
           spillerAnimasjon.byggBrett();
          
           
       });
       knappSøk.setOnAction( e -> {
           setParti();
       });
        knappRang.setOnAction( e -> {
           setRangering();
       });
      
      // Sidebar sceneTo
      sideBar = new VBox(10);
      sideBar.setPrefWidth(160);
      sideBar.setAlignment(Pos.CENTER);
      sideBar.setBorder(new Border(
        new BorderStroke(Color.BROWN, 
        BorderStrokeStyle.SOLID,
        CornerRadii.EMPTY,
        new BorderWidths(3))));
      
      vinner = new Label("Vinner:");
      vinner.setFont(Font.font(null, FontWeight.BOLD, 14));
      textArea = new TextArea();
      textArea.setPrefSize(70,500);
      
      Button knappTilbake = new Button("Tilbake");
      knappTilbake.setFont(Font.font(null, FontWeight.BOLD, 14));
      knappTilbake.setStyle("-fx-background-color: #f44242");
      knappTilbake.setPadding(new Insets(0,7,0,7));
      
      
      knappTilbake.setOnAction(e ->{
          primaryStage.setScene(sceneEn);
      });
      Button knappTrekk = new Button("Neste trekk");
      knappTrekk.setFont(Font.font(null, FontWeight.BOLD, 14));
      knappTrekk.setStyle("-fx-background-color: #5ff441");
      knappTrekk.setPadding(new Insets(12,7,12,7));
      
      knappTrekk.setOnAction( e -> {
          
          // Skal sende parti.getTrekk ifra den valgte i tableview
          String trekk = spillerAnimasjon.lagTrekk();
          spillerAnimasjon.nesteTrekk(trekk);
      });
      
      
      
      Button knappAni = new Button("Se parti");
      knappAni.setFont(Font.font(null, FontWeight.BOLD, 14));
      knappAni.setStyle("-fx-background-color: #5ff441");
      knappAni.setPadding(new Insets(12,7,12,7));
      
      
      
      sideBar.getChildren().addAll(vinner,textArea,knappTrekk,knappAni,knappTilbake);
      
      
      
      
      rootTo.setLeft(sideBar);
      rootTo.setCenter(spillerAnimasjon); 
      
      rootEn.setLeft(sideMeny);
      rootEn.setCenter(vindu);
       
       
       
        
      
        
       primaryStage.setTitle("SpillerApp");
       primaryStage.setScene(sceneEn);
       primaryStage.setResizable(false);
       primaryStage.show();
    }


    
    public void setRangering(){
        
        TableColumn<Spiller,String> Navn = new TableColumn<>("Navn");
        Navn.setMinWidth(200);
        Navn.setCellValueFactory(new PropertyValueFactory<>("navn"));
        
        // Poeng kollone
        TableColumn<Spiller,Integer> Poeng = new TableColumn<>("Poeng");
        Poeng.setMinWidth(200);
        Poeng.setCellValueFactory(new PropertyValueFactory<>("poeng"));
        
        sTable = new TableView<>();
        // set table column
        sTable.getColumns().addAll(Navn,Poeng);
        vindu.getChildren().remove(sTable);
        vindu.getChildren().add(sTable);
      
       // rankListe = turnering.getRangering();
       // sTable.setItems(rankListe);
        
        
    }
    public void setParti(){
        
        pTable = new TableView<>();
        String søktNavn = tekstNavn.getText();
        
       ArrayList<Parti> liste = mg.getPartier();
       ArrayList<Parti> utListe = new <Parti> ArrayList();
        
       
       boolean fant = false;
       String pNavnEn;
       String pNavnTo;
       
       for(int i=0; i<liste.size();i++){
           pNavnEn = liste.get(i).getSpiller1().getNavn();
           pNavnTo = liste.get(i).getSpiller2().getNavn();
           
           if(pNavnEn.equals(søktNavn) || pNavnTo.equals(søktNavn)){
               utListe.add(liste.get(i));
              
           }
            
       }
       
       partiListe = FXCollections.observableArrayList(utListe);
       pTable.setItems(partiListe);
   

        
        pTable.setItems(partiListe);
        TableColumn<Parti,String> dato = new TableColumn<>("Dato");
        dato.setMinWidth(pTable.getWidth()/3);
        dato.setCellValueFactory(new PropertyValueFactory<>("dato"));
        
        TableColumn<Parti,String> klslett = new TableColumn<>("KlSlett");
        klslett.setMinWidth(pTable.getWidth()/3);
        klslett.setCellValueFactory(new PropertyValueFactory<>("klokkeSlett"));
        
        TableColumn<Parti,String> resultat = new TableColumn<>("Resultat");
        resultat.setMinWidth(pTable.getWidth()/3);
        resultat.setCellValueFactory(new PropertyValueFactory<>("vinner"));
        
        pTable.getColumns().addAll(dato,klslett,resultat);
        
        
        vindu.getChildren().remove(pTable);
        vindu.getChildren().addAll(pTable);
    }
  
        
    public static void main(String[] args) {
        launch(args);
    }
    
}
