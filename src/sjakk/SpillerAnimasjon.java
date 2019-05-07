
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

        for (int y = 0; y < HOYDE; y++) {
            for (int x = 0; x < BREDDE; x++) {
                Rute rute = new Rute((x + y) % 2 == 0, x, y);
                brett[x][y] = rute;

                ruteGruppe.getChildren().add(rute);

            }
            
        }
        
        
      
        
        
        
        
    }

}
