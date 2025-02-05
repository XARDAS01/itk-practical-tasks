package academy.itk.configuration;

import academy.itk.configuration.properties.ApplicationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        ApplicationProperties.class
})
public class ApplicationConfiguration {
}
