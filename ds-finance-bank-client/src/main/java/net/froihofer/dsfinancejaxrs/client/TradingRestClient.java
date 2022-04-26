package net.froihofer.dsfinancejaxrs.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class TradingRestClient {
    public static void main(String[] args) {

        /*try {
            Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
            WebTarget baseTarget = client.target("http://localhost:8080/ds-finance/ws/rs/trading/stock");
            WebTarget postTarget = baseTarget.path("{symbol}").path("sell");
            System.out.println("Registrating symbol from Share...");
            SellShare response = postTarget.resolveTemplates("sell", "AAPL")
                    .request((MediaType.APPLICATION_JSON_TYPE)
                    .post(Entity.json("This is just my Test!"), new GenericType<SellShare>() {});

            ObjectMapper mapper = new ObjectMapper();
            System.out.println("Received response for POST request:");
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response));
            System.out.println("\nChecking for share of my test... ");
            WebTarget getTarget = baseTarget.path("greeting").queryParam("sell", "AAPL");
            System.out.println(getTarget.request().get().readEntity(String.class));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }*/
    }

}
