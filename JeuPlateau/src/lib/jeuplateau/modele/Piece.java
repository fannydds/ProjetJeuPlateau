/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.jeuplateau.modele;

import java.util.Random;
import jdk.nashorn.internal.objects.NativeArray;

/**
 *
 * @author Epulapp
 */
public class Piece  implements Cloneable  
{
    //tableau contenant les positions absolues occupees
    private Position[] tableauCaseBusy;

    private String color;
    
    //position de la premiere case en haut a gauche (utilise pour les conflits)
    private int x;
    private int y;
    
    //Represente la largeur et hauteur de la piece (pour les rotations, translations)
    private int width;
    private int height;
    
    //Matrice de booleens representant les cases occupees et vides (pour la rotation, translation)
    private boolean[] casesOccupees;
    
    //Une piece est composee d un tableau de positions occupees
    public Piece(Position[] pos)
    {
        this.tableauCaseBusy = pos;
       
        this.x=pos[0].getX();
        this.y=pos[0].getY();
        
        //TODO a calculer avec le tableau de position
        this.height = pos.length;
//        this.width = pos[0];

        Random random = new Random();
        int nextInt = random.nextInt(256*256*256);
        String colorCode = String.format("#%06x", nextInt);
        this.color = colorCode;
        

    }

    public Position[] getTableauCaseBusy() {
        return tableauCaseBusy;
    }

    public void setTableauCaseBusy(Position[] tableauCaseBusy) {
        this.tableauCaseBusy = tableauCaseBusy;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean[] getCasesOccupees() {
        return casesOccupees;
    }

    public void setCasesOccupees(boolean[] casesOccupees) {
        this.casesOccupees = casesOccupees;
    }

    public String getColor() {
        return color;
    }


    
   
    public boolean rotation(Rotation rot)
    {
        switch(rot){
            case Droite :
                traitementRotationDroite();
                break;
            case Gauche:
                traitementRotationGauche();
                break;
            default :
                return false;
        }
        return true;
    }
    
    public boolean translate(Translation trans) throws CloneNotSupportedException
    {
//        this.pieceCopie = this.clone();
        
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
        for (Position case1 : tableauCaseBusy) {
            case1.setX(case1.getX()+1);
        }
    }

    private void traitementTranslationHaut() {
        for (Position case1 : tableauCaseBusy) {
            case1.setX(case1.getX()-1);
        }
    }

    private void traitementTranslationGauche() {
        for (Position case1 : tableauCaseBusy) {
            case1.setY(case1.getY()-1);
        }    
    }

    private void traitementTranslationDroite() {
        for (Position case1 : tableauCaseBusy) {
            case1.setY(case1.getY()+1);
        } 
    }

    private void traitementRotationDroite() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void traitementRotationGauche() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



//    @Override
//    protected Piece clone() throws CloneNotSupportedException {
//        Piece Copie = (Piece) super.clone();
//        Copie.tableauCase = new Case[this.x][this.y];
//        
//        for (int i = 0; i < this.tableauCase.length; i++) {
//            System.arraycopy(this.tableauCase[i], 0, Copie.tableauCase[i], 0, this.tableauCase[0].length);
//        }
//        return Copie; //To change body of generated methods, choose Tools | Templates.
//    }
    
    
    
    
    
}
