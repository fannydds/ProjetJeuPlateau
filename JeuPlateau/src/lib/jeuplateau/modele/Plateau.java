/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.jeuplateau.modele;

import java.util.ArrayList;
import java.util.List;

/**
 * Represente une grille contenant des pieces + autres elements (labels, scores...)
 * @author Epulapp
 */
public class Plateau {
    
    private Grille grille;
    
    private int col;
    private int row;
    
    private Piece pieceCourante;

    public void setPieceCourante(Piece pieceCourante) {
        this.pieceCourante = pieceCourante;
    }

    public Plateau( int col, int row) {
        this.col = col;
        this.row = row;
        this.grille = new Grille(this.row, this.col);
    }

    public Grille getGrille() {
        return grille;
    }
     
    public void setGrille(Grille grille) {
        this.grille = grille;
    }
    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public Piece getPieceCourante() {
        return pieceCourante;
    }
}
