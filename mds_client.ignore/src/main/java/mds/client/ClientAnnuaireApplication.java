package mds.client;


import org.apache.catalina.filters.RequestDumperFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * devise url ; http://www.apilayer.net/api/live?access_key=193cdc59fa67188494182f5839f7d6cb
 */

@SpringBootApplication
@EnableResourceServer
@EnableEurekaClient
public class ClientAnnuaireApplication  {
  

   

    public static void main(String[] args) {
        SpringApplication.run(ClientAnnuaireApplication.class, args);
        
    }

    @Profile("!cloud")
    @Bean
    RequestDumperFilter requestDumperFilter() {
        return new RequestDumperFilter();
    }
}
