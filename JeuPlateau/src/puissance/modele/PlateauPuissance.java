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
import javafx.scene.paint.Color;
import lib.jeuplateau.modele.Case;
import lib.jeuplateau.modele.Plateau;
import lib.jeuplateau.modele.Score;
import lib.jeuplateau.modele.Translation;

/**
 *
 * @author Mathie
 */
public class PlateauPuissance extends Plateau{

    public final static int NB_COLS = 7;
    public final static int NB_ROWS = 6;
    
    public boolean couleur = true;
    private boolean gameOver = false;
    private boolean win = false;
    
    public PlateauPuissance() 
    {
        super(NB_COLS, NB_ROWS);
        this.setPieceCourante(PiecePuissance.getPiece(this.couleur));
        this.couleur = !this.couleur;
    }
    

    public void getNewPieceCourante()
    {
        isAligne4Pieces();
        this.setPieceCourante(PiecePuissance.getPiece(this.couleur));
        this.couleur = !this.couleur;
    }
    
    
    public void isAligne4Pieces()
    {
        String gagnant="";
        Case[][] tab = this.getGrille().getTableauCase();
        
        //  Alignement horizontaux
        for (int i = 0; i < 6; i++) 
        {
            for (int j = 0; j < 4; j++) 
            {
                Color c1=null;
                Color c2=null;
                Color c3=null;
                Color c4=null;
                if(tab[i][j]!=null)   c1 = tab[i][j].getColor();
                if(tab[i][j+1]!=null) c2 = tab[i][j+1].getColor();
                if(tab[i][j+2]!=null) c3 = tab[i][j+2].getColor();
                if(tab[i][j+3]!=null) c4 = tab[i][j+3].getColor();
                gagnant += gagner(c1,c2,c3,c4);
            }
        }
        // Alignements verticaux
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 3; i++) {
                Color c1=null;
                Color c2=null;
                Color c3=null;
                Color c4=null;
                if(tab[i][j]!=null)   c1 = tab[i][j].getColor();
                if(tab[i+1][j]!=null) c2 = tab[i+1][j].getColor();
                if(tab[i+2][j]!=null) c3 = tab[i+2][j].getColor();
                if(tab[i+3][j]!=null) c4 = tab[i+3][j].getColor();
                gagnant += gagner(c1,c2,c3,c4);
            }
        }
//        Diagonales montantes
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                Color c1=null;
                Color c2=null;
                Color c3=null;
                Color c4=null;
                if(tab[i][j]!=null)     c1 = tab[i][j].getColor();
                if(tab[i+1][j+1]!=null) c2 = tab[i+1][j+1].getColor();
                if(tab[i+2][j+2]!=null) c3 = tab[i+2][j+2].getColor();
                if(tab[i+3][j+3]!=null) c4 = tab[i+3][j+3].getColor();
                gagnant += gagner(c1,c2,c3,c4);
            }
        }
//        Diagonales descendantes
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 7; j++) {
                Color c1=null;
                Color c2=null;
                Color c3=null;
                Color c4=null;
                if(tab[i][j]!=null)     c1 = tab[i][j].getColor();
                if(tab[i+1][j-1]!=null) c2 = tab[i+1][j-1].getColor();
                if(tab[i+2][j-2]!=null) c3 = tab[i+2][j-2].getColor();
                if(tab[i+3][j-3]!=null) c4 = tab[i+3][j-3].getColor();
                gagnant += gagner(c1,c2,c3,c4);
            }
        }
        if(!"".equals(gagnant))
            this.win=true;
        System.out.println("aaa"+gagnant);
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
                            Logger.getLogger(PlateauPuissance.class.getName()).log(Level.SEVERE, null, ex);
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

    public boolean isGameOver() {
        return gameOver;
    }
    
    public boolean isWin() {
        return win;
    }

    private String gagner(Color c1,Color c2,Color c3,Color c4) 
    {
        String str="";
        if(c1!=null && c2!=null && c3!=null && c4!=null)
        {
            if(c1==c2 && c2==c3 && c3==c4)
            { 
                if(c1==Color.RED)
                    str="Rouges";
                if(c1==Color.YELLOW)
                    str="Jaunes";
            }
        }
        return str;
    }
    
}
