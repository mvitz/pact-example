package de.mvitz.pact.consumer;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JsonConsumerTest {

    @Rule
    public PactProviderRuleMk2 mockProvider = new PactProviderRuleMk2("JsonProvider", this);

    @Pact(consumer = "JsonConsumer")
    public RequestResponsePact createFragment(PactDslWithProvider builder) {
        return builder
            .uponReceiving("JSON request")
                .method("POST").path("/greet")
                    .headers("Content-Type", "application/json")
                    .body(new PactDslJsonBody()
                        .stringType("name", "Michael"))
                .willRespondWith()
                    .status(200)
                    .body(new PactDslJsonBody().stringType("greeting", "Hello, Michael!"))
            .toPact();
    }

    @Test
    @PactVerification
    public void verify() throws Exception {
        final JsonConsumer consumer = new JsonConsumer(mockProvider.getUrl());
        final String result = consumer.greet("Michael");
        assertEquals("{\"greeting\":\"Hello, Michael!\"}", result);
    }
}
