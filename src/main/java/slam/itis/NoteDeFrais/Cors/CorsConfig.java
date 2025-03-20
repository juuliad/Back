package slam.itis.NoteDeFrais.Cors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Autorise toutes les routes
                        .allowedOrigins("http://localhost:4200") // Autoriser Angular à se connecter
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Méthodes autorisées
                        .allowedHeaders("*") // Autorise tous les en-têtes
                        .allowCredentials(true); // Permet l'envoi de cookies ou d'informations d'authentification
            }
        };
    }

}
