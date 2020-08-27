package org.acme.demo;

import io.smallrye.mutiny.Uni;
import org.acme.model.Transaction;
import org.acme.model.TransactionResult;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RegisterRestClient(configKey = "transaction-service")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface TransactionService {

    @POST TransactionResult postSync(Transaction transaction);

    @POST Uni<TransactionResult> postAsync(Transaction transaction);

}
