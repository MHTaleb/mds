/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mds.client;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 *
 * @author taleb
 */
@Configuration
public class SecurityConfiguration extends ResourceServerConfigurerAdapter {
     @Override
    public void configure(HttpSecurity http) throws Exception {
        final String securetPattern = "/facture/**";
        final String oauth2hasScopewrite = "#oauth2.hasScope('write')";
        final String oauth2hasScoperead = "#oauth2.hasScope('read')";
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, securetPattern).access(oauth2hasScoperead)
                .antMatchers(HttpMethod.PUT, securetPattern).access(oauth2hasScopewrite)
                .antMatchers(HttpMethod.DELETE, securetPattern).access(oauth2hasScopewrite)
                .antMatchers(HttpMethod.POST, securetPattern).access(oauth2hasScopewrite);
    }

}
