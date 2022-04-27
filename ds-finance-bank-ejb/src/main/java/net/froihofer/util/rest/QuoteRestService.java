package net.froihofer.util.rest;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

@Path("/ds-finance")
@Produces("application/json")
@Consumes("application/json")
public class QuoteRestService {

    @GET
    @Path("/trading/stock/{symbol}/history")
    @Produces("application/json")
    public Response getHistory( @PathParam("symbol") String symbol) {
        Client client = ClientBuilder.newClient().register(new JaxRsAuthenticator("bic4a22_04", "IoD6eic"));
        System.out.println("HELLO Symbol = "+symbol);
        WebTarget baseTarget = client.target("http://edu.dedisys.org/ds-finance/ws/rs/trading/stock");
        // WebTarget getTarget = baseTarget.path(symbol).path("history"); // Link gen

        // @Path("/trading/stock/{symbol}/history-web") //http://edu.dedisys.org/ds-finance/ws/rs/trading/stock/AMD/quote


        WebTarget getTarget = baseTarget.path("{symbol}").path("history");

        Response response = getTarget.resolveTemplate("symbol",symbol).request().get();
        //System.out.println( getTarget.request().get().readEntity(String.class)); // Rest call
        return response;
    }
}