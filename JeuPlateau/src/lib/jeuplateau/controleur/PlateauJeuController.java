/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.jeuplateau.controleur;

import java.awt.Color;
import lib.jeuplateau.modele.*;
import java.net.URL;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Epulapp
 */
public class PlateauJeuController implements Initializable, Observer{
    
    @FXML
    private GridPane grilleGridPane;
    
    @FXML
    private Label lblScore;
    
    private int numCols;
    private int numRows;
    
    private Plateau plateau;
    
    @FXML
    Button btStart;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {} 

    public Plateau getPlateau() {
        return plateau;
    }
    
    
    
    public void initGrilleGridPane(Plateau plateau)
    {
        numCols = plateau.getCol();
        numRows = plateau.getRow();
        this.plateau = plateau;
        
        this.plateau.addObserver(this);
       
//        Position positionPiece = new Position(1,1);
//        Case[][] tabCase = new Case[2][2];
//        tabCase[0][0]=new Case(javafx.scene.paint.Color.BEIGE);
//        tabCase[0][1]=new Case(javafx.scene.paint.Color.BEIGE);
//        tabCase[1][0]=new Case(javafx.scene.paint.Color.BEIGE);
//        tabCase[1][1]=null;
//        Piece p1 = new Piece(tabCase, positionPiece);
//        
//       plateau.setPieceCourante(p1);

       Platform.runLater(new Runnable() {
            @Override
            public void run() {
                btStart.setDisable(false);
            }
        });


        grilleGridPane.getRowConstraints().clear();
        grilleGridPane.getColumnConstraints().clear();
        
        
        this.lblScore.setText(this.plateau.getScore().getScore()+"");

        System.out.println(grilleGridPane.getColumnConstraints());
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                Rectangle r = new Rectangle();
                
                if(plateau.getGrille().getTableauCase()[i][j] != null)
                    r.setFill(plateau.getGrille().getTableauCase()[i][j].getColor());
                else
                    r.setFill(javafx.scene.paint.Color.BLACK);
                
                r.setStroke(javafx.scene.paint.Color.BLACK);
                r.setStrokeWidth(2);
                r.setWidth(40);
                r.setHeight(40);

                grilleGridPane.add(r, j, i);
            }
        }
    }    
    
    @FXML
    public void handleOnActionStart(ActionEvent event) 
    {
       plateau.startGame();
       Button b = (Button) event.getSource();
       b.setDisable(true);
    }
    
    @FXML
    public void handleOnActionPause(ActionEvent event) 
    {
        plateau.pause();
    }
    
    
    
    public void draw()
    {
        for (int i = 0; i < numRows; i++) 
        {
            for (int j = 0; j < numCols; j++) 
            {
                
                Rectangle r = (Rectangle) getNodeByRowColumnIndex(i, j, this.grilleGridPane);
                if(plateau.getGrille().getTableauCase()[i][j] != null)
                    r.setFill(plateau.getGrille().getTableauCase()[i][j].getColor());
                else
                    r.setFill(javafx.scene.paint.Color.BLACK);
            }
        }
        
        for (int i = 0; i < numRows; i++) 
        {
            for (int j = 0; j < numCols; j++) 
            {
                if(plateau.getPieceCourante().getPositionPiece().getX() == i && plateau.getPieceCourante().getPositionPiece().getY()== j)
                {
                    Piece p = plateau.getPieceCourante();
                    int li = p.getTableauCases().length;
                    int c = p.getTableauCases()[0].length; 
//
//                    System.out.println("i = " + i);
//                    System.out.println("j = "+ j);
//
//                    System.out.println("l = " + li);
//                    System.out.println("c = "+ c);

                     for (int k = 0; k < li; k++) 
                     {
                        for (int l = 0; l < c; l++) 
                        {
                            Rectangle r = (Rectangle) getNodeByRowColumnIndex(i+k, j+l, this.grilleGridPane);
                            if(p.getTableauCases()[k][l] != null)
                            {
//                                System.out.println("");
                                r.setFill(p.getTableauCases()[k][l].getColor());
//                                System.out.println("k = " + k + "l = " + l);
                            }
                        }
                    }
                }
            }
        }
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                lblScore.setText(plateau.getScore().getScore()+"");
            }
        });
        
    }
    
    public Node getNodeByRowColumnIndex (final int row, final int column, GridPane gridPane) {
    Node result = null;
    ObservableList<Node> childrens = gridPane.getChildren();

    for (Node node : childrens) {
        if(node instanceof Rectangle){
            if(GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }
        
    }
    return result;
    }

    @FXML
    public void keyPressed(KeyEvent e) throws CloneNotSupportedException {
        KeyCode keyCode = e.getCode();
        Piece pcourante = plateau.getPieceCourante();
        
         switch( keyCode ) 
         { 
            case UP: 
              pcourante.translate(Translation.Haut, this.plateau.getGrille());
                break;
            case DOWN:
                pcourante.translate(Translation.Bas, this.plateau.getGrille());
                break;
            case LEFT:
                pcourante.translate(Translation.Gauche, this.plateau.getGrille());
                break;
            case RIGHT :
                pcourante.translate(Translation.Droite, this.plateau.getGrille());
                break;
        }
         draw();
    } 

    @Override
    public void update(Observable o, Object arg) {
        draw();
    }

    public Label getLblScore() {
        return lblScore;
    }
    
    
    
}
