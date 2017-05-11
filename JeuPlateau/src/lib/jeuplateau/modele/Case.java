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
public class Case implements Cloneable {
    
    private int posX;
    
    private int posY;
    
    private boolean busy;

    public Case(int x, int y) {
        this.posX = x;
        this.posY = y;
        this.busy = false;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    @Override
    protected Case clone() throws CloneNotSupportedException {
        return (Case) super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
