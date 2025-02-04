package com.udemy.backendninja.crudcontacts.configuration;

import com.udemy.backendninja.crudcontacts.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("UserService")
    UserDetailsService userService;

    @Autowired
    public void ConfigureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/*", "/imgs/*").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage(Constant.URL_LOGIN).loginProcessingUrl(Constant.URL_LOGIN_VALIDATE)
                .usernameParameter("username").passwordParameter("password")
                .defaultSuccessUrl(Constant.URL_LOGIN_VALIDATE).permitAll()
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout")
                .permitAll();
    }
}
