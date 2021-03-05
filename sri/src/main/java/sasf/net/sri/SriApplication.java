package sasf.net.sri;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class SriApplication implements CommandLineRunner {
	
	public static Logger Log = LoggerFactory.getLogger(SriApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SriApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//Log.info("Log de prueba");
	}

}
