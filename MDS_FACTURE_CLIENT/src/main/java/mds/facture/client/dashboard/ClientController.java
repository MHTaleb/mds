/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mds.facture.client.dashboard;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author taleb
 */
public class ClientController implements Initializable {

    @FXML
    private TableView<?> tableClients;
    @FXML
    private TableColumn<?, ?> colmnReference;
    @FXML
    private TableColumn<?, ?> columnTitre;
    @FXML
    private TableColumn<?, ?> ColumnEmail;
    @FXML
    private TableColumn<?, ?> columnTelephone;
    @FXML
    private TableColumn<?, ?> columnComptes;
    @FXML
    private JFXTextField searchText;
    @FXML
    private TableColumn<?, ?> columnNom;
    @FXML
    private TableColumn<?, ?> columnPrenom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void doSearch(KeyEvent event) {
    }

    @FXML
    private void showAdd(ActionEvent event) {
    }

    @FXML
    private void showEdit(ActionEvent event) {
    }

    @FXML
    private void delete(ActionEvent event) {
    }

    @FXML
    private void showFullDetail(MouseEvent event) {
    }
    
}
