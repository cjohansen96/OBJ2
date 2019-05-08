
package sjakk;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import static sjakk.SpillerAnimasjon.RUTE_STR;
import javafx.scene.paint.ImagePattern;
import javafx.scene.image.Image;

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
        
        flytt(x,y);
        
    
        
        Ellipse ellipse = new Ellipse(RUTE_STR * 0.4125, RUTE_STR * 0.26, RUTE_STR/3, RUTE_STR/3);
        //Hvite Brikker
         Image HvitTårn = new Image("File:src/Bilder/HvitTårn.png",false);
         Image HvitBonde = new Image("File:src/Bilder/HvitBonde.png",false);
         Image HvitHest = new Image("File:src/Bilder/HvitHest.png",false);
         Image HvitSpringer = new Image("File:src/Bilder/HvitSpringer.png",false);
         Image HvitDronning = new Image("File:src/Bilder/HvitDronning.png",false);
         Image HvitKonge = new Image("File:src/Bilder/HvitKonge.png",false);
         //Svarte Brikker
         Image SvartBonde = new Image("File:src/Bilder/SvartBonde.png",false);
         Image SvartTårn = new Image("File:src/Bilder/SvartTårn.png",false);
         Image SvartHest = new Image("File:src/Bilder/SvartHest.png",false);
         Image SvartSpringer = new Image("File:src/Bilder/SvartSpringer.png",false);
         Image SvartKonge = new Image("File:src/Bilder/SvartKonge.png",false);
         Image SvartDronning = new Image("File:src/Bilder/SvartDronning.png",false);
        
        
        if(this.farge.equals("hvit")){
            if(type.equals("Bonde"))
                ellipse.setFill(new ImagePattern(HvitBonde)) ;
            else
            if(type.equals("Tårn"))
                 ellipse.setFill(new ImagePattern(HvitTårn)) ;
            else
            if(type.equals("Hest"))
                 ellipse.setFill(new ImagePattern(HvitHest)) ;
            else
            if(type.equals("Springer"))
                 ellipse.setFill(new ImagePattern(HvitSpringer)) ;
            else
            if(type.equals("Dronning"))
                 ellipse.setFill(new ImagePattern(HvitDronning)) ;
           else
            if(type.equals("Konge"))
                 ellipse.setFill(new ImagePattern(HvitKonge)) ;
                    
        
        }
        else{
            if(type.equals("Bonde"))
                ellipse.setFill(new ImagePattern(SvartBonde)) ;
             else
            if(type.equals("Tårn"))
                 ellipse.setFill(new ImagePattern(SvartTårn)) ;
            else
            if(type.equals("Hest"))
                 ellipse.setFill(new ImagePattern(SvartHest)) ;
            else
            if(type.equals("Springer"))
                 ellipse.setFill(new ImagePattern(SvartSpringer)) ;
            else
            if(type.equals("Dronning"))
                 ellipse.setFill(new ImagePattern(SvartDronning)) ;
            else
            if(type.equals("Konge"))
                 ellipse.setFill(new ImagePattern(SvartKonge)) ;
                    
        
        }
        
        ellipse.setTranslateX((RUTE_STR - RUTE_STR * 0.3125 * 2) / 2);
        ellipse.setTranslateY((RUTE_STR - RUTE_STR * 0.26 * 2) / 2);

        getChildren().addAll(ellipse);
        
        
    }
    public void flytt(int x,int y){
        gammelX = x * RUTE_STR;
        gammelY = y * RUTE_STR;
        relocate(gammelX,gammelY);
    }
  

    public String getType() {
        return type;
    }
    
   
}
