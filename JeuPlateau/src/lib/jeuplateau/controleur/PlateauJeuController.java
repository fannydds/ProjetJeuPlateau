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
public class PlateauJeuController implements Initializable {
    
    @FXML
    private GridPane grilleGridPane;
    private Grille copie;
    
    private int numCols;
    private int numRows;
    
    Plateau plateau;
    
    Button btStart;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {}   
    
    public void initGrilleGridPane(int col, int row)
    {
        numCols = col;
        numRows = row;
        this.plateau = new Plateau(col, row);
       
        Position positionPiece = new Position(1,1);
        Case[][] tabCase = new Case[2][2];
        tabCase[0][0]=new Case(javafx.scene.paint.Color.BEIGE);
        tabCase[0][1]=new Case(javafx.scene.paint.Color.BEIGE);
        tabCase[1][0]=new Case(javafx.scene.paint.Color.BEIGE);
        tabCase[1][1]=null;
        Piece p1 = new Piece(tabCase, positionPiece);
        
        plateau.setPieceCourante(p1);

        grilleGridPane.getRowConstraints().clear();
        grilleGridPane.getColumnConstraints().clear();

        for (int i = 0; i < numCols; i++) {
            for (int j = 0; j < numRows; j++) {
                Rectangle r = new Rectangle();
                
                if(plateau.getGrille().getTableauCase()[i][j] != null)
                    r.setFill(plateau.getGrille().getTableauCase()[i][j].getColor());
                else
                    r.setFill(javafx.scene.paint.Color.BLACK);
                
                r.setWidth(20);
                r.setHeight(20);

                grilleGridPane.add(r, i, j);
            }
        }
        
        plateau.getGrille().ajoutPiece(p1);
    }    
    
    @FXML
    public void handlerOnActionButtonDown(ActionEvent event) throws CloneNotSupportedException 
    {
        Piece pcourante = plateau.getPieceCourante();
        pcourante.translate(Translation.Bas);
//        this.plateau.getGrille().setTableauCase(this.copie);
        
        draw();
    }
    
    public void draw()
    {
        this.copie = copie();
        this.copie.ajoutPiece(plateau.getPieceCourante());
        System.out.println("lib.jeuplateau.controleur.PlateauJeuController.draw()");
        for (int i = 0; i < numCols; i++) {
            for (int j = 0; j < numRows; j++) {
                Rectangle r = (Rectangle) getNodeByRowColumnIndex(i, j, this.grilleGridPane);

                if(copie.getTableauCase()[i][j] != null)
                    r.setFill(copie.getTableauCase()[i][j].getColor());
                else
                    r.setFill(javafx.scene.paint.Color.BLACK);
            }
        }
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
    
    public Grille copie()
    {
        Grille tab = this.plateau.getGrille();
        Grille tabCopie = new Grille(numCols, numCols);
        tabCopie.setHauteur(tab.getHauteur());
        tabCopie.setLargeur(tab.getLargeur());
        
        Case[][] tabCases = new Case[tab.getTableauCase().length][tab.getTableauCase()[0].length];
        for (int i = 0; i < tab.getTableauCase().length; i++) 
        {
            for (int j = 0; j < tab.getTableauCase()[0].length; j++) 
            {
                tabCases[i][j] = new Case(tab.getTableauCase()[i][j].getColor());
            }
        }
        tabCopie.setTableauCase(tabCases);
        return tabCopie;
    }
    
    @FXML
    public void keyPressed(KeyEvent e) throws CloneNotSupportedException {
        KeyCode keyCode = e.getCode();
        Piece pcourante = plateau.getPieceCourante();
//        this.plateau.getGrille().setTableauCa¢se(this.copie);
//        copie.ajoutPiece(pcourante);
         switch( keyCode ) 
         { 
            case UP:
                pcourante.translate(Translation.Haut);
                draw();
                break;
            case DOWN:
                pcourante.translate(Translation.Bas);
                 draw();
                break;
            case LEFT:
                pcourante.translate(Translation.Gauche);
                 draw();
                break;
            case RIGHT :
                pcourante.translate(Translation.Droite);
                 draw();
                break;
        }
    } 
}
