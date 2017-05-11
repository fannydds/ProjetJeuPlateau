/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.jeuplateau.modele;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Epulapp
 */
public class JeuPlateau extends Application {
    
    Grille grilleModele;
    GrilleJeuController controller;
    private int col;
    private int row;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        col = 10;
        row = 10;
                
        grilleModele = new Grille(col, row);
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lib/jeuplateau/vue/GrilleJeuVue.fxml"));
        Parent root = loader.load();
        controller =  loader.getController();
       
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        controller.initGrilleGridPane(col, row);
        
        stage.show();
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
