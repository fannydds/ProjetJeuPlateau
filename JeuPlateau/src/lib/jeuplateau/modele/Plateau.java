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
    

    public Plateau(int col, int row ) {
        
        this.col = col;
        this.row = row;
        
        this.grille = new Grille(this.row, this.col);
        
        
         //La piece a poser
        Position[] pos = new Position[3];
        pos[0] = new Position(2,0);
        pos[1] = new Position(3,0);
        pos[2] = new Position(2,1);
        
        Piece p  = new Piece(pos);

        //liste des pieces deja sur le plateau
        Position[] pos2 = new Position[3];
        pos2[0] = new Position(0,0);
        pos2[1] = new Position(1,0);
        pos2[2] = new Position(2,1);
        Piece pDejaPosee  = new Piece(pos2);
        Position[] pos3 =new Position[3];
        pos3[0] = new Position(3,0);
        pos3[1] = new Position(3,1);
        pos3[2] = new Position(3,2);
        Piece pDejaPosee2  = new Piece(pos3);
        
        List<Piece> lip =  new ArrayList<Piece>();
        lip.add(pDejaPosee);
        lip.add(pDejaPosee2);
        
        this.grille.setPieceCourante(p);
        this.grille.setPiecesSurGrille(lip);
        
    }

    public Grille getGrille() {
        return grille;
    }
    
    
    
    
    
}
