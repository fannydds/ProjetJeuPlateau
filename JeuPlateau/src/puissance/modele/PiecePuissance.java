/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puissance.modele;

import javafx.scene.paint.Color;
import lib.jeuplateau.modele.Case;
import lib.jeuplateau.modele.Piece;
import lib.jeuplateau.modele.Position;
import tetris.modele.PieceTetris;

/**
 *
 * @author Mathie
 */
public class PiecePuissance  extends Piece{

    private PiecePuissance(Case[][] cases, Position p)  {
        super(cases, p);
    }

    public static PiecePuissance getJaune() {
        return new PiecePuissance(new Case[][]{ {new Case(Color.YELLOW) } }, new Position(0, 3));
    }
    
    public static PiecePuissance getRouge() {
        return new PiecePuissance(new Case[][]{ {new Case(Color.RED) } }, new Position(0, 3));
    }
    
    public static PiecePuissance getPiece(boolean couleur) {
        if(couleur)
            return getJaune();
        else
            return getRouge();
    }
}
