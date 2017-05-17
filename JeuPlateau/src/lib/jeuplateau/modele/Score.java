/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.jeuplateau.modele;

/**
 * @author Mathie
 */
public class Score 
{

    private int score;

    public Score() 
    {
        this.score = 0;
    }

    public int getScore() 
    {
        return score;
    }
    
    public void setScore(int score) 
    {
        this.score = score;
    }

    public void add(int i)
    {
        setScore(this.score + i);
    }

    public void reset() 
    {
        setScore(0);
    }
}

