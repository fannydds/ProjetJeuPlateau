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
public class Piece 
{
    Case[][] tableauCase;
    
    public Piece(int x, int y)
    {
        this.tableauCase = new Case[x][y];
        
    }
    
    public boolean rotation(Rotation rot)
    {
        
        return true;
    }
    
    public boolean translate(Translation trans)
    {
         return true; 
    }
    
    
    
}
