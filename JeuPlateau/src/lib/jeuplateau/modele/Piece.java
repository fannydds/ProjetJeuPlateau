/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.jeuplateau.modele;

import java.util.Arrays;
import java.util.Random;
import jdk.nashorn.internal.objects.NativeArray;

/**
 *
 * @author Epulapp
 */
public class Piece  implements Cloneable  
{
    //tableau contenant les positions absolues occupees
    private Case[][] tableauCases;

    //position de la piece en haut a gauche
    private Position positionPiece;
    
    
    //Une piece est composee d un tableau de cases 
    public Piece(Case[][] tableauCases, Position positionPiece) 
    {
        this.tableauCases = tableauCases;
        this.positionPiece = positionPiece;
    }

//////////////////// Getter Setter //////////////////// 
    public Case[][] getTableauCases() {
        return tableauCases;
    }

    public void setTableauCases(Case[][] tableauCases) {
        this.tableauCases = tableauCases;
    }

    public Position getPositionPiece() {
        return positionPiece;
    }

    public void setPositionPiece(Position positionPiece) {
        this.positionPiece = positionPiece;
    }
    
    public boolean translate(Translation trans, Grille grille) throws CloneNotSupportedException
    {
        boolean ok = false;
        switch(trans){
            case Bas :
                ok = traitementTranslationBas(grille);
                break;
            case Haut :
                ok = traitementTranslationHaut(grille);
                break;
            case Gauche:
                ok = traitementTranslationGauche(grille);
                break;
            case Droite:
                ok = traitementTranslationDroite(grille);
                break;
        }
        return ok; 
    }
    
    private boolean traitementTranslationBas(Grille grille){
        Position pos = new Position(this.positionPiece.getX()+1, this.positionPiece.getY());
        if(!enConflit(pos, grille,this.getTableauCases())){
            this.positionPiece.setX(this.positionPiece.getX()+1);
            return true;
        }
        return false;
            
            
    }

    private boolean traitementTranslationHaut(Grille grille) {
        Position pos = new Position(this.positionPiece.getX()-1, this.positionPiece.getY());
       
        if(!enConflit(pos, grille,this.getTableauCases())){
            this.positionPiece.setX(this.positionPiece.getX()-1);
                return true;
        }
        return false;
    }

    private boolean traitementTranslationGauche(Grille grille) {
        Position pos = new Position(this.positionPiece.getX(), this.positionPiece.getY()-1);
       
        if(!enConflit(pos, grille,this.getTableauCases())){
            this.positionPiece.setY(this.positionPiece.getY()-1);
                return true;
        }
        return false;
    }

    private boolean traitementTranslationDroite(Grille grille) {
        Position pos = new Position(this.positionPiece.getX(), this.positionPiece.getY()+1);
       
        if(!enConflit(pos, grille,this.getTableauCases())){
            this.positionPiece.setY(this.positionPiece.getY()+1);
                return true;
        }
        return false;
    }

    private boolean enConflit(Position posApres, Grille grille, Case[][] tab) 
    {
        Case[][] cases = grille.getTableauCase();

        //Parcours grille de la piece
        for (int k = 0; k < tab.length; k++) 
        {
            for (int l = 0; l < tab[0].length; l++) 
            {
                Position pos1 = new Position((posApres.getX()+k), (posApres.getY()+l));
                if((cases[pos1.getX()][pos1.getY()] != null) 
                        && (tab[k][l] != null))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    
    public boolean rotation(Grille grille)
    {
        return this.rotateTableauCasesBy90Degrees(grille);

    }
//    
//    public boolean positionHorsGrille(Grille grille, Position pos){
//        if((0<=pos.getX())
//            &&(pos.getX()<grille.getTableauCase().length)
//            &&(0<=pos.getY())
//            &&(pos.getY()<grille.getTableauCase()[0].length))
//            {
//                return false;
//            }
//        System.out.println("zzzz");
//        return true;
//    }
    
    private boolean rotateTableauCasesBy90Degrees(Grille grille) 
    {
	Case[][] newTabCases = createNewTableauCases();
        
	int columns = newTabCases.length;
	int rows = newTabCases[0].length;
	
	for (int j = 0; j < columns; j++) {
		for (int i = 0, k = rows - 1; i < rows; i++, k--) {
			newTabCases[j][i] = this.tableauCases[k][j];
		}
	}
        if(!enConflit(this.positionPiece, grille,newTabCases)){
            this.tableauCases = newTabCases;
            return true;
        }
        
        return false;
    }

	private Case[][] createNewTableauCases() 
        {
            int col = this.tableauCases[0].length;
            int row = this.tableauCases.length;
		return new Case[col][row];
	}
}
