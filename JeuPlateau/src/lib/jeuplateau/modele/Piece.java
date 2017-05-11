/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.jeuplateau.modele;

import jdk.nashorn.internal.objects.NativeArray;

/**
 *
 * @author Epulapp
 */
public class Piece  implements Cloneable  
{
    private Case[][] tableauCase;
    private Piece pieceCopie;
    private int x;
    private int y;
    
    public Piece(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.tableauCase = new Case[x][y];
        
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
        this.pieceCopie = this.clone();
        
        switch(trans){
            case Bas :
                traitementTranslationBas(this.pieceCopie.tableauCase);
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
    
    private void traitementTranslationBas(Case[][] tableau){
       Case[][] tableauVide = new Case[this.x][this.y];
        
        //parcours le tableau de case
        for (Case[] cases : tableau) {
            for (Case aCase : cases) {
                if(aCase.isBusy())
                {
                    tableauVide[aCase.getPosX()][aCase.getPosY()-1].setBusy(true);
                }
             }
        }
        this.tableauCase = tableauVide;
    }

    private void traitementTranslationHaut() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void traitementTranslationGauche() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void traitementTranslationDroite() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void traitementRotationDroite() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void traitementRotationGauche() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Piece clone() throws CloneNotSupportedException {
        Piece Copie = (Piece) super.clone();
        Copie.tableauCase = new Case[this.x][this.y];
        
        for (int i = 0; i < this.tableauCase.length; i++) {
            System.arraycopy(this.tableauCase[i], 0, Copie.tableauCase[i], 0, this.tableauCase[0].length);
        }
        return Copie; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
