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
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author taleb
 */
public class TVAController implements Initializable {

    @FXML
    private StackPane stackPane;
    @FXML
    private TableView<?> tableTVA;
    @FXML
    private TableColumn<?, ?> columnTaux;
    @FXML
    private TableColumn<?, ?> columnNature;
    @FXML
    private JFXTextField searchText;

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
    private void showAddTVA(ActionEvent event) {
    }

    @FXML
    private void showEditTVA(ActionEvent event) {
    }

    @FXML
    private void doDeleteTVA(ActionEvent event) {
    }
    
}
