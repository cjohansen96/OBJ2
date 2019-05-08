
package sjakk;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import static sjakk.SpillerAnimasjon.RUTE_STR;

/**
 *
 * @author Markus
 */
public class Brikke extends StackPane{
    
    
    private String farge,type;
    private double nyX,nyY;
    private double gammelX,gammelY;
    

    public Brikke( String type,int x,int y,String farge){
        this.type = type;
        this.farge = farge;
        
        startPlass(x,y);
     
        
        Ellipse ellipse = new Ellipse(RUTE_STR * 0.3125, RUTE_STR * 0.26);
        if(this.farge.equals("svart")){
        ellipse.setFill(Color.BLACK);
        ellipse.setStroke(Color.BLACK);
        }
        else{
        ellipse.setFill(Color.WHITE);
        ellipse.setStroke(Color.WHITE);
        }
        
        ellipse.setTranslateX((RUTE_STR - RUTE_STR * 0.3125 * 2) / 2);
        ellipse.setTranslateY((RUTE_STR - RUTE_STR * 0.26 * 2) / 2);

        getChildren().addAll(ellipse);
        
        
    }
    public void startPlass(int x,int y){
        gammelX = x * RUTE_STR;
        gammelY = y * RUTE_STR;
        relocate(gammelX,gammelY);
    }
  

    public String getType() {
        return type;
    }
    
   
}
