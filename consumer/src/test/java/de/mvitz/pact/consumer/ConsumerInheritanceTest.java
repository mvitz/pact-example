package de.mvitz.pact.consumer;

import au.com.dius.pact.consumer.ConsumerPactTestMk2;
import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ConsumerInheritanceTest extends ConsumerPactTestMk2 {

    @Override
    protected RequestResponsePact createPact(PactDslWithProvider builder) {
        return builder
                .uponReceiving("a root request").method("GET").path("/")
                .willRespondWith().status(200).body("Hello, world!")
                .toPact();
    }

    @Override
    protected String providerName() { return "My Spring Boot Provider"; }

    @Override
    protected String consumerName() { return "My JAX-RS Consumer"; }

    @Override
    protected void runTest(MockServer mockServer) throws IOException {
        final String url = mockServer.getUrl();
        final Consumer consumer = Consumer.of(url);
        assertEquals(consumer.run(), "Hello, world!");
    }
}
