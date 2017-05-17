/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.modele;

import javafx.stage.Stage;
import lib.jeuplateau.modele.JeuPlateau;

/**
 *
 * @author Epulapp
 */
public class JeuTetris extends JeuPlateau{

    @Override
    public void start(Stage stage) throws Exception {
        this.setCol(PlateauTetris.NB_COLS);
        this.setRow(PlateauTetris.NB_ROWS);
        
        super.start(stage); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
