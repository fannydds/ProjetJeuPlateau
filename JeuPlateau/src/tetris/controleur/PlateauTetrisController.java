/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.controleur;

import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import lib.jeuplateau.controleur.PlateauJeuController;
import lib.jeuplateau.modele.Piece;
import lib.jeuplateau.modele.Translation;
import tetris.modele.PlateauTetris;

/**
 *
 * @author Epulapp
 */
public class PlateauTetrisController extends PlateauJeuController {

    public PlateauTetrisController() {
        
        
        
    }
    
    @Override
    public void keyPressed(KeyEvent e) throws CloneNotSupportedException {
        KeyCode keyCode = e.getCode();
        Piece pcourante = this.getPlateau().getPieceCourante();
        boolean res = true;
         switch( keyCode ) 
         { 
            case UP:
                pcourante.rotation(this.getPlateau().getGrille());   
                break;
            case DOWN:
                res = pcourante.translate(Translation.Bas, this.getPlateau().getGrille());
                break;
            case LEFT:
                res = pcourante.translate(Translation.Gauche, this.getPlateau().getGrille());
                break;
            case RIGHT :
                res = pcourante.translate(Translation.Droite, this.getPlateau().getGrille());
                break;
        }
        if(!res){
            System.out.println(".keyPressed() ok ");
            this.getPlateau().getGrille().ajoutPiece(pcourante);
            PlateauTetris p = (PlateauTetris) this.getPlateau();
            p.ligneComplete();
            p.getNewPieceCourante();
            
        }
        draw();
 
    }
    

    
    
    
    
    
}
