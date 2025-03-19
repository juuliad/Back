package slam.itis.notedefrais;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NoteDeFraisApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoteDeFraisApplication.class, args);
	}

	@Bean
    public  ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
