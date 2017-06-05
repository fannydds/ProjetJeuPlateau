/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.modele;

import java.util.logging.Level;
import java.util.logging.Logger;
import lib.jeuplateau.modele.Case;
import lib.jeuplateau.modele.Plateau;
import lib.jeuplateau.modele.Position;
import lib.jeuplateau.modele.Translation;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;
import lib.jeuplateau.modele.Score;

/**
 *
 * @author Epulapp
 * 
 * 
 */
public class PlateauTetris extends Plateau {
    
    public final static int NB_COLS = 10;
    public final static int NB_ROWS = 16;
    
    private boolean gameOver = false;
    
    
    public PlateauTetris() 
    {
        super(NB_COLS, NB_ROWS);
        this.setPieceCourante(PieceTetris.getRandomPieceTetris());
    }

    public PlateauTetris(int col, int row) {
        super(col, row);
    }
    
    public void getNewPieceCourante(){
        this.setPieceCourante(PieceTetris.getRandomPieceTetris());
    }
    

    public void supprimerLigneComplete(int numLigne)
    {
        Case[][] cases = this.getGrille().getTableauCase();
        Case[][] cases2 = new Case[this.getGrille().getTableauCase().length][this.getGrille().getTableauCase()[0].length];
        
        for (int i = 0; i < numLigne+1; i++) 
        {
            for (int j = 0; j < this.getGrille().getTableauCase()[0].length; j++) 
            {
                if(i-1 >=0)
                    cases2[i][j]=cases[i-1][j];
                else cases2[0][j] = null;
            }
        }
        for (int i = numLigne+1; i < cases.length; i++) 
        {
            for (int j = 0; j < cases[0].length; j++) 
            {
                    cases2[i][j]=cases[i][j];
            }
        }
        
        this.getGrille().setTableauCase(cases2);
        Score sc = this.getScore();
        sc.add(100);
        System.out.println(sc.getScore());
    }
    
    public boolean ligneComplete()
    {
        int maxCol = this.getGrille().getTableauCase()[0].length;
        int maxLigne = this.getGrille().getTableauCase().length;
        
        for (int i = 0; i < maxLigne; i++) 
        {
            boolean b = true;
            for (int j = 0; j < maxCol; j++) 
            {
                if(this.getGrille().getTableauCase()[i][j]==null)
                    b = false;
            }
            if(b) supprimerLigneComplete(i);
        }
        return true;
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
                                  gameOver = true;
                                  cancel();
                              }
                              System.out.println("nouvelle piece 1");
                              getGrille().ajoutPiece(getPieceCourante());
                              setChanged();
                              notifyObservers();
                              clearChanged();
                              ligneComplete();
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
                            ligneComplete();
                            getNewPieceCourante();
                           
                            nvellePiece =true;
                        }
                }
                
            }, 0,500);
    }

    public boolean isGameOver() {
        return gameOver;
    }
    
    
    
   
}
