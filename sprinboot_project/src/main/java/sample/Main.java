package sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@EnableAutoConfiguration
public class Main {

    @RequestMapping("/hi")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
    }
}