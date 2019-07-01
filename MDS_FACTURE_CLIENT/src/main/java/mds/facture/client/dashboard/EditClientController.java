/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mds.facture.client.dashboard;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author taleb
 */
public class EditClientController implements Initializable {

    @FXML
    private JFXTextField txtReference;
    @FXML
    private JFXCheckBox modeAuto;
    @FXML
    private JFXComboBox<?> choiceTypeClient;
    @FXML
    private JFXTextField txtNomEntreprise;
    @FXML
    private JFXTextField txtNumSiret;
    @FXML
    private JFXTextField txtNumTVA;
    @FXML
    private JFXTextField txtTitre;
    @FXML
    private JFXTextField txtNom;
    @FXML
    private JFXTextField txtPrenom;
    @FXML
    private JFXComboBox<?> choiceLangue;
    @FXML
    private JFXComboBox<?> choicePaiement;
    @FXML
    private JFXTextField txtNumCompte;
    @FXML
    private JFXListView<?> ListComptes;
    @FXML
    private JFXTextField txtNumTel;
    @FXML
    private JFXListView<?> listPhones;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXListView<?> listMails;
    @FXML
    private JFXTextField txtAdresse;
    @FXML
    private JFXTextField txtVille;
    @FXML
    private JFXTextField txtCodePostal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AddCompte(ActionEvent event) {
    }

    @FXML
    private void DelCompte(ActionEvent event) {
    }

    @FXML
    private void updateCompte(ActionEvent event) {
    }

    @FXML
    private void addPhone(ActionEvent event) {
    }

    @FXML
    private void delPhone(ActionEvent event) {
    }

    @FXML
    private void updatePhone(ActionEvent event) {
    }

    @FXML
    private void addMail(ActionEvent event) {
    }

    @FXML
    private void delMail(ActionEvent event) {
    }

    @FXML
    private void updateMail(ActionEvent event) {
    }

    @FXML
    private void comit(ActionEvent event) {
    }

    @FXML
    private void rollback(ActionEvent event) {
    }
    
}
