package net.froihofer.dsfinance.bank.client;

import net.froihofer.util.AuthCallbackHandler;
import net.froihofer.util.JBoss7JndiLookupHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.ws.BindingProvider;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Properties;

public class BankClientNew {
    private static Logger log = LoggerFactory.getLogger(BankClient.class);

    public static void main(String[] args) {
            AuthCallbackHandler.setUsername("bic4a22_04");
    AuthCallbackHandler.setPassword("IoD6eic");
    Properties props = new Properties();
    props.put(Context.SECURITY_PRINCIPAL,AuthCallbackHandler.getUsername());
    props.put(Context.SECURITY_CREDENTIALS,AuthCallbackHandler.getPassword());

    /*
     try {
       JBoss7JndiLookupHelper jndiHelper = new JBoss7JndiLookupHelper(new InitialContext(props), "ds-finance-bank-ear", "ds-finance-bank-ejb", "");
        StockExchange exchange = jndiHelper.lookupUsingJBossEjbClient("StockService", StockExchange, , , , )

    } catch (NamingException e) {
        throw new RuntimeException(e);
    }
*/
        try {
            StockService stockService = getProxyForTradingService();

            List<String> searchResults = stockService.searchForStock("A");

            searchResults.forEach(x -> System.out.println(x));
        }

        private StockService getProxyForTradingService() {
            StockServiceService service = null;
            try {
                service = new StockServiceService(new URL(" "))
            } catch (MalformedURLException e) {
                return null;
            }
            StockService proxy = service.getStockServicePort();

            BindingProvider bindingProvider = (BindingProvider) proxy;
            bindingProvider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "bic4a22_04");
            bindingProvider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "IoD6eic");

            return proxy;

        }

    }

}
