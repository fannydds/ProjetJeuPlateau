/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.controleur;

import java.util.Observable;
import java.util.Optional;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
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
        try{
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
        }catch(ArrayIndexOutOfBoundsException err){
            
        }
        if(!res && !keyCode.equals(keyCode.UP)){
            System.out.println(".keyPressed() ok ");
            this.getPlateau().getGrille().ajoutPiece(pcourante);
            PlateauTetris p = (PlateauTetris) this.getPlateau();
            p.ligneComplete();
            p.getNewPieceCourante();
            
        }
        draw();
 
    }

    @Override
    public void update(Observable o, Object arg) {
        PlateauTetris p = (PlateauTetris)o;
        if(!p.isGameOver()){
            super.update(o, arg);
        }else{
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Game Over");
                    alert.setHeaderText("Game Over");
                    alert.setContentText("Your score : " + getLblScore().getText());

                    
                    Optional<ButtonType> result = alert.showAndWait();
                    Stage s  = (Stage) getLblScore().getScene().getWindow();
                    s.close();


                }
            });
            
            
        }
        
    }
    
    
    
    

    
    
    
    
    
}
