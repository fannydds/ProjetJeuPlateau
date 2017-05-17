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
//    
//    private Position getMaxXY(Position[] tableauPosition)
//    {
//        int maxX = tableauCaseBusy[0].getX();
//        int maxY = tableauCaseBusy[0].getY();
//        
//        for (Position position : tableauPosition) 
//        {
//           if(position.getX()>maxX)
//               maxX = position.getX();
//           if(position.getY()>maxY)
//               maxY = position.getY();
//        }
//        
//        Position pos = new Position(maxX,maxY);
//        return pos;
//    }
//    
//       private Position getMinXY(Position[] tableauPosition)
//    {
//        int minX = tableauCaseBusy[0].getX();
//        int minY = tableauCaseBusy[0].getY();
//        
//        for (Position position : tableauPosition) 
//        {
//           if(position.getX()<minX)
//               minX = position.getX();
//           if(position.getY()<minY)
//               minY = position.getY();
//        }
//        
//        Position pos = new Position(minX,minY);
//        return pos;
//    }

//       private boolean[][] creerMatriceZeros()
//       {
//            Position posMin = getMinXY(this.tableauCaseBusy);
//            Position posMax = getMaxXY(this.tableauCaseBusy);
//           
//            boolean[][] tableau = new boolean[posMax.getX()-posMin.getX()+2][posMax.getY()-posMin.getY()+2];
//            for (int i = posMin.getX(); i <=posMax.getX(); i++) {
//               for (int j = posMin.getY(); j <= posMax.getY(); j++) {
//                   tableau[i][j] = false;
//               }
//            }
//           
//            for (Position case1 : tableauCaseBusy) 
//            {
//               tableau[case1.getX()][case1.getY()] = true;
//            }
//           return tableau;
//       }
    
    
    
    
    
}
