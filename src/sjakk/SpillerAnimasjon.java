
package sjakk;

import javafx.scene.Group;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Markus
 */
public class SpillerAnimasjon extends Pane{
    
    public static final int RUTE_STR = 100;
    public static final int BREDDE = 8;
    public static final int HOYDE = 8;
    
    private Rute [][] brett = new Rute[BREDDE][HOYDE];
    
    private Group ruteGruppe = new Group();
    private Group brikkeGruppe = new Group();
    
    
    public SpillerAnimasjon(){
        
        
        // Lager brettet, å setter start av brikkene
        setBorder(new Border(
            new BorderStroke(Color.BROWN, 
            BorderStrokeStyle.SOLID,
            CornerRadii.EMPTY,
            new BorderWidths(3))));
        
       
        setPrefSize(BREDDE * RUTE_STR, HOYDE * RUTE_STR);
        getChildren().addAll(ruteGruppe, brikkeGruppe);
        
        //Alle rutene får ett rutenavn
        String ruteNavn;
        int num;
        String[] bokstav = {"A","B","C","D","E","F","G","H"};
        
        for (int y = 0; y < HOYDE; y++) {
                
            for (int x = 0; x < BREDDE; x++) {
                num = y+1;
                ruteNavn = ""+bokstav[x]+num;
                Rute rute = new Rute((x + y) % 2 == 0, x, y,ruteNavn);
                brett[x][y] = rute;

                ruteGruppe.getChildren().add(rute);

                Brikke brikke = null;
                
                if(y == 0 || y == 7){
                    
                }
                if(y == 1 || y == 6){
                    if(HOYDE == 1){
                       brikke = lagBrikke(x,y,"svart"); 
                    }
                    else
                       brikke = lagBrikke(x,y,"hvit"); 
                }
                
                
            }
            
        }
        
    }
    
    
    private Brikke lagBrikke(int x, int y,String farge){
       
        Brikke brikke = new Brikke("Bonde",x,y,farge);
        
        return brikke;
    }

}
