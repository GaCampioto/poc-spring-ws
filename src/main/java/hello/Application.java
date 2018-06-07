package hello;

import hello.wsdl.CelsiusToFahrenheitResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner lookup(TemperatureClient temperatureClient) {
        return args -> {
            String celsius = "20";
            if (args.length > 0) {
                celsius = args[0];
            }

            CelsiusToFahrenheitResponse response = temperatureClient.celsiusToFahrenheit(celsius);
            System.err.println(response.getCelsiusToFahrenheitResult());
        };
    }
}
