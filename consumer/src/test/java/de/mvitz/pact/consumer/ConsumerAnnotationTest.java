package de.mvitz.pact.consumer;

import au.com.dius.pact.consumer.*;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class ConsumerAnnotationTest {

    @Rule
    public PactProviderRule mockProvider =
            new PactProviderRule("My Spring Boot Provider", this);


    @Pact(consumer = "My JAX-RS Consumer")
    public PactFragment createFragment(PactDslWithProvider builder) {
        return builder
                .uponReceiving("a root request").method("GET").path("/")
                .willRespondWith().status(200).body("Hello, world!")
                .toFragment();
    }

    @Test
    @PactVerification
    public void runTest() throws Exception {
        final Consumer consumer = Consumer.of(mockProvider.getConfig().url());
        assertEquals(consumer.run(), "Hello, world!");
    }
}
