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
public class Plateau {
    
    private Grille grille;
    
    private int col;
    private int row;
    

    public Plateau(int col, int row ) {
        
        this.col = col;
        this.row = row;
        
        this.grille = new Grille(this.row, this.col);
        
    }
    
    
    
    
    
}
