package org.acme.transaction;

import org.acme.model.Transaction;
import org.acme.model.TransactionResult;
import org.jboss.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Random;

@Path("/transactions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TransactionResource {

    private final Random random = new Random();
    private static final Logger LOGGER = Logger.getLogger("TransactionResource");

    @POST
    public TransactionResult post(Transaction transaction) {
        LOGGER.info("Handling transaction " + transaction.name + " / " + transaction.amount);
        TransactionResult result = new TransactionResult();
        result.name = transaction.name;
        result.amount = transaction.amount;
        result.success = random.nextBoolean();
        return result;
    }

}
