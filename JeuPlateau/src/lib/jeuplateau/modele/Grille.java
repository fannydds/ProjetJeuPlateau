/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.jeuplateau.modele;

/**
 *
 * @author Epulapp
 */
public class Grille {
    
    private Case[][] tableauCase;
    
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
    
    
    
    
    
    
    
    
    
    
    
    
}
