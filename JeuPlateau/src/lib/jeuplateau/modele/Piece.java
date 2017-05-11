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
    
    public boolean translate(Translation trans)
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
    
    
    
    
    
}
