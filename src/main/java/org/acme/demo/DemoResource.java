package org.acme.demo;

import org.acme.model.Transaction;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/demo")
public class DemoResource {

    @Inject @Channel("to-kafka") Emitter<Transaction> emitter;

    @GET
    public Response newTransaction(@QueryParam("name") String name, @QueryParam("amount") int amount) {
        Transaction transaction = new Transaction();
        transaction.name = name;
        transaction.amount = amount;
        emitter.send(transaction);
        return Response.accepted().build();
    }
}
