
package sjakk;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Markus
 */
public class Rute extends Rectangle {
    
    private Brikke brikke;
    String rNavn;
    
    
    public Rute(boolean hvit,int x,int y, String rNavn){
        
        this.rNavn = rNavn;
        setWidth(SpillerAnimasjon.RUTE_STR);
        
        setHeight(SpillerAnimasjon.RUTE_STR);

        relocate(x * SpillerAnimasjon.RUTE_STR, y * SpillerAnimasjon.RUTE_STR);

        setFill(hvit ? Color.valueOf("#ffcc66") : Color.valueOf("#800000"));
    }
    
    
    public boolean harBrikke(){
        return brikke != null;
    }
    public Brikke getBrikke(){
        return brikke;
        
    }
    public void setBrikke(Brikke brikke){
        this.brikke = brikke;
    }
    
    
}
