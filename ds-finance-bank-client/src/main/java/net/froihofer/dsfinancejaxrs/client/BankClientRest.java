package net.froihofer.dsfinancejaxrs.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

public class BankClientRest {

    public BankClientRest () {
        try {
            Client client = ClientBuilder.newClient().register(new JaxRsAuthenticator("Balou", "1234"));
            WebTarget baseTarget = client.target("http://localhost:8080/ds-finance-bank-web/rs/ds-finance/trading/stock/AMD/history");

            //WebTarget getTarget = baseTarget.path("{symbol}").path("quote").queryParam("symbol","AMD");
            System.out.println(baseTarget.request().get().readEntity(String.class));

            //WebTarget baseTarget = client.target("http://edu.dedisys.org/ds-finance/ws/rs/trading/stock/AMD/quote");
            // WebTarget postTarget = baseTarget.path("{symbol}").path("quote");

            //   http://edu.dedisys.org/ds-finance/ws/rs/trading/stock/AMD/quote
            //   System.out.println("Registering greeting from Alice...");


            // System.out.println(baseTarget.request().get().readEntity(String.class));
            // ObjectMapper mapper = new ObjectMapper();
            // System.out.println("Received response for GET request:");
            //System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response));
           /*
            System.out.println("\nChecking for greeting of Alice...");
            WebTarget getTarget = baseTarget.path("greeting").queryParam("from", "Alice");
            System.out.println(getTarget.request().get().readEntity(String.class));*/
        }
        catch (Exception e) {
            System.out.println("Something bad happened.");
            e.printStackTrace();
        }
    }
}
