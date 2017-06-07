/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puissance.controleur;

import java.util.Observable;
import java.util.Optional;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import lib.jeuplateau.controleur.PlateauJeuController;
import lib.jeuplateau.modele.Piece;
import lib.jeuplateau.modele.Plateau;
import lib.jeuplateau.modele.Translation;
import puissance.modele.PlateauPuissance;

/**
 *
 * @author Mathie
 */
public class PlateauPuissanceController extends PlateauJeuController {

    public PlateauPuissanceController() {
    }

    public void keyPressed(KeyEvent e) throws CloneNotSupportedException {
        KeyCode keyCode = e.getCode();
        Piece pcourante = this.getPlateau().getPieceCourante();
        boolean res = true;
        try {
            switch (keyCode) {
                case DOWN:
                    res = pcourante.translate(Translation.Bas, this.getPlateau().getGrille());
                    
                    break;
                case LEFT:
                    res = pcourante.translate(Translation.Gauche, this.getPlateau().getGrille());
                    break;
                case RIGHT:
                    res = pcourante.translate(Translation.Droite, this.getPlateau().getGrille());
                    break;
            }
        } catch (ArrayIndexOutOfBoundsException err) {

        }
        if (!res && !keyCode.equals(keyCode.UP)) {
            System.out.println(".keyPressed() ok ");
            this.getPlateau().getGrille().ajoutPiece(pcourante);
            PlateauPuissance p = (PlateauPuissance) this.getPlateau();
            p.isAligne4Pieces();
            p.getNewPieceCourante();

        }
        draw();

    }

    @Override
    public void update(Observable o, Object arg) {
        PlateauPuissance p = (PlateauPuissance) o;
        if (!p.isGameOver() && !p.isWin()) {
            super.update(o, arg);
        } else if (p.isGameOver()) {
            Platform.runLater(() -> {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Game Over");
                alert.setHeaderText("Game Over");
//                    alert.setContentText("Your score : " + getLblScore().getText());
                Optional<ButtonType> result = alert.showAndWait();
                Stage s = (Stage) getLblScore().getScene().getWindow();
                s.close();
            });

        } else {

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Gagné");
                    alert.setHeaderText("Gagné");
                    Optional<ButtonType> result = alert.showAndWait();
                    Stage s = (Stage) getLblScore().getScene().getWindow();
                    s.close();
                }
            });
        }
    }

    @Override
    public void initGrilleGridPane(Plateau plateau) {
        super.initGrilleGridPane(plateau);
        getGrilleGridPane().setStyle("-fx-background-color: blue;");
        getGrilleGridPane().getChildren().forEach((c) -> {
            if(c instanceof Rectangle){
                Rectangle r = (Rectangle) c;
                r.setWidth(60);
                r.setHeight(60);
                r.setArcWidth(80);
                r.setArcHeight(80);   
            }
            
        });
    }
    
    
}
