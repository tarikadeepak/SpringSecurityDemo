package com.dt.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	/*
	 * This method is to authenticate using google token
	 * It uses @EnableOAuth2Sso annotation. 
	 * 
	 */
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
		
		  http
		  .csrf().disable()
		  .authorizeRequests().antMatchers("/login").permitAll()
		  .anyRequest().authenticated();
	  }
	  
	/*
	 * This method was to test the spring security with the user detail
	 * authentication from user database
	 * 
	 */ 
//	  @Autowired
//	  private UserDetailsService userDetailsService;
//	  @Bean 
//	  public AuthenticationProvider authProvider() {
//		  DaoAuthenticationProvider provider = new DaoAuthenticationProvider(); 
//		  provider.setUserDetailsService(userDetailsService);
////		  provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//		  provider.setPasswordEncoder(new BCryptPasswordEncoder());
//		  return provider;
//	  }  
//	  @Override
//	  protected void configure(HttpSecurity http) throws Exception {
//		
//		  http
//		  .csrf().disable()
//		  .authorizeRequests().antMatchers("/login").permitAll()
//		  .anyRequest().authenticated()
//		  .and()
//		  .formLogin()
//		  .loginPage("/login").permitAll()
//		  .and()
//		  .logout().invalidateHttpSession(true)
//		  .clearAuthentication(true)
//		  .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//		  .logoutSuccessUrl("/logout-success").permitAll();
//	  }
	 
	
	/* This method was to test the spring security with the InMemory user detail service
	 * @Bean
	 * 
	 * @Override 
	 * protected UserDetailsService userDetailsService() {
	 * 		List<UserDetails> users = new ArrayList<>();
	 * 		users.add(User.withDefaultPasswordEncoder().username("Deepak").password("12345").roles("USER").build()); 
	 * 		return new InMemoryUserDetailsManager(users); 
	 * }
	 */
	 
	
	

}
