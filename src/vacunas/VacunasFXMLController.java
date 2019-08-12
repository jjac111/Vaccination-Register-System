/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vacunas;

import entidades.Clinica;
import entidades.FileManager;
import entidades.Infante;
import entidades.RegionEstudio;
import entidades.myException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Juan Javier Arosemena
 */
public class VacunasFXMLController implements Initializable {

    private static RegionEstudio REG = new RegionEstudio();
    private static ObservableList<String> nombresInfantes = FXCollections.observableArrayList();
    private static ObservableList<String> cedulasInfantes = FXCollections.observableArrayList();
    private static ObservableList<String> nombresClinicas = FXCollections.observableArrayList();
    private static ObservableList<ObservableList<String>> nombresInfantesDeClinicas = FXCollections.observableArrayList();
    private boolean infantesToggleValue = true;
    private Alert alert = new Alert(AlertType.INFORMATION);
    private FileManager manager = new FileManager();

    @FXML
    private Button infantesAddButton;
    @FXML
    private ListView<String> infantesList;
    @FXML
    private CheckBox infantesToggle;
    @FXML
    private Button infantesRemove;
    @FXML
    private Label infantesNombre;
    @FXML
    private Label infantesCedula;
    @FXML
    private Label infantesEdad;
    @FXML
    private TextField infantesNombreTxtF;
    @FXML
    private TextField infantesCedulaTxtF;
    @FXML
    private TextField infantesEdadTxtF;
    @FXML
    private ListView<String> mainMenuClinicasList;
    @FXML
    private Button mainMenuClinicaRemoveButton;
    @FXML
    private Button mainMenuMayorVacunasButton;
    @FXML
    private Button mainMenuInfanteSeleccionadoButton;
    @FXML
    private Button mainMenuEdadPromedioButton;
    @FXML
    private Button mainMenuIncumplimientoButton;
    @FXML
    private TextArea mainMenuMessages;
    @FXML
    private ListView<String> clinicasList;
    @FXML
    private ListView<String> clinicasInfantesList;
    @FXML
    private ChoiceBox<String> clinicasInfantesOptions;
    @FXML
    private Button clinicasInfanteAddButton;
    @FXML
    private Button clinicasInfanteRemoveButton;
    @FXML
    private Label clinicasID;
    @FXML
    private StackPane clinicasEditVacunas;
    @FXML
    private TextField vac1;
    @FXML
    private TextField vac2;
    @FXML
    private TextField vac3;
    @FXML
    private TextField vac4;
    @FXML
    private TextField vac5;
    @FXML
    private TextField vac6;
    @FXML
    private TextField vac7;
    @FXML
    private TextField vac8;
    @FXML
    private TextField vac9;
    @FXML
    private TextField vac10;
    @FXML
    private TextField vac11;
    @FXML
    private TextField vac12;
    @FXML
    private TextField vac13;
    @FXML
    private TextField vac14;
    @FXML
    private TextField vac15;
    @FXML
    private TextField vac16;
    @FXML
    private TextField vac17;
    @FXML
    private TextField vac18;
    @FXML
    private TextField vac19;
    @FXML
    private TextField vac20;
    @FXML
    private TextField vac21;
    @FXML
    private TextField vac22;
    @FXML
    private TextField vac23;
    @FXML
    private TextField vac24;
    @FXML
    private TextField vac25;
    @FXML
    private TextField vac26;
    @FXML
    private TextField vac27;
    @FXML
    private TextField vac28;
    @FXML
    private TextField vac29;
    @FXML
    private TextField vac30;
    @FXML
    private TextField vac31;
    @FXML
    private Button vacUpdateButton;
    @FXML
    private Button vacCancelButton;
    @FXML
    private TextField newID;
    @FXML
    private Button vacNewButton;
    @FXML
    private Button clinicasEditButton;
    @FXML
    private Button mainMenuComprobarButton;
    @FXML
    private StackPane mainMenuInfanteAsk;
    @FXML
    private TextField mainMenuNombreInfante;
    @FXML
    private TextArea datosAlmacenadosTxtArea;
    @FXML
    private Button datosAlmacenadosInfantesregionalesButton;
    @FXML
    private Button datosAlmacenadosSeleccionButton;
    @FXML
    private Button datosAlmacenadosEdadesPromedioButton;
    @FXML
    private Button datosAlmacenadosMayoresVacunacionesButton;
    @FXML
    private Button datosAlmacenadosIncumplimientosButton;

