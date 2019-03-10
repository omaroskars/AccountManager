package com.account.manager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceConfig extends ResourceServerConfigurerAdapter {
  private static final String RESOURCE_ID = "resource-server-rest-api";
  private static final String SECURED_READ_SCOPE = "#oauth2.hasScope('read')";
  private static final String SECURED_WRITE_SCOPE = "#oauth2.hasScope('write')";
  private static final String SECURED_PATTERN = "/secured/**";

  @Override
  public void configure(ResourceServerSecurityConfigurer resources) {
    resources.resourceId(RESOURCE_ID);
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    /*
     * http.requestMatchers()
     * .antMatchers(SECURED_PATTERN).and().authorizeRequests()
     * .antMatchers(HttpMethod.POST, SECURED_PATTERN).access(SECURED_WRITE_SCOPE)
     * .anyRequest().access(SECURED_READ_SCOPE);
     */
    // http.antMatcher("/**").authorizeRequests().antMatchers("/v2/api-docs",
    // "/configuration/**",
    // "/swagger-resources/**", "/swagger-ui.html", "/webjars/**",
    // "/api-docs/**").permitAll().anyRequest()
    // .authenticated();

    http.anonymous().and().authorizeRequests().antMatchers("/api").permitAll().antMatchers("/rest/**").authenticated();

  }
}