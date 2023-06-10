package net.froihofer.dsfinancejaxrs.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;
public class BankClientRest {

    public BankClientRest() {
        try {
            Client client = ClientBuilder.newClient().register(new JaxRsAuthenticator("Balou", "1234")).register(JacksonJsonProvider.class);
            WebTarget baseTarget = client.target("http://localhost:8080/ds-finance-bank-web/rs/ds-finance/trading/stock/AAPL/history");

//            System.out.println(baseTarget.request().get().readEntity(String.class));
//            List<StockJson> ret = (List<StockJson>) baseTarget.request().get().readEntity(StockJson.class);
            List<StockJson> response = baseTarget.request().get(new GenericType<List<StockJson>>() {
            });

            for (StockJson i : response) {
                System.out.println("Stock: " + i.getCompanyName() + ", Last trading price: " + i.getLastTradePrice() +
                        ", Last trading time: " + i.getLastTradeTime() +
                        ", Last market capitalization: " + i.getMarketCapitalization());
            }

        } catch (Exception e) {
            System.out.println("Something went wrong.");
            e.printStackTrace();
        }
    }
}
