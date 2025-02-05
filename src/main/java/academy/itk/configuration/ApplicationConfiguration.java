package academy.itk.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ApplicationConfiguration {

    private static final String[] PUBLIC_GET = {
            "/api/v1/author",
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers(HttpMethod.GET, PUBLIC_GET).permitAll()
                                .anyRequest().authenticated()).build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        final var userDetailsManager = new InMemoryUserDetailsManager();

        return userDetailsManager;
    }
}
