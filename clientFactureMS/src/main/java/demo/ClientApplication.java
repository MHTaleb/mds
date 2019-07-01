package demo;

import org.apache.catalina.filters.RequestDumperFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mds.shema.DemoApplication;




/**
 * 
 * @Bean public RequestInterceptor requestTokenBearerInterceptor() {
 * 
 *       return new RequestInterceptor() {
 * @Override public void apply(RequestTemplate requestTemplate) { Authentication
 *           authentication =
 *           SecurityContextHolder.getContext().getAuthentication();
 *           OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)
 *           authentication.getDetails(); log.info("Bearer " +
 *           details.getTokenValue()); requestTemplate.header("Authorization",
 *           "Bearer " + details.getTokenValue()); } }; }
 * 
 * 
 * @Bean
 * @LoadBalanced RequestInterceptor oauthFeignClient(OAuth2ClientContext
 *               oauth2ClientContext, OAuth2ProtectedResourceDetails details) {
 *               return new OAuth2FeignRequestInterceptor(oauth2ClientContext,
 *               details); }
 * 
 * 
 * 
 */

@SpringBootApplication
@EnableOAuth2Sso
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients(basePackageClasses = { DemoApplication.class })
@RibbonClients({ @RibbonClient(name = "COMPONENTS"), @RibbonClient(name = "USERS-MANAGER") })
@ComponentScan(basePackageClasses = { ClientApplication.class, DemoApplication.class })
public class ClientApplication extends WebSecurityConfigurerAdapter {

	@Configuration
	static class MvcConfig extends WebMvcConfigurerAdapter {

		@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addViewController("/").setViewName("facturation");

		}
	}


	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.logout().logoutSuccessUrl("http://localhost:9999/uaa/exit");
		http.authorizeRequests().antMatchers("graphics/**").permitAll().and().authorizeRequests().anyRequest()
				.authenticated().and().csrf();
	}

	
	

	@Profile("!cloud")
	@Bean
	RequestDumperFilter requestDumperFilter() {
		return new RequestDumperFilter();
	}

}
