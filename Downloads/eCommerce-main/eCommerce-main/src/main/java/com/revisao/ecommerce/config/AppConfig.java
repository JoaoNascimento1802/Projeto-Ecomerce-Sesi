package com.revisao.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        // Desabilita a proteção contra ataques CSRF (Cross-Site Request Forgery).
        http.csrf(csrf -> csrf.disable());
        // Define que todas as requisições HTTP (qualquer tipo de acesso) estão permitidas sem autenticação.
        // Isso significa que qualquer pessoa pode acessar qualquer parte da sua aplicação neste momento.
        http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
        // Constrói e retorna a cadeia de filtros de segurança com as configurações definidas.
        return http.build();
    }
}
