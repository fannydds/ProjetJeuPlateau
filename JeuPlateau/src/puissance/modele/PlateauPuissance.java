/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puissance.modele;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import lib.jeuplateau.modele.Case;
import lib.jeuplateau.modele.Plateau;
import lib.jeuplateau.modele.Score;
import lib.jeuplateau.modele.Translation;
import tetris.modele.PieceTetris;
import tetris.modele.PlateauTetris;

/**
 *
 * @author Mathie
 */
public class PlateauPuissance extends Plateau{

    public final static int NB_COLS = 10;
    public final static int NB_ROWS = 10;
    
    public boolean couleur = true;
    
    public PlateauPuissance() 
    {
        super(NB_COLS, NB_ROWS);
        this.setPieceCourante(PiecePuissance.getPiece(this.couleur));
        this.couleur = !this.couleur;
    }
    

    public void getNewPieceCourante()
    {
        this.setPieceCourante(PiecePuissance.getPiece(this.couleur));
        this.couleur = !this.couleur;
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
    }
    
}
