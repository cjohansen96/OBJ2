/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sjakk;

import javafx.application.Application;
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
    
    @Override
    public void start(Stage primaryStage) {
        
        
       root = new BorderPane();
       
       vindu = new StackPane();
       vindu.setBorder(new Border(
            new BorderStroke(Color.BLUE, 
            BorderStrokeStyle.SOLID,
            CornerRadii.EMPTY,
            BorderWidths.DEFAULT)));
        
       vindu.setAlignment(Pos.CENTER);
       
       sideMeny = new VBox();
       sideMeny.setPadding(new Insets(60.0));
       
       
        Button knappRang = new Button("Rangering");
        knappRang.setPadding(new Insets(8,17,8,17));
        
        Label ledetekst = new Label("Finn spiller's parti");
        tekstNavn = new TextField();
        Button knappSøk = new Button("Søk");
        knappSøk.setPadding(new Insets(8,17,8,17));
        
        
        Button knappParti = new Button("Se valgt parti");
        knappParti.setPadding(new Insets(8,17,8,17));
        
        sideMeny.getChildren().addAll(knappRang,ledetekst,tekstNavn,knappSøk,knappParti);
       
       
       
       
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
