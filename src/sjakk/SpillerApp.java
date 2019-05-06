/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sjakk;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
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
import javafx.scene.control.cell.PropertyValueFactory;
/**
 *
 * @author Markus
 */
public class SpillerApp extends Application {
    
     
    private final static int BREDDE = 1000;
    private final static int HOYDE = 700;
    
    
    BorderPane root;
    StackPane vindu;
    VBox sideMeny;
    TextField tekstNavn;
    Scene sceneEn,sceneTo;
    Turnering turnering;
    
    TableView<Spiller> sTable;
    TableView<Parti> pTable;
    
    ObservableList<Spiller> rankListe;
    ObservableList<Parti> partiListe;
    @Override
    public void start(Stage primaryStage) {
        
       turnering = new Turnering();
        
       root = new BorderPane();
       
        
       
       
       vindu = new StackPane();
       vindu.setBorder(new Border(
            new BorderStroke(Color.BLUE, 
            BorderStrokeStyle.SOLID,
            CornerRadii.EMPTY,
            BorderWidths.DEFAULT)));
        
       vindu.setAlignment(Pos.CENTER);
       
       sideMeny = new VBox(10);
       sideMeny.setPadding(new Insets(60.0));
       
       
       Button knappRang = new Button("Rangering");
       knappRang.setPadding(new Insets(8,17,8,17));
       
       
       
       
        
       Label ledeTekst = new Label("Finn spiller's parti");
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
       knappStart.setDisable(true);
        
        
       sideMeny.getChildren().addAll(knappRang,ledeTekst,tekstNavn,knappSøk,ledeTekstAn,knappStart);
       
       
       // View for RangeringListe
       
        // Navn kollone
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
        
      
         knappRang.setOnAction(e -> {
           rankListe = turnering.getRangering();
           sTable.setItems(rankListe);
           vindu.getChildren().remove(sTable);
           vindu.getChildren().add(sTable);
        });
         
         
         //View for Partier
         
         // Navn kollone
        
         // partiListe = turnering.getPartier();   
        
       
       root.setLeft(sideMeny);
       root.setCenter(vindu);
       sceneEn= new Scene(root,BREDDE,HOYDE);
       
       
        
      
        
       primaryStage.setTitle("SpillerApp");
       primaryStage.setScene(sceneEn);
       primaryStage.show();
    }


    
    
    
  
        
    public static void main(String[] args) {
        launch(args);
    }
    
}
