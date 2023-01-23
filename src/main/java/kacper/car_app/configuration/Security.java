package kacper.car_app.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {

        @Autowired
        private UserAuthenticationDetails userAuthenticationDetails;
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws
                Exception {
            auth.userDetailsService(userAuthenticationDetails);
            auth.authenticationProvider(authenticationProvider());
        }
        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }
        @Bean
        public DaoAuthenticationProvider authenticationProvider() {
            DaoAuthenticationProvider authenticationProvider =
                    new DaoAuthenticationProvider();
            authenticationProvider.setUserDetailsService(userAuthenticationDetails);
            authenticationProvider.setPasswordEncoder(passwordEncoder());
            return  authenticationProvider;
        }



        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.httpBasic().disable().csrf().disable()
                    .authorizeRequests()
                    .antMatchers(
                            "/resources/static/**",
                            "/js/**",
                            "/css/**",
                            "/register",
                            "/business/**").permitAll()
                    .antMatchers("/client/**").denyAll()
                    .anyRequest().permitAll()
                    .and()
                    .formLogin()
                    .loginPage("/adminPanel/login")
                    .usernameParameter("login")
                    .usernameParameter("passwd")
                    .defaultSuccessUrl("/client/showClients", true)
                    .permitAll()
                    .and()
                    .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login")
                    .invalidateHttpSession(true);
    }
}
