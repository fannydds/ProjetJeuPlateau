/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.jeuplateau.modele;

import java.util.List;

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
   
    //Represente l ensemble des pieces deja posees sur la grille
    private List<Piece> piecesSurGrille;
    
    // La nouvelle piece a poser
    private Piece pieceCourante;

    public Grille(int x, int y) {
        this.tableauCase = new Case[x][y];
          for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
               this.tableauCase[i][j] = new Case(i,j) ;
            }
        }
        
    }

    public Piece getPieceCourante() {
        return pieceCourante;
    }

    public void setPieceCourante(Piece pieceCourante) {
        this.pieceCourante = pieceCourante;
    }

    public List<Piece> getPiecesSurGrille() {
        return piecesSurGrille;
    }

    public void setPiecesSurGrille(List<Piece> piecesSurGrille) {
        this.piecesSurGrille = piecesSurGrille;
    }
    

    
    
    
    
    
    
    
    
    
    
}
