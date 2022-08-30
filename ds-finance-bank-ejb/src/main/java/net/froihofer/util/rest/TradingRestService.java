package net.froihofer.util.rest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

//@Path("/trading") // URI des Pfades
@Path("/ds-finance")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TradingRestService {
    private static final Logger log = LoggerFactory.getLogger(TradingRestService.class);

    private static Map<String, Integer> toSell = new HashMap<>();

    /**
     * Stores the share and the amount from a sender and returns share and amount.
     */

    @POST @Path("stock/{symbol}/sell")
    public Response setSell(int shares, @PathParam("symbol") String symbol) {
        Client client = ClientBuilder.newClient().register(new JaxRsAuthenticator("bic4a22_04", "IoD6eic"));
        System.out.println("HELLO Symbol = "+symbol);
        WebTarget baseTarget = client.target("http://edu.dedisys.org/ds-finance/ws/rs/trading/stock");


        toSell.put(symbol, shares);
        return Response.ok(new SellShare(shares, symbol)).build();
    }


    /**
     * Returns the sold share of the specific input.
     */
    // Das Verzeichnis 'response' wurde selbst ausgewählt, mal schauen ob das funktioniert..
    @GET @Path("/result")
    @Produces("text/plain")
    public Response getSell(@QueryParam("symbol") String symbol) {
        if(toSell.containsKey(symbol)) {
            return Response.ok(symbol+" was successful sold \""+toSell.get(symbol)+"\"").build();
        }
        else {
            return Response.status(Response.Status.NOT_FOUND).entity("No share found from "+symbol+"?.?").build();
        }
    }





}
