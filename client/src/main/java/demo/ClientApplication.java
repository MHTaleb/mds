package demo;

import org.apache.catalina.filters.RequestDumperFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

import com.mds.shema.DemoApplication;



@SpringBootApplication
@EnableOAuth2Sso
@EnableOAuth2Client
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients(basePackageClasses= {DemoApplication.class})
@RibbonClients({
	@RibbonClient(name="COMPONENTS"),
	@RibbonClient(name="USERS-MANAGER"),
	@RibbonClient(name="CLIENT"),
	@RibbonClient(name="FACTURE")
})
@ComponentScan(basePackageClasses= {ClientApplication.class,DemoApplication.class})
public class ClientApplication extends WebSecurityConfigurerAdapter{


	
	

	
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }
    
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("http://localhost:9999/uaa/exit");
        http.authorizeRequests().antMatchers("graphics/**").permitAll().
                and().authorizeRequests().anyRequest().authenticated();
    }
        /*
        @Bean
        public RequestInterceptor requestTokenBearerInterceptor() {

            return new RequestInterceptor() {
                @Override
                public void apply(RequestTemplate requestTemplate) {
                    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                    OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
                    log.info("Bearer " + details.getTokenValue());
                    requestTemplate.header("Authorization", "Bearer " + details.getTokenValue());                   
                }
            };
        }
        
     
        
        @Bean
    @LoadBalanced
    OAuth2RestTemplate oauth2RestTemplate(OAuth2ClientContext oauth2ClientContext, OAuth2ProtectedResourceDetails details) {
        return new OAuth2RestTemplate(details, oauth2ClientContext);
    }
      
    @Bean
  @LoadBalanced
  RequestInterceptor oauthFeignClient(OAuth2ClientContext oauth2ClientContext, OAuth2ProtectedResourceDetails details) {
      return new OAuth2FeignRequestInterceptor(oauth2ClientContext, details);
  }
    */

  
    
    @Bean
    @LoadBalanced
    OAuth2RestTemplate oauth2RestTemplate(OAuth2ClientContext oauth2ClientContext, OAuth2ProtectedResourceDetails details) {
        return new OAuth2RestTemplate(details, oauth2ClientContext);
    }
    
        
    @Profile("!cloud")
    @Bean
    RequestDumperFilter requestDumperFilter() {
        return new RequestDumperFilter();
    }

}
