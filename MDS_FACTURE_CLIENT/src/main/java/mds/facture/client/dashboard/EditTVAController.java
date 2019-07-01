/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mds.facture.client.dashboard;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author taleb
 */
public class EditTVAController implements Initializable {

    @FXML
    private JFXTextField txtTaux;
    @FXML
    private JFXRadioButton selectPrixAchat;
    @FXML
    private ToggleGroup a;
    @FXML
    private JFXRadioButton selectPrixVente;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void doValidate(ActionEvent event) {
    }

    @FXML
    private void rollback(ActionEvent event) {
    }
    
}
