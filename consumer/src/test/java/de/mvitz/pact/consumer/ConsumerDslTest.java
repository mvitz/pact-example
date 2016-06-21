package de.mvitz.pact.consumer;

import au.com.dius.pact.consumer.*;
import au.com.dius.pact.model.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConsumerDslTest {

    @Test
    public void runTest() throws Exception {
        PactFragment fragment = ConsumerPactBuilder
                .consumer("My JAX-RS Consumer")
                .hasPactWith("My Spring Boot Provider")
                .uponReceiving("a root request")
                    .method("GET")
                    .path("/")
                .willRespondWith()
                    .status(200)
                    .body("Hello, world!")
                .toFragment();
        VerificationResult result = fragment.runConsumer(
                MockProviderConfig.createDefault(),
                (config) -> {
                    final Consumer consumer = Consumer.of(config.url());
                    assertEquals(consumer.run(), "Hello, world!");
                });
        assertEquals(ConsumerPactTest.PACT_VERIFIED, result);
    }
}
