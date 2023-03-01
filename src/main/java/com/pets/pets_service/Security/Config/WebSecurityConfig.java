package com.pets.pets_service.Security.Config;

import com.pets.pets_service.Service.ClientService;
import com.pets.pets_service.Service.VetService;
import com.pets.pets_service.Service.PPService;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final ClientService clientService;
    private final VetService vetService;
    private final PPService ppService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/v*/clients/**")
                .hasRole("CLIENT")
                .antMatchers("/api/v*/veterinaries/**")
                .hasRole("VET")
                .antMatchers("/api/v*/productProviders/**")
                .hasRole("PRODUCT_PROVIDER")
                .antMatchers("/api/v*/*registration/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().and()
                .logout()
                .logoutUrl("/api/v*/logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(clientDaoAuthenticationProvider());
        auth.authenticationProvider(vetDaoAuthenticationProvider());
        auth.authenticationProvider(ppDaoAuthenticationProvider());
}

    @Bean
     public DaoAuthenticationProvider ppDaoAuthenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(ppService);
        return provider;
}

    @Bean
    public DaoAuthenticationProvider clientDaoAuthenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(clientService);
        return provider;
    }

    @Bean
    public DaoAuthenticationProvider vetDaoAuthenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(vetService);
        return provider;
    }
}
