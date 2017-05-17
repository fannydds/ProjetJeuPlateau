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
///////////////////////////////////////////////////////////// 

    public boolean rotation(Rotation rot)
    {
//TODO
        
        
        return true;
    }
    
    public boolean translate(Translation trans, Grille grille) throws CloneNotSupportedException
    {
        switch(trans){
            case Bas :
                traitementTranslationBas(grille);
                break;
            case Haut :
                traitementTranslationHaut(grille);
                break;
            case Gauche:
                traitementTranslationGauche(grille);
                break;
            case Droite:
                traitementTranslationDroite(grille);
                break;
            default :
                return false;
        }
        return true; 
    }
    
    private void traitementTranslationBas(Grille grille){
        Position pos = new Position(this.positionPiece.getX()+1, this.positionPiece.getY());
//        if(!enConflit(pos, grille))
            this.positionPiece.setX(this.positionPiece.getX()+1);
    }

    private void traitementTranslationHaut(Grille grille) {
        Position pos = new Position(this.positionPiece.getX()-1, this.positionPiece.getY());
       
        if(!enConflit(pos, grille))
            this.positionPiece.setX(this.positionPiece.getX()-1);
    }

    private void traitementTranslationGauche(Grille grille) {
        Position pos = new Position(this.positionPiece.getX(), this.positionPiece.getY()-1);
       
        if(!enConflit(pos, grille))
            this.positionPiece.setY(this.positionPiece.getY()-1);
    }

    private void traitementTranslationDroite(Grille grille) {
        Position pos = new Position(this.positionPiece.getX(), this.positionPiece.getY()+1);
       
        if(!enConflit(pos, grille))
            this.positionPiece.setY(this.positionPiece.getY()+1); 
    }

    private boolean enConflit(Position posApres, Grille grille){
        Case[][] cases = grille.getTableauCase();
        
        //Parcours grille de jeu
//        for (int i = 0; i < cases.length; i++) {
//            for (int j = 0; j < cases[0].length; j++) {
//                
                //Parcours grille de la piece
                for (int k = 0; k < this.tableauCases.length; k++) {
                    for (int l = 0; l < this.tableauCases[0].length; l++) {
                        if((cases[posApres.getX()+k][posApres.getY()+l] != null) && (this.tableauCases[k][l] != null))
                            return true;
                    }
                }
//            }
//        }
        return false;
    }
    
    
    public boolean rotation(){
        
        this.rotateTableauCasesBy90Degrees();

        return true;
    }
    
    
    private void rotateTableauCasesBy90Degrees() {
		Case[][] newTabCases = createNewTableauCases();
               
		int columns = newTabCases.length;
		int rows = newTabCases[0].length;
		
		for (int j = 0; j < columns; j++) {
			for (int i = 0, k = rows - 1; i < rows; i++, k--) {
				newTabCases[j][i] = this.tableauCases[k][j];
			}
		}
		this.tableauCases = newTabCases;
	}

	private Case[][] createNewTableauCases() {
            
            int col = this.tableauCases.length;
            int row = this.tableauCases[0].length;
		return new Case[col][row];
	}
}
