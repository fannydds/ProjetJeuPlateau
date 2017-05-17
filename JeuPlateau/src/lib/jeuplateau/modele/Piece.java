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
    
    public boolean translate(Translation trans) throws CloneNotSupportedException
    {
        switch(trans){
            case Bas :
                traitementTranslationBas();
                break;
            case Haut :
                traitementTranslationHaut();
                break;
            case Gauche:
                traitementTranslationGauche();
                break;
            case Droite:
                traitementTranslationDroite();
                break;
            default :
                return false;
        }
        return true; 
    }
    
    private void traitementTranslationBas(){
 this.positionPiece.setX(this.positionPiece.getX()+1);
    }

    private void traitementTranslationHaut() {
this.positionPiece.setX(this.positionPiece.getX()-1);
    }

    private void traitementTranslationGauche() {
this.positionPiece.setY(this.positionPiece.getY()-1);
    }

    private void traitementTranslationDroite() {
        this.positionPiece.setY(this.positionPiece.getY()+1); 
    }

}
