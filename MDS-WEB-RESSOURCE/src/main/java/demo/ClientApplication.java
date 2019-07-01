package demo;

import org.apache.catalina.filters.RequestDumperFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@SpringBootApplication
@EnableOAuth2Sso
@EnableEurekaClient
public class ClientApplication extends WebSecurityConfigurerAdapter{


	
	

	
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }
    
	
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .logout()
                    .logoutSuccessUrl("http://localhost:9999/uaa/exit");
            http.authorizeRequests().antMatchers("graphics/**").permitAll().
                    and().authorizeRequests().anyRequest().permitAll();
        }
    
    @Profile("!cloud")
    @Bean
    RequestDumperFilter requestDumperFilter() {
        return new RequestDumperFilter();
    }

}
