/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.modele;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
import lib.jeuplateau.modele.Case;
import lib.jeuplateau.modele.Piece;
import lib.jeuplateau.modele.Position;

/**
 *
 * @author Epulapp
 */
public class PieceTetris extends Piece{
    
    
    private PieceTetris(Case[][] cases, Position p)  {
        super(cases, p);
    }

    public static PieceTetris getCarre() {
        
        return new PieceTetris(new Case[][]{ {new Case(Color.YELLOW), new Case(Color.YELLOW) }, {new Case(Color.YELLOW), new Case(Color.YELLOW)} }, new Position(0, 5));
    }

    public static PieceTetris getLigne() {

        return new PieceTetris(new Case[][]{{new Case(Color.AQUA)}, {new Case(Color.AQUA)}, {new Case(Color.AQUA)}, {new Case(Color.AQUA)}}, new Position(0, 5));
    }

    public static PieceTetris getlDroite() {
        return new PieceTetris(new Case[][]{ {new Case(Color.BLUE), new Case(Color.BLUE) }, {new Case(Color.BLUE), null}, {new Case(Color.BLUE), null} }, new Position(0, 5));
    }

    public static PieceTetris getlGauche() {
        
        return new PieceTetris(new Case[][]{ {new Case(Color.ORANGE), new Case(Color.ORANGE)},{null, new Case(Color.ORANGE)},{null,new Case(Color.ORANGE)} }, new Position(0, 5));
    }

    public static PieceTetris getzDroite() {
        
        return new PieceTetris(new Case[][]{ {null, new Case(Color.LIME), new Case(Color.LIME) },{new Case(Color.LIME), new Case(Color.LIME), null}}, new Position(0, 5));
    }

    public static PieceTetris getzGauche() {
        return new PieceTetris(new Case[][]{{new Case(Color.RED), new Case(Color.RED), null},{null, new Case(Color.RED), new Case(Color.RED) }}, new Position(0, 5));
    }

    public static PieceTetris getT() {
        return new PieceTetris(new Case[][]{{new Case(Color.PURPLE), new Case(Color.PURPLE), new Case(Color.PURPLE)},{null, new Case(Color.PURPLE), null}}, new Position(0, 5));
    }
    
    
    
    public static Piece getRandomPieceTetris(){
        
        PieceTetris p = null;
        
        Random r = new Random();
        int i = r.nextInt(6);
        
        switch(i){
            case 0 : 
                p = getCarre();
                break;
            case 1 : 
                p = getLigne();
                break;
            case 2 : 
                p = getT();
                break;
            case 3 : 
                p = getlDroite();
                break;
            case 4 : 
                p = getlGauche();
                break;
            case 5 : 
                p = getzDroite();
                break;
            case 6 : 
                p = getzGauche();
                break;
        }
        return p;
    }
    
    
    
    
    
    
    
}
