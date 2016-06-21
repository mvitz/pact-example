package de.mvitz.pact.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@SpringBootApplication
@RestController
public class ServiceProvider {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProvider.class, args);
    }

    @RequestMapping(method = GET, value = "/", produces = TEXT_PLAIN_VALUE)
    public String index() {
        return "Hello, world!";
    }

}
