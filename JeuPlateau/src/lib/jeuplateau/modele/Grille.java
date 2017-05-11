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

    public Grille(int l, int c) {
        this.tableauCase = new Case[l][c];
        
    }

    public Piece getPieceCourante() {
        return pieceCourante;
    }

    public void setPieceCourante(Piece pieceCourante) {
        this.pieceCourante = pieceCourante;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
