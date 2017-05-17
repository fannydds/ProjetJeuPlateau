/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.modele;

import java.util.logging.Level;
import java.util.logging.Logger;
import lib.jeuplateau.modele.Plateau;
import lib.jeuplateau.modele.Translation;

/**
 *
 * @author Epulapp
 * 
 * 
 */
public class PlateauTetris extends Plateau {
    
    public final static int NB_COLS = 10;
    public final static int NB_ROWS = 10;
    
    
    public PlateauTetris() {
      
        super(NB_COLS, NB_ROWS);
        this.setPieceCourante(PieceTetris.getRandomPieceTetris());
        
    }
    
    public void getNewPieceCourante(){
        this.setPieceCourante(PieceTetris.getRandomPieceTetris());
    }
    
    public void startGame(){
        getNewPieceCourante();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while(true){
                    try {
                        getPieceCourante().translate(Translation.Bas, getGrille());
//                        setChanged();
//                        clearChanged();
                        
                    } catch (CloneNotSupportedException ex) {
                        Logger.getLogger(PlateauTetris.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if(i >= 30){
                       getNewPieceCourante();
                       i = 0;
                    }
                    i++;
                }
                
                
            }
        });
        t.start();
    }
    
    
}
