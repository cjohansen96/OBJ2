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
    
     
    private final static int WIDTH = 1000;
    private final static int HEIGHT = 700;
    
    
    BorderPane root;
    StackPane window;
    VBox sideMenu;
    Scene sceneTable,sceneAn;
    
    @Override
    public void start(Stage primaryStage) {
        
        
       root = new BorderPane();
       
       window = new StackPane();
       window.setBorder(new Border(
            new BorderStroke(Color.BLUE, 
            BorderStrokeStyle.SOLID,
            CornerRadii.EMPTY,
            BorderWidths.DEFAULT)));
        
       window.setAlignment(Pos.CENTER);
       
       sideMenu = new VBox();
       sideMenu.setPadding(new Insets(60.0));
       
       
       
       
       root.setLeft(sideMenu);
       root.setCenter(window);
       sceneTable = new Scene(root,WIDTH,HEIGHT);
       
       
        
      
        
        primaryStage.setTitle("SpillerApp");
        primaryStage.setScene(sceneTable);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
