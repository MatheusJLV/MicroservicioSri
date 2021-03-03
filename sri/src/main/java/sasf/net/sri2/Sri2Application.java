package sasf.net.sri2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class Sri2Application implements CommandLineRunner {
	
	public static Logger Log = LoggerFactory.getLogger(Sri2Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Sri2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//Log.info("Log de prueba");
	}

}
