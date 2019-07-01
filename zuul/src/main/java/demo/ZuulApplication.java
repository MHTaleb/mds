package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication

@EnableZuulProxy
@EnableEurekaClient
public class ZuulApplication {
/*
	@Bean
	public DiscoveryClient.DiscoveryClientOptionalArgs discoveryClientOptionalArgs() {

		DiscoveryClientOptionalArgs args = new DiscoveryClientOptionalArgs();
		System.setProperty("javax.net.ssl.keyStore", "src/main/resources/proxy.jks");
		System.setProperty("javax.net.ssl.keyStorePassword", "mds-group");
		// System.setProperty("javax.net.ssl.trustStore",
		// "src/main/resources/proxy.jks");
		// System.setProperty("javax.net.ssl.trustStorePassword", "mds-group");

		EurekaJerseyClientBuilder builder = new EurekaJerseyClientBuilder();
		builder.withClientName("proxy");
		builder.withSystemSSLConfiguration();
		builder.withMaxTotalConnections(10);
		builder.withMaxConnectionsPerHost(10);
		args.setEurekaJerseyClient(builder.build());

		return args;
	}

@Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) throws Exception {	
        String allPassword = "mds-group";

        SSLContext sslContext = SSLContextBuilder
                .create()
                .loadKeyMaterial(ResourceUtils.getFile("classpath:proxy.jks"), allPassword.toCharArray(), allPassword.toCharArray())
                .loadTrustMaterial(ResourceUtils.getFile("classpath:proxy.jks"), allPassword.toCharArray())
                .build();

        HttpClient client = HttpClients.custom()
                .setSSLContext(sslContext)
                .build();

        return builder
                .requestFactory(new HttpComponentsClientHttpRequestFactory(client))
                .build();
    }	*/
	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}
}
