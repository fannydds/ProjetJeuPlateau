/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.jeuplateau.controleur;

import lib.jeuplateau.modele.*;
import java.net.URL;
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
    
    @FXML
    private void handlerOnActionButtonStart(ActionEvent event) {
        
        Piece p  = new Piece(numCols, numRows);
        System.out.println(".handlerOnActionButtonStart() " + p.getTableauCase());
        p.getTableauCase()[0][0].setBusy(true);
        p.getTableauCase()[0][1].setBusy(true);
        plateau.getGrille().setPieceCourante(p);
        
         for (int i = 0; i < numCols; i++) {
            for (int j = 0; j < numRows; j++) {
                Label r = new Label();
                if(plateau.getGrille().getPieceCourante().getTableauCase()[i][j].isBusy()){
                    r.setStyle("-fx-background-color: red;");
                }else{
                    r.setStyle("-fx-background-color: black;");
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
    
    
}
