/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.jeuplateau.modele;

import java.util.List;
import javafx.scene.paint.Color;

/**
 * Represente la grille ou les pieces vont bouger
 * @author Epulapp
 */
public class Grille {
    
    // Le tableau de cases
    private Case[][] tableauCase;
    
    // La taille du tableau de cases
    private int largeur;
    private int hauteur;

    public Grille(int x, int y) {
        this.largeur = x;
        this.hauteur = y;
        
        this.tableauCase = new Case[x][y];
        
//        this.tableauCase[9][9]=new Case(Color.RED);
    }

    public Case[][] getTableauCase() {
        return tableauCase;
    }

    public void setTableauCase(Case[][] tableauCase) {
        this.tableauCase = tableauCase;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }
 
    public void ajoutPiece(Piece p)
    {
        Case[][] tabCasePiece = p.getTableauCases();
        for (int i = 0; i < tabCasePiece.length; i++) 
        {
            for (int j = 0; j < tabCasePiece[0].length; j++) 
            {
                this.tableauCase[p.getPositionPiece().getX()+i][p.getPositionPiece().getY()+j] = p.getTableauCases()[i][j];
            }
        }
    }
}
