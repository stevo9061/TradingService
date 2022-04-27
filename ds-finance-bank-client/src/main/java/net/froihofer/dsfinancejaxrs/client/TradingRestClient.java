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

        BankClientRest bankClientRest = new BankClientRest();

        try {

            Client client = ClientBuilder.newClient().register(new JaxRsAuthenticator("Balou", "1234"));

            WebTarget baseTarget = client.target("http://edu.dedisys.org/ds-finance/ws/rs/trading/stock");
            WebTarget getTarget = baseTarget.path("{symbol}").queryParam("symbol", "AAPL");

            WebTarget postTarget = baseTarget.path("{symbol}").path("sell");
            System.out.println("Registrating symbol from Share...");


            SellShare response = postTarget.resolveTemplate("symbol", "AAPL")
                    .request()
                    .post(Entity.json("1"), new GenericType<SellShare>() {});


            ObjectMapper mapper = new ObjectMapper();
            System.out.println("Received response for POST request:");
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response));
            System.out.println("\nChecking for share of my test... ");
  //          WebTarget getTarget = baseTarget.path("greeting").queryParam("symbol", "AAPL");
            System.out.println(getTarget.request().get().readEntity(String.class));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}

//2022-04-27 14:43:29.467 [main] WARN  o.a.c.j.i.ConfigurationImpl - Provider net.froihofer.dsfinancejaxrs.client.JaxRsAuthenticator does not implement specified contract: com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider
