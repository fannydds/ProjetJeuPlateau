/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.jeuplateau.modele;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import lib.jeuplateau.controleur.PlateauJeuController;

/**
 *
 * @author Epulapp
 */
public class JeuPlateau extends Application {
    
    PlateauJeuController controller;
    
    private int col = 10;
    private int row = 10;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lib/jeuplateau/vue/GrilleJeuVue.fxml"));
        Parent root = loader.load();
        controller =  loader.getController();
       
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                try {
                    controller.keyPressed(event);
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(JeuPlateau.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
        controller.initGrilleGridPane(col, row);
        
        
        
        stage.show();
        
        
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
