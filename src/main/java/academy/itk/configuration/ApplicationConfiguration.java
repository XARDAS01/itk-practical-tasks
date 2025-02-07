package academy.itk.configuration;

import academy.itk.configuration.properties.JdbcProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        JdbcProperties.class
})
public class ApplicationConfiguration {
}
