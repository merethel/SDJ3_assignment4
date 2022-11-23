package BusinessLogic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ComponentScan
@Configuration

public class Sdj3Assignment4Application {

    public static void main(String[] args) {
        SpringApplication.run(Sdj3Assignment4Application.class, args);
    }

}
