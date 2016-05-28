package de.mvitz.pact.consumer;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

public class Consumer {

    private final WebTarget target;

    public Consumer(WebTarget target) {
        this.target = target;
    }

    public String run() {
        return target.path("/").request(TEXT_PLAIN).get(String.class);
    }

    public static Consumer of(String uri) {
        return new Consumer(ClientBuilder.newClient().target(uri));
    }

    public static void main(String[] args) {
        final Consumer consumer = Consumer.of("http://localhost:8080");
        System.out.println(consumer.run());
    }
}
