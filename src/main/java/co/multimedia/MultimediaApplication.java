package co.multimedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class MultimediaApplication {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(MultimediaApplication.class, args);

		Controller.uploadObject();
		Controller.getObject();

	}

}
