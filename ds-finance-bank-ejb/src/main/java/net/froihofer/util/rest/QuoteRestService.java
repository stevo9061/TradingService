package net.froihofer.util.rest;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/ds-finance")
@Produces("application/json")
@Consumes("application/json")
public class QuoteRestService {

    @GET
    @Path("/trading/stock/{symbol}/history") //Schnittstelle zum Kunden
    @Produces("application/json")
    public List<StockJson> getHistory(@PathParam("symbol") String symbol) {
        Client client = ClientBuilder.newClient().register(new JaxRsAuthenticator("bic4a22_04", "IoD6eic"));
        WebTarget baseTarget = client.target("http://edu.dedisys.org/ds-finance/ws/rs/trading/stock"); //Schnittstelle zum Server

        WebTarget getTarget = baseTarget.path("{symbol}").path("history");

        List<StockJson> response = getTarget.resolveTemplate("symbol",symbol).request().get(new GenericType<List<StockJson>>() {});

        System.out.println( getTarget.resolveTemplate("symbol",symbol).request().get().readEntity(String.class)); // Rest call

        return response;
    }
}
