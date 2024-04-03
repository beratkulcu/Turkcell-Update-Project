package comtrkcll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class TurkcellUpdateProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TurkcellUpdateProjectApplication.class, args);
	}

}
