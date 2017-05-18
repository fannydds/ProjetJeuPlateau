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
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Epulapp
 * 
 * 
 */
public class PlateauTetris extends Plateau {
    
    public final static int NB_COLS = 10;
    public final static int NB_ROWS = 16;
    
    
    public PlateauTetris() {
      
        super(NB_COLS, NB_ROWS);
        this.setPieceCourante(PieceTetris.getRandomPieceTetris());
        
    }
    
    public void getNewPieceCourante(){
        this.setPieceCourante(PieceTetris.getRandomPieceTetris());
    }
    
    @Override
    public void startGame(){
            getNewPieceCourante();
            
            Timer t = new Timer();
            
            t.scheduleAtFixedRate(new TimerTask() {
                boolean nvellePiece = false;
                @Override
                public void run() {
                        try {
                          System.out.println(".run() ");
                          if(getPieceCourante().translate(Translation.Bas, getGrille())){
                              setChanged();
                              notifyObservers();
                              clearChanged();
                              nvellePiece =false;
                         }else{
                              if(nvellePiece){
                                  cancel();
                              }
                              System.out.println("nouvelle piece 1");
                              getGrille().ajoutPiece(getPieceCourante());
                              setChanged();
                              notifyObservers();
                              clearChanged();
                              getNewPieceCourante();
                              nvellePiece =true;
                          }
                          

                        } catch (CloneNotSupportedException ex ) {
                            Logger.getLogger(PlateauTetris.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ArrayIndexOutOfBoundsException e){
                            if(nvellePiece){
                                  cancel();
                            }
                            System.out.println("nouvelle piece 2");
                            getGrille().ajoutPiece(getPieceCourante());
                            setChanged();
                            notifyObservers();
                            clearChanged();
                            getNewPieceCourante();
                            nvellePiece =true;
                        }
                }
            }, 0,500);
            

            
//            Thread t = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    int i = 0;
//                    while(true){
//                        try {
//                            System.out.println(".run() " + i);
//                          getPieceCourante().translate(Translation.Bas, getGrille());
//                          setChanged();
//                          clearChanged();
//
//                        } catch (CloneNotSupportedException ex) {
//                            Logger.getLogger(PlateauTetris.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        if(i >= 10){
//                            getNewPieceCourante();
//                            i = 0;
//                        }
//                        i++;
//                    }
//                    
//                    
//                }
//            });
//            t.start();
    }
    
    
}
