package net.froihofer.dsfinance.bank.client;

import net.froihofer.util.AuthCallbackHandler;
import net.froihofer.util.jboss.StockService;
import net.froihofer.util.jboss.StockServiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.naming.Context;
import javax.naming.NamingException;
import javax.xml.ws.BindingProvider;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;

public class BankClient {
    private static Logger log = LoggerFactory.getLogger(BankClient_LocalWebServiceCall.class);

    public static void main(String[] args) throws NamingException {

        /* Anmeldung vom Kunden am Pseudo Bank Portal, User wurde mit add-user Skript erzeugt */
        AuthCallbackHandler.setUsername("Balou");
        AuthCallbackHandler.setPassword("1234");
        Properties props = new Properties();
        props.put(Context.SECURITY_PRINCIPAL, AuthCallbackHandler.getUsername());
        props.put(Context.SECURITY_CREDENTIALS, AuthCallbackHandler.getPassword());

/*
        /// RMI Call \\\       JBoss7JndiLookupHelper jndiHelper = new JBoss7JndiLookupHelper(new InitialContext(props), "ds-finance-bank-ear", "ds-finance-bank-ejb", "");
       StockExchange exchange = jndiHelper.lookupUsingJBossEjbClient("StockService", StockExchange.class);
       List<String> searchResults = exchange.searchForStock("A");
       searchResults.forEach(x -> System.out.println(x));
*/

        /* Hier greifen wir über den Client auf das Stockservice zu in der zwei Methoden verfügbar sind,
        searchForStock(String txt) & BigDecimal buy(String symbol, int shares);
         */
        StockService stockService = getProxyForTradingService();
        List<String> searchResults = stockService.searchForStock("M");
        searchResults.forEach(x -> System.out.println(x));



    }

    /* Helper Methode für die Stockservices, den Proxy dazu erstellt und uns Username + Passwort mitgibt */
    private static StockService getProxyForTradingService() {

        StockServiceService service = null;

        try {
            service = new StockServiceService(new URL("http://localhost:8080/ds-finance-bank/ws/StockService?wsdl"));


            StockService proxy = service.getStockServicePort();

            BindingProvider bindingProvider = (BindingProvider) proxy;
            bindingProvider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "Balou");
            bindingProvider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "1234");

            return proxy;

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }


    }


}
