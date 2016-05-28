package de.mvitz.pact.consumer;

import au.com.dius.pact.consumer.ConsumerPactBuilder;
import au.com.dius.pact.consumer.ConsumerPactTest;
import au.com.dius.pact.consumer.VerificationResult;
import au.com.dius.pact.model.MockProviderConfig;
import au.com.dius.pact.model.PactFragment;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ConsumerTest {

    @Test
    public void test() throws Exception {
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
        VerificationResult result = fragment.runConsumer(MockProviderConfig.createDefault(), (config) -> {
            final Consumer consumer = Consumer.of(config.url());
            assertThat(consumer.run(), is(equalTo("Hello, world!")));
        });
        assertEquals(ConsumerPactTest.PACT_VERIFIED, result);
    }
}
