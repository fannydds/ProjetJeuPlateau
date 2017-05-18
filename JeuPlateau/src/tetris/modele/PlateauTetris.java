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

/**
 *
 * @author Epulapp
 * 
 * 
 */
public class PlateauTetris extends Plateau {
    
    public final static int NB_COLS = 10;
    public final static int NB_ROWS = 10;
    
    
    public PlateauTetris() 
    {
        super(NB_COLS, NB_ROWS);
        
        PieceTetris p = PieceTetris.getLigne();
        p.setPositionPiece(new Position(6,0));
        this.getGrille().ajoutPiece(p);
//        PieceTetris p = PieceTetris.getLigne();
        p.setPositionPiece(new Position(6,1));
        this.getGrille().ajoutPiece(p);
//        PieceTetris p = PieceTetris.getLigne();
        p.setPositionPiece(new Position(6,2));
        this.getGrille().ajoutPiece(p);
        p.setPositionPiece(new Position(6,3));
        this.getGrille().ajoutPiece(p);
        p.setPositionPiece(new Position(6,4));
        this.getGrille().ajoutPiece(p);
        p.setPositionPiece(new Position(6,5));
        this.getGrille().ajoutPiece(p);
        p.setPositionPiece(new Position(6,6));
        this.getGrille().ajoutPiece(p);
        p.setPositionPiece(new Position(6,7));
        this.getGrille().ajoutPiece(p);
        p.setPositionPiece(new Position(6,8));
        this.getGrille().ajoutPiece(p);
        p.setPositionPiece(new Position(6,9));
        this.getGrille().ajoutPiece(p);
        this.setPieceCourante(PieceTetris.getRandomPieceTetris());
        this.ligneComplete();

    }

    public PlateauTetris(int col, int row) {
        super(col, row);
    }
    
    public void getNewPieceCourante(){
        this.setPieceCourante(PieceTetris.getRandomPieceTetris());
    }
    
     
    public void supprimerLigneComplete()
    {
        Case[][] cases = this.getGrille().getTableauCase();
        Case[][] cases2 = new Case[this.getGrille().getTableauCase().length][this.getGrille().getTableauCase()[0].length];
        
        for (int i = 0; i < this.getGrille().getTableauCase().length-1; i++) 
        {
            for (int j = 0; j < this.getGrille().getTableauCase()[0].length; j++) 
            {
                cases2[i+1][j]=cases[i][j];
            }
        }
        this.getGrille().setTableauCase(cases2);
        
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
    
    public boolean ligneComplete()
    {
        int maxCol = this.getGrille().getTableauCase()[0].length;
        int maxLigne = this.getGrille().getTableauCase().length;
        
        
        for (int i = 0; i < maxLigne; i++) 
        {
            boolean b = true;
            for (int j = 0; j < maxCol; j++) 
            {
                if(this.getGrille().getTableauCase()[maxLigne-1][j]==null)
                    b = false;
            }
            if(b) supprimerLigneComplete();
        }
        return true;
//        for (int i = 0; i < 10; i++) 
//        {
//            if(this.getGrille().getTableauCase()[this.getGrille().getTableauCase()[0].length-1][i]==null)
//                return false;
//        }
//        supprimerLigneComplete();
//        return true;
    }
}
