/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.jeuplateau.modele;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.ColumnConstraints;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;

/**
 *
 * @author Epulapp
 */
public class GrilleJeuController implements Initializable {
    
    @FXML
    private GridPane grilleGridPane;
    
    private int numCols;
    private int numRows;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //initGrilleGridPane();
    }   
    
    private void initGrilleGridPane(int col, int row){
        numCols = col;
        numRows = row;
        grilleGridPane.getRowConstraints().clear();
        grilleGridPane.getColumnConstraints().clear();
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / numCols);
            grilleGridPane.getColumnConstraints().add(colConst);
//            Rectangle r = new Rectangle();
//            r.autosize();
//            r.setFill(Color.CHARTREUSE);
//            grilleGridPane.add(r, i, 0);
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
                
                ap.setTopAnchor(r, 0.5);
                ap.setLeftAnchor(r, 0.5);
                ap.setRightAnchor(r, 0.5);
                ap.setBottomAnchor(r, 0.5);
                ap.getChildren().add(r);
                grilleGridPane.add(ap, i, j);
            }
        }
    }
    
}
