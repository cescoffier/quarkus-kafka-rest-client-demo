package org.acme.model;

import io.quarkus.kafka.client.serialization.JsonbDeserializer;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class TransactionDeserializer extends JsonbDeserializer<Transaction> {

    public TransactionDeserializer() {
        super(Transaction.class);
    }
}
