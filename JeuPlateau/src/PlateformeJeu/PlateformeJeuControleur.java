/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlateformeJeu;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import puissance.modele.JeuPuissance;
import tetris.modele.JeuTetris;

/**
 *
 * @author Epulapp
 */
public class PlateformeJeuControleur implements Initializable {
    
    @FXML
    private Button btTetris;

    @FXML
    private Button btPuissance4;

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    @FXML
    void handleOnActionPuissance(ActionEvent event) {
        
        JeuPuissance jeuPuissance = new JeuPuissance();
        try {
            jeuPuissance.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(PlateformeJeuControleur.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void handleOnActionTetris(ActionEvent event) {
        
        JeuTetris jeuTetris = new JeuTetris();
        try {
            jeuTetris.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(PlateformeJeuControleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    
    
}
