/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.jeuplateau.controleur;

import java.awt.Color;
import java.awt.event.KeyEvent;
import lib.jeuplateau.modele.*;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

/**
 *
 * @author Epulapp
 */
public class PlateauJeuController implements Initializable {
    
    @FXML
    private GridPane grilleGridPane;
    
    private int numCols;
    private int numRows;
    
    Plateau plateau;
    
    Button btStart;
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }   
    
    public void initGrilleGridPane(int col, int row){
        numCols = col;
        numRows = row;
        grilleGridPane.getRowConstraints().clear();
        grilleGridPane.getColumnConstraints().clear();
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / numCols);
            grilleGridPane.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / numRows);
            grilleGridPane.getRowConstraints().add(rowConst);         
        }
        grilleGridPane.setGridLinesVisible(true);

        System.out.println(grilleGridPane.getColumnConstraints());
        for (int i = 0; i < numCols; i++) {
            for (int j = 0; j < numRows; j++) {
                Label r = new Label();
                r.setStyle("-fx-background-color: black;");
                AnchorPane ap = new AnchorPane();
                
                AnchorPane.setTopAnchor(r, 0.5);
                AnchorPane.setLeftAnchor(r, 0.5);
                AnchorPane.setRightAnchor(r, 0.5);
                AnchorPane.setBottomAnchor(r, 0.5);
                ap.getChildren().add(r);
                grilleGridPane.add(ap, i, j);
            }
        }
        
        this.plateau = new Plateau(col, row);
        
    }
    
    private void draw(){
         // On parcours le plateau et on colore les cases occupees
        for (int i = 0; i < numCols; i++) 
        {
            for (int j = 0; j < numRows; j++) 
            {
                Position posCase = new Position(j,i);
                Label r = new Label();
                List<Piece> pList = plateau.getGrille().getPiecesSurGrille();
                Piece pcourante = plateau.getGrille().getPieceCourante();
                
                if(pList != null)
                {
                    r.setStyle("-fx-background-color: black;");
                   
                    for (Piece piece : pList)
                    {
                        
                        for (int k = 0; k < piece.getTableauCaseBusy().length; k++) 
                        {
                            if(piece.getTableauCaseBusy()[k].getX() == j && piece.getTableauCaseBusy()[k].getY()==i)
                            {
//                                r.setStyle("-fx-background-color: "+piece.getColor()+";");
                                r.setStyle("-fx-background-color: yellow;");
                            }
                        }
                        
                    }
                }
                if(pcourante != null)
                {
                    Position[] pos = pcourante.getTableauCaseBusy();
                    for (Position po : pos) {
                        if(po.getX() == j && po.getY()==i)
                            r.setStyle("-fx-background-color: red;");
                    }
                    
                }
                AnchorPane ap = new AnchorPane();
                AnchorPane.setTopAnchor(r, 0.5);
                AnchorPane.setLeftAnchor(r, 0.5);
                AnchorPane.setRightAnchor(r, 0.5);
                AnchorPane.setBottomAnchor(r, 0.5);
                ap.getChildren().add(r);
               
                grilleGridPane.add(ap, i, j);
            }
        }
    }
    @FXML
    private void handlerOnActionButtonStart(ActionEvent event) 
    {
       draw();
        
        
    }
    
    
     @FXML
    private void handlerOnActionButtonDown(ActionEvent event) throws CloneNotSupportedException 
    {
        Piece pcourante = plateau.getGrille().getPieceCourante();
        pcourante.translate(Translation.Bas);
        draw();
    }
    
    public void keyPressed(KeyEvent e) throws CloneNotSupportedException {
        int keyCode = e.getKeyCode();
        Piece pcourante = plateau.getGrille().getPieceCourante();

         switch( keyCode ) { 
            case KeyEvent.VK_UP:
                pcourante.translate(Translation.Haut);
                draw();
                break;
            case KeyEvent.VK_DOWN:
                pcourante.translate(Translation.Bas);
                draw();
                break;
            case KeyEvent.VK_LEFT:
                pcourante.translate(Translation.Gauche);
                draw();
                break;
            case KeyEvent.VK_RIGHT :
                pcourante.translate(Translation.Droite);
                draw();
                break;
        }
    } 
}
