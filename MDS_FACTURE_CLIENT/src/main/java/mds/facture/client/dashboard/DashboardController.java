/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mds.facture.client.dashboard;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequestWithBody;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.shape.SVGPath;
import mds.facture.client.ClientApplication;
import mds.facture.client.Constants;

/**
 * FXML Controller class
 *
 * @author taleb
 */
public class DashboardController implements Initializable {

    @FXML
    private SVGPath Logo;
    @FXML
    private Label user;
    @FXML
    private PieChart chartStat;
    @FXML
    private VBox vboxSide;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        user.setText(Constants.USERNAME);
    }    

    @FXML
    private void disconnect(ActionEvent event) throws UnirestException, IOException {
        HttpRequestWithBody post = Unirest.post("http://localhost:9999/uaa/login?logout");
        final HttpResponse<String> asString = post.asString();
        final int status = asString.getStatus();
        System.out.println("status "+status);
        System.out.println("content "+asString.getBody());
        System.out.println("content "+asString.getHeaders().entrySet());
        if(status == 200){
            ((Node) event.getSource()).getScene().setRoot(ClientApplication.fxmlLoader.load(getClass().getResource("/fxml/Login.fxml")));
        }
    }

    @FXML
    private void showFactures(ActionEvent event) {
    }

    @FXML
    private void showArticles(ActionEvent event) {
    }

    @FXML
    private void showArchives(ActionEvent event) {
    }

    @FXML
    private void showClients(ActionEvent event) {
    }

    @FXML
    private void showAccounts(ActionEvent event) {
    }

    @FXML
    private void showDevise(ActionEvent event) {
    }

    @FXML
    private void showTVA(ActionEvent event) {
    }

    @FXML
    private void showStatistique(ActionEvent event) {
    }

    @FXML
    private void showParam(ActionEvent event) {
    }
    
}
