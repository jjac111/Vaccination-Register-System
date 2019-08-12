/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vacunas;

import entidades.Clinica;
import entidades.Infante;
import entidades.RegionEstudio;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Juan Javier Arosemena
 */
public class Vacunas extends Application {
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("VacunasFXML.fxml"));
        Scene rootScene = new Scene(root);
        stage.setScene(rootScene);
        stage.show();
        
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
