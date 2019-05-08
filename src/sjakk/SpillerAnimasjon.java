
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
    
    private Rute [][] brett;
    String[] brikkeFørste = {"Tårn","Hest","Springer","Dronning","Konge","Springer","Hest","Tårn"};
    
    private Group ruteGruppe = new Group();
    private Group brikkeGruppe = new Group();
    
    
    public SpillerAnimasjon(){
        super();
        
        brett = new Rute[BREDDE][HOYDE];
        
        // Lager brettet, å setter start av brikkene
        setBorder(new Border(
            new BorderStroke(Color.BROWN, 
            BorderStrokeStyle.SOLID,
            CornerRadii.EMPTY,
            new BorderWidths(3))));
        
       
        setPrefSize(BREDDE * RUTE_STR, HOYDE * RUTE_STR);
        getChildren().addAll(ruteGruppe, brikkeGruppe);
        
       
        
    }

  
    public void byggBrett(){
        //Alle rutene får ett rutenavn
        
        String ruteNavn;
        int num;
        String[] bokstav = {"A","B","C","D","E","F","G","H"};
        
        for (int y = 0; y < HOYDE; y++) {
               num = y +1; 
            for (int x = 0; x < BREDDE; x++) {
               
                ruteNavn = ""+bokstav[x]+num;
                Rute rute = new Rute((x + y) % 2 == 0, x, y,ruteNavn);
                brett[x][y] = rute;
                
               
                ruteGruppe.getChildren().add(rute);

                Brikke brikke = null;
               
             
                if(y == 0 || y == 7){
                    switch(x) {
                        case 0:
                            if(y==0)
                             brikke = lagBrikke(brikkeFørste[x],x,y,"svart");
                            else
                             brikke = lagBrikke(brikkeFørste[x],x,y,"hvit");   
                        break;
                        case 7:
                            if(y==0)
                            brikke = lagBrikke(brikkeFørste[x],x,y,"svart");
                            else
                             brikke = lagBrikke(brikkeFørste[x],x,y,"hvit");   
                        break;
                        case 1:
                            if(y==0)
                            brikke = lagBrikke(brikkeFørste[x],x,y,"svart"); 
                            else
                            brikke = lagBrikke(brikkeFørste[x],x,y,"hvit");
                        break;
                        case 6:
                            if(y==0)
                             brikke = lagBrikke(brikkeFørste[x],x,y,"svart");
                            else
                             brikke = lagBrikke(brikkeFørste[x],x,y,"hvit");
                        break;
                        case 2:
                            if(y==0)
                            brikke = lagBrikke(brikkeFørste[x],x,y,"svart");
                            else
                            brikke = lagBrikke(brikkeFørste[x],x,y,"hvit");    
                        break;
                        case 5:
                            if(y==0)
                            brikke = lagBrikke(brikkeFørste[x],x,y,"svart");
                            else
                            brikke = lagBrikke(brikkeFørste[x],x,y,"hvit");    
                        break;
                        case 3:
                            if(y == 0)
                            brikke = lagBrikke(brikkeFørste[x],x,y,"svart"); 
                            else
                            brikke = lagBrikke(brikkeFørste[x],x,y,"hvit");
                        break;
                        case 4:
                            if(y == 0)
                            brikke = lagBrikke(brikkeFørste[x],x,y,"svart"); 
                            else
                            brikke = lagBrikke(brikkeFørste[x],x,y,"hvit");
                        break;
                       
                     
                   }
                    
                }
                   
            
                if(y == 1 || y == 6){
                    if(y == 1){
                       brikke = lagBrikke("Bonde",x,y,"svart"); 
                    }
                    else{
                       brikke = lagBrikke("Bonde",x,y,"hvit"); 
                       
                    }
                    
                    
                   
                
                
                }
                if(brikke != null){
                        rute.setBrikke(brikke);
                        brikkeGruppe.getChildren().add(brikke);
                        
                    }
            }
        }
        
        
        
    }
        
    
    
    
    private Brikke lagBrikke(String type,int x, int y,String farge){
       
        Brikke brikke = new Brikke(type,x,y,farge);
        
        return brikke;
    }

    
    public String lagTrekk(){
        
        int ant = (int)(Math.random() * 10 + 1);
        
        int y = (int)(Math.random() * 2 + 1);
        int brikke;
        String trekk = "";
        
        
        // BONDE
        for(int i=0; i < 8; i++){
           
            if((i%2)==0){
            brikke = (int)(Math.random() *7 + 1);
            
            Rute brikkeFra = brett[brikke][6];
            if(brikkeFra.harBrikke()){
                
               Rute brikkeTil = brett[6-y][brikke];
                  trekk += ""+brikkeFra.getBrikke().getType()+brikkeTil.getrNavn()+","; 
            }
               
            
            
            
            }
            else{
            brikke = (int)(Math.random() *7 + 1);
            Rute brikkeFra = brett[brikke][1];
            if(brikkeFra.harBrikke()){
            Rute brikkeTil = brett[1+y][brikke];
            trekk += ""+brikkeFra.getBrikke().getType()+brikkeTil.getrNavn()+","; 
            }
               
            }
             
         }
        
        // Bakrekka
        for(int i=0; i < 28; i++){
           
            if((i%2)==0){
            brikke = (int)(Math.random() *7 + 1);
            
            Rute brikkeFra = brett[brikke][7];
            if(brikkeFra.harBrikke()){
                
               Rute brikkeTil = brett[6-y][brikke];
                  trekk += ""+brikkeFra.getBrikke().getType()+brikkeTil.getrNavn()+","; 
            }
               
            
            
            
            }
            else{
            brikke = (int)(Math.random() *7 + 1);
            Rute brikkeFra = brett[brikke][0];
            if(brikkeFra.harBrikke()){
            Rute brikkeTil = brett[1+y][brikke];
            trekk += ""+brikkeFra.getBrikke().getType()+brikkeTil.getrNavn()+","; 
            }
               
            }
             
         }
           
        
        return trekk;
    }
    
    public void nesteTrekk(Parti parti,int ant){
      
    String[] trekk = parti.getTrekk().split(",");
    
    /*
    piece.move(newX, newY);
    board[x0][y0].setPiece(null);
    board[newX][newY].setPiece(piece);
   
    
    
      setOnMousePressed(e -> {
            mouseX = e.getSceneX();
            mouseY = e.getSceneY();
        });

        setOnMouseDragged(e -> {
            relocate(e.getSceneX() - mouseX + oldX, e.getSceneY() - mouseY + oldY);
        });
      */  
    }
    
    
    
    
    
    
    
}
