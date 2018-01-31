package de.mvitz.pact.provider;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("/greet")
public class GreetController {

    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public GreetingResponse greet(@RequestBody GreetingRequest request) {
        // TODO
        // try out different values for greeting
        // they all match because the consumer only verifies it's type and not the exact value
        final String greeting = "Hello, " + request.name + "!";
        //final String greeting = "Hello dear, " + request.name + "!?!";
        return new GreetingResponse(greeting);
    }

    public static final class GreetingRequest {
        private final String name;

        @JsonCreator
        public GreetingRequest(@JsonProperty("name") String name) {
            this.name = name;
        }
    }

    // TODO
    // try to add a second field (e.g. foo) with some random value
    // the test still passes because we provide more than required which is fine
    private static final class GreetingResponse {
        private final String greeting;
        //private final String foo;

        private GreetingResponse(String greeting) {
            this.greeting = greeting;
            //this.foo = greeting;
        }

        public String getGreeting() {
            return greeting;
        }

        //public String getFoo() {
        //  return greeting;
        //}
    }
}
