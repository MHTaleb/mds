package demo;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.catalina.filters.RequestDumperFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.DiscoveryClient.DiscoveryClientOptionalArgs;
import com.netflix.discovery.shared.transport.jersey.EurekaJerseyClientImpl.EurekaJerseyClientBuilder;


@SpringBootApplication
@EnableResourceServer
@EnableEurekaClient
@RestController
public class ResourceApplication extends ResourceServerConfigurerAdapter {
	
	/*
	@Bean
	public DiscoveryClient.DiscoveryClientOptionalArgs discoveryClientOptionalArgs() {

		DiscoveryClientOptionalArgs args = new DiscoveryClientOptionalArgs();
		System.setProperty("javax.net.ssl.keyStore", "src/main/resources/ressource.jks");
		System.setProperty("javax.net.ssl.keyStorePassword", "mds-group");
		System.setProperty("javax.net.ssl.trustStore","src/main/resources/ressource.jks");
	    System.setProperty("javax.net.ssl.trustStorePassword", "mds-group");

		EurekaJerseyClientBuilder builder = new EurekaJerseyClientBuilder();
		builder.withClientName("ressource");
		builder.withSystemSSLConfiguration();
		builder.withMaxTotalConnections(10);
		builder.withMaxConnectionsPerHost(10);
		args.setEurekaJerseyClient(builder.build());

		return args;
	}
	*/
	
    final List<Message> messages = Collections.synchronizedList(new LinkedList<>());
   
    @GetMapping(path = "api/messages")
    List<Message> getMessages(Principal principal) {
        return messages;
    }

    @PostMapping(path = "api/messages")
    Message postMessage(Principal principal, @RequestBody Message message) {
        message.username = principal.getName();
        message.createdAt = LocalDateTime.now();
        messages.add(0, message);
        return message;
    }

    public static class Message {
        public String text;
        public String username;
        public LocalDateTime createdAt;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/**").access("#oauth2.hasScope('read')")
                .antMatchers(HttpMethod.POST, "/api/**").access("#oauth2.hasScope('write')");
    }

    public static void main(String[] args) {
        SpringApplication.run(ResourceApplication.class, args);
    }

    @Profile("!cloud")
    @Bean
    RequestDumperFilter requestDumperFilter() {
        return new RequestDumperFilter();
    }
}
