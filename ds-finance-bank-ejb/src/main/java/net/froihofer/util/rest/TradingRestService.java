package net.froihofer.util.rest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/trading") // URI des Pfades
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TradingRestService {
    private static final Logger log = LoggerFactory.getLogger(TradingRestService.class);

    private static Map<String, String> toSell = new HashMap<>();

    /**
     * Stores the share and the amount from a sender and returns share and amount.
     */

    @POST @Path("stock/{symbol}/sell")
    public Response setSell(String amount, @PathParam("symbol") String share) {
        toSell.put(share, amount);
        return Response.ok(new SellShare(amount, share)).build();
    }


    /**
     * Returns the sold share of the specific input.
     */
    // Das Verzeichnis 'response' wurde selbst ausgewählt, mal schauen ob das funktioniert..
    @GET @Path("stock/response")
    @Produces("text/plain")
    public Response getSell(@QueryParam("symbol") String share) {
        if(toSell.containsKey(share)) {
            return Response.ok(share+" was successful sold \""+toSell.get(share)+"\"").build();
        }
        else {
            return Response.status(Response.Status.NOT_FOUND).entity("No share found from "+share+"?.?").build();
        }
    }





}
