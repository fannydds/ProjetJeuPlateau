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
    
    Case[][] tableauCase;
    
    Piece pieceCourante;

    public Grille(int l, int c) {
        this.tableauCase = new Case[l][c];
        
    }
    
    public void ajoutPiece(Piece p){
        this.pieceCourante = p;
        
    }
    
    
    
    
    
    
}
