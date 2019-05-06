
package sjakk;

import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Markus
 */
public class SpillerAnimasjon extends BorderPane{
    
    VBox sideBar;
    GridPane brett;
    
    final int str = 8;
    
    
    public SpillerAnimasjon(){
        super();
        sideBar = new VBox();
        sideBar.setPrefWidth(160);
        sideBar.setBorder(new Border(
            new BorderStroke(Color.BROWN, 
            BorderStrokeStyle.SOLID,
            CornerRadii.EMPTY,
            new BorderWidths(3))));
        
        
        
        brett = new GridPane();
        brett.setBorder(new Border(
            new BorderStroke(Color.BROWN, 
            BorderStrokeStyle.SOLID,
            CornerRadii.EMPTY,
            new BorderWidths(3))));
        
        
        
        byggBrett();
        
        this.setLeft(sideBar);
        this.setCenter(brett);
        
        
        
        
    }
    
    private void byggBrett(){
        
         for (int row = 0; row < str; row++) {
            for (int col = 0; col < str; col++) {
                Rectangle square = new Rectangle();
                Color color;
                if ((row + col) % 2 == 0) color = Color.WHITE;
                else color = Color.BLACK;
                square.setFill(color);
                brett.add(square, col, row);
                square.widthProperty().bind(brett.widthProperty().divide(str));
                square.heightProperty().bind(brett.heightProperty().divide(str));
            }
        }
    }
}