    @FXML
    protected void handleInfantesAddButton(ActionEvent event) {
        try{
            if (!infantesCedulaTxtF.getText().matches("[0-9]+") || !infantesEdadTxtF.getText().matches("[0-9]+") || infantesCedulaTxtF.getText().length() > Infante.MAX_CEDULA_LENGTH) {
                throw new myException(0);
            }
                Infante inf = new Infante(infantesNombreTxtF.getText(), infantesCedulaTxtF.getText(), Integer.parseInt(infantesEdadTxtF.getText()));
                if (!REG.InfanteExists(inf)) {
                    REG.addInfante(inf);
                    updateInfantesList();
                    infantesNombreTxtF.clear();
                    infantesCedulaTxtF.clear();
                    infantesEdadTxtF.clear();
                } else {
                    alert.setTitle("Warning");
                    alert.setHeaderText("Infante Existe");
                    alert.setContentText("Ya existe un infante con igual cédula");
                    alert.showAndWait();
                }
        
        }
        catch(Exception e){
            alert.setTitle("Warning");
            alert.setHeaderText("Datos Inválidos");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    protected void handleInfantesUpdateButton(ActionEvent event) {
        try{
            if (!infantesList.getSelectionModel().isEmpty()) {
                if (!infantesCedulaTxtF.getText().matches("[0-9]+") || !infantesEdadTxtF.getText().matches("[0-9]+") || infantesCedulaTxtF.getText().length() > Infante.MAX_CEDULA_LENGTH) {
                    throw new myException(0);
                } 
                    REG.setInfanteAt(new Infante(infantesNombreTxtF.getText(), infantesCedulaTxtF.getText(), Integer.parseInt(infantesEdadTxtF.getText())), infantesList.getSelectionModel().getSelectedIndex());
                    updateInfantesList();
                    infantesNombreTxtF.clear();
                    infantesCedulaTxtF.clear();
                    infantesEdadTxtF.clear();
                    infantesNombre.setText("");
                    infantesCedula.setText("");
                    infantesEdad.setText("");
            }
        }
        catch(Exception e){
            alert.setTitle("Warning");
            alert.setHeaderText("Datos Inválidos");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    protected void handleInfantesRemoveButton(ActionEvent event) {
        try{
            if (!infantesList.getSelectionModel().isEmpty()) {
                REG.removeInfante(infantesList.getSelectionModel().getSelectedIndex());
                updateInfantesList();
                infantesNombre.setText("");
                infantesCedula.setText("");
                infantesEdad.setText("");
            }
        }
        catch(Exception e){
            alert.setTitle("Warning");
            alert.setHeaderText("Datos Inválidos");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    protected void handleInfantesToggle(ActionEvent event) {
        try{
            infantesToggleValue = !infantesToggleValue;
            updateInfantesList();
        }
        catch(Exception e){
            alert.setTitle("Warning");
            alert.setHeaderText("Datos Inválidos");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    protected void handleClinicasEditButton(ActionEvent event) {
        try{
            clinicasEditVacunas.setVisible(true);
        }
        catch(Exception e){
            alert.setTitle("Warning");
            alert.setHeaderText("Datos Inválidos");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    protected void handleClinicasEditVacunasNewButton(ActionEvent event) {
        try{
            if (!vac1.getText().matches("[0-9]+") || !vac2.getText().matches("[0-9]+") || !vac3.getText().matches("[0-9]+") || !vac4.getText().matches("[0-9]+") || !vac5.getText().matches("[0-9]+") || !vac6.getText().matches("[0-9]+") || !vac7.getText().matches("[0-9]+") || !vac8.getText().matches("[0-9]+") || !vac9.getText().matches("[0-9]+") || !vac10.getText().matches("[0-9]+") || !vac11.getText().matches("[0-9]+") || !vac12.getText().matches("[0-9]+") || !vac13.getText().matches("[0-9]+") || !vac14.getText().matches("[0-9]+") || !vac15.getText().matches("[0-9]+") || !vac16.getText().matches("[0-9]+") || !vac17.getText().matches("[0-9]+") || !vac18.getText().matches("[0-9]+") || !vac19.getText().matches("[0-9]+") || !vac20.getText().matches("[0-9]+") || !vac21.getText().matches("[0-9]+") || !vac22.getText().matches("[0-9]+") || !vac23.getText().matches("[0-9]+") || !vac24.getText().matches("[0-9]+") || !vac25.getText().matches("[0-9]+") || !vac26.getText().matches("[0-9]+") || !vac27.getText().matches("[0-9]+") || !vac28.getText().matches("[0-9]+") || !vac29.getText().matches("[0-9]+") || !vac30.getText().matches("[0-9]+") || !vac31.getText().matches("[0-9]+") || !newID.getText().matches("[0-9]+") || newID.getText().length() > Infante.MAX_CEDULA_LENGTH) 
                throw new myException(1);
            String ID = newID.getText();
            ArrayList<Integer> VACUNAS = new ArrayList<>();
            VACUNAS.add(Integer.parseInt(vac1.getText()));
            VACUNAS.add(Integer.parseInt(vac2.getText()));
            VACUNAS.add(Integer.parseInt(vac3.getText()));
            VACUNAS.add(Integer.parseInt(vac4.getText()));
            VACUNAS.add(Integer.parseInt(vac5.getText()));
            VACUNAS.add(Integer.parseInt(vac6.getText()));
            VACUNAS.add(Integer.parseInt(vac7.getText()));
            VACUNAS.add(Integer.parseInt(vac8.getText()));
            VACUNAS.add(Integer.parseInt(vac9.getText()));
            VACUNAS.add(Integer.parseInt(vac10.getText()));
            VACUNAS.add(Integer.parseInt(vac11.getText()));
            VACUNAS.add(Integer.parseInt(vac12.getText()));
            VACUNAS.add(Integer.parseInt(vac13.getText()));
            VACUNAS.add(Integer.parseInt(vac14.getText()));
            VACUNAS.add(Integer.parseInt(vac15.getText()));
            VACUNAS.add(Integer.parseInt(vac16.getText()));
            VACUNAS.add(Integer.parseInt(vac17.getText()));
            VACUNAS.add(Integer.parseInt(vac18.getText()));
            VACUNAS.add(Integer.parseInt(vac19.getText()));
            VACUNAS.add(Integer.parseInt(vac20.getText()));
            VACUNAS.add(Integer.parseInt(vac21.getText()));
            VACUNAS.add(Integer.parseInt(vac22.getText()));
            VACUNAS.add(Integer.parseInt(vac23.getText()));
            VACUNAS.add(Integer.parseInt(vac24.getText()));
            VACUNAS.add(Integer.parseInt(vac25.getText()));
            VACUNAS.add(Integer.parseInt(vac26.getText()));
            VACUNAS.add(Integer.parseInt(vac27.getText()));
            VACUNAS.add(Integer.parseInt(vac28.getText()));
            VACUNAS.add(Integer.parseInt(vac29.getText()));
            VACUNAS.add(Integer.parseInt(vac30.getText()));
            VACUNAS.add(Integer.parseInt(vac31.getText()));
            Clinica cli = new Clinica(ID, VACUNAS, new ArrayList<>());
            if(cli.getVacunasTotal() > REG.getInfantesRegion().size())
                throw new myException(2);
            REG.addClinica(cli);
            nombresClinicas.add(cli.getIdString());
            updateClinicasList();
            updateMainMenuClinicasList();
            clinicasEditVacunas.setVisible(false);
            newID.clear();
            vac1.clear();
            vac2.clear();
            vac3.clear();
            vac4.clear();
            vac5.clear();
            vac6.clear();
            vac7.clear();
            vac8.clear();
            vac9.clear();
            vac10.clear();
            vac11.clear();
            vac12.clear();
            vac13.clear();
            vac14.clear();
            vac15.clear();
            vac16.clear();
            vac17.clear();
            vac18.clear();
            vac19.clear();
            vac20.clear();
            vac21.clear();
            vac22.clear();
            vac23.clear();
            vac24.clear();
            vac25.clear();
            vac26.clear();
            vac27.clear();
            vac28.clear();
            vac29.clear();
            vac30.clear();
            vac31.clear();
        }
        catch(Exception e){
            alert.setTitle("Warning");
            alert.setHeaderText("Datos Inválidos");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    protected void handleClinicasEditVacunasCancelButton(ActionEvent event) {
        try{
            clinicasEditVacunas.setVisible(false);
            newID.clear();
            vac1.clear();
            vac2.clear();
            vac3.clear();
            vac4.clear();
            vac5.clear();
            vac6.clear();
            vac7.clear();
            vac8.clear();
            vac9.clear();
            vac10.clear();
            vac11.clear();
            vac12.clear();
            vac13.clear();
            vac14.clear();
            vac15.clear();
            vac16.clear();
            vac17.clear();
            vac18.clear();
            vac19.clear();
            vac20.clear();
            vac21.clear();
            vac22.clear();
            vac23.clear();
            vac24.clear();
            vac25.clear();
            vac26.clear();
            vac27.clear();
            vac28.clear();
            vac29.clear();
            vac30.clear();
            vac31.clear();
        }
        catch(Exception e){
            alert.setTitle("Warning");
            alert.setHeaderText("Datos Inválidos");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    protected void handleClinicasEditVacunasUpdateButton(ActionEvent event) {
        try{
            if (!clinicasList.getSelectionModel().isEmpty()){
                if (!vac1.getText().matches("[0-9]+") || !vac2.getText().matches("[0-9]+") || !vac3.getText().matches("[0-9]+") || !vac4.getText().matches("[0-9]+") || !vac5.getText().matches("[0-9]+") || !vac6.getText().matches("[0-9]+") || !vac7.getText().matches("[0-9]+") || !vac8.getText().matches("[0-9]+") || !vac9.getText().matches("[0-9]+") || !vac10.getText().matches("[0-9]+") || !vac11.getText().matches("[0-9]+") || !vac12.getText().matches("[0-9]+") || !vac13.getText().matches("[0-9]+") || !vac14.getText().matches("[0-9]+") || !vac15.getText().matches("[0-9]+") || !vac16.getText().matches("[0-9]+") || !vac17.getText().matches("[0-9]+") || !vac18.getText().matches("[0-9]+") || !vac19.getText().matches("[0-9]+") || !vac20.getText().matches("[0-9]+") || !vac21.getText().matches("[0-9]+") || !vac22.getText().matches("[0-9]+") || !vac23.getText().matches("[0-9]+") || !vac24.getText().matches("[0-9]+") || !vac25.getText().matches("[0-9]+") || !vac26.getText().matches("[0-9]+") || !vac27.getText().matches("[0-9]+") || !vac28.getText().matches("[0-9]+") || !vac29.getText().matches("[0-9]+") || !vac30.getText().matches("[0-9]+") || !vac31.getText().matches("[0-9]+") || !newID.getText().matches("[0-9]+") || newID.getText().length() > Infante.MAX_CEDULA_LENGTH) {
                    throw new myException(1);
                } 
                String ID = newID.getText();
                ArrayList<Integer> VACUNAS = new ArrayList<>();
                VACUNAS.add(Integer.parseInt(vac1.getText()));
                VACUNAS.add(Integer.parseInt(vac2.getText()));
                VACUNAS.add(Integer.parseInt(vac3.getText()));
                VACUNAS.add(Integer.parseInt(vac4.getText()));
                VACUNAS.add(Integer.parseInt(vac5.getText()));
                VACUNAS.add(Integer.parseInt(vac6.getText()));
                VACUNAS.add(Integer.parseInt(vac7.getText()));
                VACUNAS.add(Integer.parseInt(vac8.getText()));
                VACUNAS.add(Integer.parseInt(vac9.getText()));
                VACUNAS.add(Integer.parseInt(vac10.getText()));
                VACUNAS.add(Integer.parseInt(vac11.getText()));
                VACUNAS.add(Integer.parseInt(vac12.getText()));
                VACUNAS.add(Integer.parseInt(vac13.getText()));
                VACUNAS.add(Integer.parseInt(vac14.getText()));
                VACUNAS.add(Integer.parseInt(vac15.getText()));
                VACUNAS.add(Integer.parseInt(vac16.getText()));
                VACUNAS.add(Integer.parseInt(vac17.getText()));
                VACUNAS.add(Integer.parseInt(vac18.getText()));
                VACUNAS.add(Integer.parseInt(vac19.getText()));
                VACUNAS.add(Integer.parseInt(vac20.getText()));
                VACUNAS.add(Integer.parseInt(vac21.getText()));
                VACUNAS.add(Integer.parseInt(vac22.getText()));
                VACUNAS.add(Integer.parseInt(vac23.getText()));
                VACUNAS.add(Integer.parseInt(vac24.getText()));
                VACUNAS.add(Integer.parseInt(vac25.getText()));
                VACUNAS.add(Integer.parseInt(vac26.getText()));
                VACUNAS.add(Integer.parseInt(vac27.getText()));
                VACUNAS.add(Integer.parseInt(vac28.getText()));
                VACUNAS.add(Integer.parseInt(vac29.getText()));
                VACUNAS.add(Integer.parseInt(vac30.getText()));
                VACUNAS.add(Integer.parseInt(vac31.getText()));
                Clinica cli = new Clinica(ID, VACUNAS, new ArrayList<>());
                if(REG.getClinicaAt(clinicasList.getSelectionModel().getSelectedIndex()).getVacunasTotal() > REG.getClinicaAt(clinicasList.getSelectionModel().getSelectedIndex()).getTamanoMuestra()){
                    throw new myException(2);
                }
                REG.setClinica(cli, clinicasList.getSelectionModel().getSelectedIndex());
                nombresClinicas.set(clinicasList.getSelectionModel().getSelectedIndex(), cli.getIdString());
                clinicasEditVacunas.setVisible(false);
                updateClinicasList();
                updateMainMenuClinicasList();
            }
        }
        catch(Exception e){
            alert.setTitle("Warning");
            alert.setHeaderText("Datos Inválidos");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    protected void handleClinicasAddButton(ActionEvent event) {
        try{
            if (!clinicasInfantesOptions.getSelectionModel().isEmpty() && !clinicasList.getSelectionModel().isEmpty()) {
            if (REG.InfanteExistsInClinicas(REG.getInfantesRegion().get(clinicasInfantesOptions.getSelectionModel().getSelectedIndex()))) 
                throw new myException(3);
                REG.addInfanteAtClinica(REG.getInfantesRegion().get(clinicasInfantesOptions.getSelectionModel().getSelectedIndex()), clinicasList.getSelectionModel().getSelectedIndex());
                if(REG.getClinicaAt(clinicasList.getSelectionModel().getSelectedIndex()).getVacunasTotal() != REG.getClinicaAt(clinicasList.getSelectionModel().getSelectedIndex()).getTamanoMuestra()){
                    alert.setTitle("Warning");
                    alert.setHeaderText("Advertencia");
                    alert.setContentText("El numero de vacunas y el tamaño de la muestra no son iguales. Por favor, corrija esto.");
                    alert.showAndWait();
                }
                updateClinicasInfantesList();
            }
        }
        catch(Exception e){
            alert.setTitle("Warning");
            alert.setHeaderText("Datos Inválidos");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    protected void handleClinicasRemoveButton(ActionEvent event) {
        try{
            if (!clinicasInfantesOptions.getSelectionModel().isEmpty() && !clinicasList.getSelectionModel().isEmpty()) {
                REG.removeInfanteAtClinica(clinicasList.getSelectionModel().getSelectedIndex(), clinicasInfantesList.getSelectionModel().getSelectedIndex());
                if(REG.getClinicaAt(clinicasList.getSelectionModel().getSelectedIndex()).getVacunasTotal() != REG.getClinicaAt(clinicasList.getSelectionModel().getSelectedIndex()).getTamanoMuestra()){
                    alert.setTitle("Warning");
                    alert.setHeaderText("Advertencia");
                    alert.setContentText("El numero de vacunas y el tamaño de la muestra no son iguales. Por favor, corrija esto.");
                    alert.showAndWait();
                }
                updateClinicasInfantesList();
            }
        }
        catch(Exception e){
            alert.setTitle("Warning");
            alert.setHeaderText("Datos Inválidos");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    protected void handleMainMenuMayorVacunasButton(ActionEvent event) {
        try{
            if (REG.getClinicas().isEmpty()) {
                mainMenuMessages.setText("No existen clínicas");
            } else {
                String message = "Clínica(s) con mayor vacunación:\n";
                for (Clinica cli : REG.clinicasMasVacunas()) {
                    message += cli.getIdString() + "\n";
                }
                mainMenuMessages.setText(message);
            }
            manager.writeMayorVacunacion(REG.clinicasMasVacunas());
        }
        catch(Exception e){
            alert.setTitle("Warning");
            alert.setHeaderText("Datos Inválidos");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    protected void handleMainMenuInfanteSeleccionadoButton(ActionEvent event) {
        try{
            mainMenuInfanteAsk.setVisible(true);
        }
        catch(Exception e){
            alert.setTitle("Warning");
            alert.setHeaderText("Datos Inválidos");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    protected void handleMainMenuComprobarButton(ActionEvent event) {
        try{
            String message = "El infante ha sido seleccionado:\n";
            if (REG.seleccionadoParaMuestra(mainMenuNombreInfante.getText())) {
                message += "SI";
            } else {
                message += "NO";
            }
            manager.writeSeleccionado(mainMenuNombreInfante.getText(), REG.seleccionadoParaMuestra(mainMenuNombreInfante.getText()));
            mainMenuMessages.setText(message);
            mainMenuInfanteAsk.setVisible(false);
        }
        catch(Exception e){
            alert.setTitle("Warning");
            alert.setHeaderText("Datos Inválidos");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    protected void handleMainMenuEdadPromedioButton(ActionEvent event) {
        try{
            if (mainMenuClinicasList.getSelectionModel().isEmpty()) {
                alert.setTitle("Warning");
                alert.setHeaderText("No existe selección");
                alert.setContentText("Por favor seleccione una clínica");
                alert.showAndWait();
            } else {
                String message = "La edad promedio de la clinica " + REG.getClinicas().get(mainMenuClinicasList.getSelectionModel().getSelectedIndex()).getIdString() + " es:\n";
                message += Double.toString(REG.edadPromedioEnClinica(REG.getClinicas().get(mainMenuClinicasList.getSelectionModel().getSelectedIndex()).getId()));
                mainMenuMessages.setText(message);
                manager.writeEdadPromedio(REG.edadPromedioEnClinica(REG.getClinicas().get(mainMenuClinicasList.getSelectionModel().getSelectedIndex()).getId()), REG.getClinicas().get(mainMenuClinicasList.getSelectionModel().getSelectedIndex()).getId());
            }
        }
        catch(Exception e){
            alert.setTitle("Warning");
            alert.setHeaderText("Datos Inválidos");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    protected void handleMainMenuIncumplieronVacunasButton(ActionEvent event) {
        try{
            String message = "Clínicas que incumplieron el programa de vacuncación:\n";
            for (Clinica cli : REG.incumplieronVacunacion()) 
                message += cli.getIdString() + "\n";
            mainMenuMessages.setText(message);
            manager.writeIncumplimiento(REG.incumplieronVacunacion());
        }
        catch(Exception e){
            alert.setTitle("Warning");
            alert.setHeaderText("Datos Inválidos");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    protected void handleMainMenuRemoveButton(ActionEvent event) {       //Falta el update
        try{
            REG.removeClinica(mainMenuClinicasList.getSelectionModel().getSelectedIndex());
            updateMainMenuClinicasList();
        }
        catch(Exception e){
            alert.setTitle("Warning");
            alert.setHeaderText("Datos Inválidos");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
    
    @FXML
    protected void handleDatosAlmacenadosInfantesregionalesButton(ActionEvent event) {
        try{
            String message = "Infantes de la región:\n\n";
            message += manager.readInfantes();
            datosAlmacenadosTxtArea.setText(message);
        }
        catch(Exception e){
            alert.setTitle("Warning");
            alert.setHeaderText("Datos Inválidos");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
    
    @FXML
    protected void handleDatosAlmacenadosSeleccionButton(ActionEvent event) {
        try{
            String message = "Selección de infantes:\n\n";
            message += manager.readSeleccionado();
            datosAlmacenadosTxtArea.setText(message);
        }
        catch(Exception e){
            alert.setTitle("Warning");
            alert.setHeaderText("Datos Inválidos");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
    
    @FXML
    protected void handleDatosAlmacenadosEdadesPromedioButton(ActionEvent event) {
        try{
            String message = "Edades promedio almacenadas:\n\n";
            message += manager.readEdadPromedio();
            datosAlmacenadosTxtArea.setText(message);
        }
        catch(Exception e){
            alert.setTitle("Warning");
            alert.setHeaderText("Datos Inválidos");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
    
    @FXML
    protected void handleDatosAlmacenadosMayoresVacunacionesButton(ActionEvent event) {
        try{
            String message = "Mayores vacunaciones:\n\n";
            message += manager.readMayorVacunacion();
            datosAlmacenadosTxtArea.setText(message);
        }
        catch(Exception e){
            alert.setTitle("Warning");
            alert.setHeaderText("Datos Inválidos");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
    
    @FXML
    protected void handleDatosAlmacenadosIncumplimientosButton(ActionEvent event) {
        try{
            String message = "Incumplimientos de vacunación:\n\n";
            message += manager.readIncumplimiento();
            datosAlmacenadosTxtArea.setText(message);
        }
        catch(Exception e){
            alert.setTitle("Warning");
            alert.setHeaderText("Datos Inválidos");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    private void updateInfantesList() {
        try {
            nombresInfantes = FXCollections.observableArrayList();
            cedulasInfantes = FXCollections.observableArrayList();
            for (int i = 0; i < REG.getInfantesRegion().size(); i++) {
                nombresInfantes.add(REG.getInfantesRegion().get(i).getNombre());
                cedulasInfantes.add(REG.getInfantesRegion().get(i).getCedulaString());
            }
            if (infantesToggleValue) {
                if (nombresInfantes.isEmpty()) {
                    infantesList.getItems().clear();
                    clinicasInfantesOptions.getItems().clear();
                } else {
                    infantesList.setItems(nombresInfantes);
                    clinicasInfantesOptions.setItems(nombresInfantes);
                }
            } else {
                if (cedulasInfantes.isEmpty()) {
                    infantesList.getItems().clear();
                    clinicasInfantesOptions.getItems().clear();
                } else {
                    infantesList.setItems(cedulasInfantes);
                    clinicasInfantesOptions.setItems(cedulasInfantes);
                }
            }
            manager.setFileName("infantes.data");
            try {
                manager.writeInfantes(REG.getInfantesRegion());
            } catch (IOException ex) {
                Logger.getLogger(VacunasFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VacunasFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void updateClinicasList() {
        nombresClinicas = FXCollections.observableArrayList();
        String id;
        for (int i = 0; i < REG.getClinicas().size(); i++) {
            id = "";
            for (int j = 0; j < REG.getClinicas().get(i).getId().size(); j++) {
                id += Integer.toString(REG.getClinicas().get(i).getId().get(j));
            }
            nombresClinicas.add(id);
        }
        if (nombresClinicas.isEmpty()) {
            clinicasList.getItems().clear();
        } else {
            clinicasList.setItems(nombresClinicas);
        }
    }

    private void updateClinicasInfantesList() {
        nombresInfantesDeClinicas = FXCollections.observableArrayList();
        for (Clinica muestra : REG.getClinicas()) {
            ObservableList<String> nombres = FXCollections.observableArrayList();
            for (Infante inf : muestra.getMuestra()) {
                nombres.add(inf.getNombre());
            }
            nombresInfantesDeClinicas.add(nombres);
        }
        if (!nombresInfantesDeClinicas.get(clinicasList.getSelectionModel().getSelectedIndex()).isEmpty()) {
            clinicasInfantesList.setItems(nombresInfantesDeClinicas.get(clinicasList.getSelectionModel().getSelectedIndex()));
        } else {
            clinicasInfantesList.getItems().clear();
        }
    }

    private void updateMainMenuClinicasList() {
        updateClinicasList();
        if (nombresClinicas.isEmpty()) {
            mainMenuClinicasList.getItems().clear();
        } else {
            mainMenuClinicasList.setItems(nombresClinicas);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        infantesList.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if(infantesList.getSelectionModel().isEmpty()){
                infantesNombre.setText("");
                infantesCedula.setText("");
                infantesEdad.setText("");
            } else{
            infantesNombre.setText(REG.getInfantesRegion().get(infantesList.getSelectionModel().getSelectedIndex()).getNombre());
            infantesCedula.setText(cedulasInfantes.get(infantesList.getSelectionModel().getSelectedIndex()));
            infantesEdad.setText(Integer.toString(REG.getInfantesRegion().get(infantesList.getSelectionModel().getSelectedIndex()).getEdad()));
            }
        });
        clinicasList.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if(clinicasList.getSelectionModel().isEmpty()){
                clinicasID.setText("");
            }
            else
                clinicasID.setText(REG.getClinicas().get(clinicasList.getSelectionModel().getSelectedIndex()).getIdString());
            updateClinicasInfantesList();
        });
        REG.setInfantesRegion(manager.initializeInfantes());
        updateInfantesList();
    }

}
