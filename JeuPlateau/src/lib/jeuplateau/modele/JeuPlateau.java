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
    int col = 20;
    int row = 20;
    
    @Override
    public void start(Stage stage) throws Exception {
        grilleModele = new Grille(col, row);
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/lib/jeuplateau/vue/GrilleJeuVue.fxml"));
        controller = loader.getController();
       
        Parent root = FXMLLoader.load(getClass().getResource("/lib/jeuplateau/vue/GrilleJeuVue.fxml"));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
