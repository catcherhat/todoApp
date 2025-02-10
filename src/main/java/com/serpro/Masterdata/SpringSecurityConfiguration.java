package com.serpro.Masterdata;

import java.util.function.Function;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
public class SpringSecurityConfiguration {
	

	
	InMemoryUserDetailsManager sj = new InMemoryUserDetailsManager();
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		
		
		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
		UserDetails userDetails = User.builder().passwordEncoder(passwordEncoder).username("Administrator").password("11").roles("ADMIN","USER").build();
		return new InMemoryUserDetailsManager(userDetails);
	}
	


//	String username ="Rajalakshmi";
//	String password = "123";
//	@Bean
//	public UserDetails createuserdetailsmanager() {
//
//		Function<String,String> passwordEncoder = input -> passwordEncoder().encode(input);
//		UserDetails userDetails = User.builder().passwordEncoder(passwordEncoder).username("Rajalakshmi")
//				.password("123").roles("USER", "ADMIN").build();
//
//		return userDetails;
//	}
//	
//	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

//	@SuppressWarnings("deprecation")
//	@Bean
//	public static NoOpPasswordEncoder passwordEncoder() {
//	return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
		http.formLogin(withDefaults());
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
		return http.build();
		
	}


}
