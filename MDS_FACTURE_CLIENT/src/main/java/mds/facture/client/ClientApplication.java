package mds.facture.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ClientApplication extends Application {

    public static FXMLLoader fxmlLoader;
    ConfigurableApplicationContext applicationContext;

    public static void main(String[] args) {
        ClientApplication.launch(args);
    }

      
    static{
        System.setProperty("javax.net.ssl.trustStore", "c:/ssl/keystore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "notfound");
        System.setProperty("javax.net.ssl.keyStore", "c:/ssl/keystore.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "notfound");
    }

    	
    @Override
    public void start(Stage stage) throws Exception {
        //launching java fx app here
        applicationContext = SpringApplication.run(ClientApplication.class);
        Parent root;
        fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        
        try {

            HttpClient httpClient = HttpClients.custom()
                    .setDefaultCookieStore(new BasicCookieStore())
                    .build();
            Unirest.setHttpClient(httpClient);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Unirest.setObjectMapper(new ObjectMapper() {
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("MDS_Facture");
        stage.show();

    }

    @Override
    public void stop() throws Exception {

        applicationContext.close();
    }

}
