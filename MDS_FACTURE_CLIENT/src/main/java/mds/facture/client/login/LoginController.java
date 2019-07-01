/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mds.facture.client.login;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.shape.SVGPath;
import javafx.stage.Window;
import mds.facture.client.ClientApplication;
import mds.facture.client.Constants;
import mds.facture.client.crypto.Crypto;
import org.springframework.stereotype.Component;

/**
 * FXML Controller class
 *
 * @author taleb
 */
@Component
public class LoginController implements Initializable {

    @FXML
    private SVGPath logo;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void reset(ActionEvent event) {
    }

    @FXML
    private void doConnect(ActionEvent event) throws UnirestException, NoSuchAlgorithmException, IOException {

        if (validate()) {
            HttpResponse<String> asString;
            asString = Unirest.post("http://localhost:9999/uaa/oauth/token")
                    .header("content-type", "multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW")
                    .basicAuth("mds_group", "mds_group")
                    .header("cache-control", "no-cache")
                    .body("------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data;"
                            + "name=\"grant_type\"\r\n\r\npassword\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\n"
                            + "Content-Disposition: form-data; name=\"username\"\r\n\r\n"+username.getText()+"\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\n"
                            + "Content-Disposition: form-data; name=\"password\"\r\n\r\n"+Crypto.getSha(password.getText())+"\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\n"
                            + "Content-Disposition: form-data; name=\"client_id\"\r\n\r\nmds_group\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW--")
                    .asString();

            System.out.println("response : " + asString.getStatus());
            System.out.println("response : " + asString.getBody());
            System.out.println("response : " + asString.getHeaders().entrySet());
            
            if(asString.getStatus() == 200){
                String token = asString.getBody().split(",")[0].split(":")[1].replaceAll("\"", "");
                System.out.println("token is "+token);
                Unirest.setDefaultHeader("authorization", " Bearer "+token);
                Constants.USERNAME = username.getText();
                Window stage = ((Node)event.getSource()).getScene().getWindow();
                Parent root = ClientApplication.fxmlLoader.load(getClass().getResource("/fxml/dashboard.fxml"));
                stage.getScene().setRoot(root);
                stage.sizeToScene();
                stage.centerOnScreen();
//                
//                HttpResponse<String> responseRessourceServer = Unirest.get("http://localhost:9999/api/messages").asString();
//                System.out.println(responseRessourceServer.getBody());
                
            }
            

        }

    }

    private boolean validate() {
        return true;
    }

}
