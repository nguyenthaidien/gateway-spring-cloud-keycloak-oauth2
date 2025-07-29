package com.amrut.prabhu.oauth2.client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.client.oidc.web.server.logout.OidcClientInitiatedServerLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.logout.ServerLogoutSuccessHandler;

import reactor.core.publisher.Mono;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

	@Bean
  public SecurityWebFilterChain filterChain(ServerHttpSecurity http,
                                            ServerLogoutSuccessHandler logoutHandler) {
//     http
//       .authorizeExchange(exchanges -> exchanges
//         .pathMatchers("/api/**").authenticated()
//         .anyExchange().permitAll()


//       );
//     return http.build();
//   }

//   @Bean
//   public ServerLogoutSuccessHandler logoutHandler() {
//     return (exchange, authentication) -> {
//       exchange.getExchange().getResponse().setStatusCode(HttpStatus.OK);
//       return Mono.empty();
//     };
//   }

	// @Bean
	// public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http, ServerLogoutSuccessHandler handler) {
	// 	http
	// 			.authorizeExchange()			
	// 				.pathMatcher("/actuator/**", "","/logout.html")
	// 				.permitAll()
	// 		.and()
	// 			.authorizeExchange()
	// 			.anyExchange()
	// 			.authenticated()
	// 		.and()
	// 			.oauth2Login() // to redirect to oauth2 login page.
	// 		.and()
	// 			.logout()
	// 			.logoutSuccessHandler(handler)		;
	// 	return http.build();
	// }
		http
			.authorizeExchange()
				//.pathMatchers("/api/**").authenticated()

				.anyExchange().permitAll()
			.and()
				.oauth2Login()
			.and()
				.logout()
				.logoutSuccessHandler(logoutHandler)
			.and()
				.csrf().disable(); // Disable CSRF for simplicity, adjust as needed

		return http.build();
	}

	@Bean
	public ServerLogoutSuccessHandler keycloakLogoutSuccessHandler(ReactiveClientRegistrationRepository repository) {

        OidcClientInitiatedServerLogoutSuccessHandler oidcLogoutSuccessHandler =
                new OidcClientInitiatedServerLogoutSuccessHandler(repository);

        oidcLogoutSuccessHandler.setPostLogoutRedirectUri("{baseUrl}/logout.html");

        return oidcLogoutSuccessHandler;
    }
    
}