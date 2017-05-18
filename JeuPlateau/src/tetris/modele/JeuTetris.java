/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.modele;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import lib.jeuplateau.controleur.PlateauJeuController;
import lib.jeuplateau.modele.JeuPlateau;
import lib.jeuplateau.modele.Plateau;
import tetris.controleur.PlateauTetrisController;

/**
 *
 * @author Epulapp
 */
public class JeuTetris extends Application {

    private PlateauJeuController controller;
    
    private Plateau plateau = new PlateauTetris();
    
    @Override
    public void start(Stage stage) throws Exception {
        
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lib/jeuplateau/vue/GrilleJeuVue.fxml"));
        
        controller =  loader.getController();
        
        loader.setController(new PlateauTetrisController());
        loader.setRoot(null);
        controller =  loader.getController();
        Parent root = loader.load();
        
        
       
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
        
        
        controller.initGrilleGridPane(plateau);
        
         stage.setResizable(false);
         stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
});
        
        stage.show();
        
       
        
    }
    
    
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
