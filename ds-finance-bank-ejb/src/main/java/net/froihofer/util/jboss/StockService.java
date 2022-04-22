package net.froihofer.util.jboss;


import common.StockExchange;
import net.froihofer.dsfinance.ws.trading.*;


import javax.annotation.security.PermitAll;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.xml.ws.BindingProvider;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


@Stateless(name = "StockService") /*Stateless weil Zustandlos, es werden keinerlei Daten persistiert */
@PermitAll /* Jeder der sich am Jboss Server anmelden kann, darf auch auf dieses Service/Bean zugreifen */
@Remote
@WebService
public class StockService implements StockExchange {

    public List<String> searchForStock(String txt) {

        net.froihofer.dsfinance.ws.trading.TradingWebService proxy = getProxyForTradingService();
        List<net.froihofer.dsfinance.ws.trading.PublicStockQuote> searchResults;

        try {
            searchResults = proxy.findStockQuotesByCompanyName(txt);

/*            for(PublicStockQuote publicStockQuote: searchResults) {
                System.out.println("Company name: " + publicStockQuote.getCompanyName());
                System.out.println("Symbol (You need this to buy the stock): " + publicStockQuote.getSymbol());
                System.out.println("Trading Price: " + publicStockQuote.getLastTradePrice());
                System.out.println();
            }*/

        } catch (TradingWSException_Exception e) {
            return new ArrayList<String>();
        }

        /*Schicken dir Anfrage an den Client zurück */
        return convertToClientStockQuote(searchResults);


    }


    /* Helper Methode die uns dieses TradingWebservice, den Proxy dazu erstellt und uns Username + Passwort mitgibt */
    private net.froihofer.dsfinance.ws.trading.TradingWebService getProxyForTradingService() {

        TradingWebServiceService service = null;

        try {
            service = new TradingWebServiceService(new URL("http://edu.dedisys.org/ds-finance/ws/TradingService?wsdl"));


            TradingWebService proxy = service.getTradingWebServicePort();

            BindingProvider bindingProvider = (BindingProvider) proxy;
            bindingProvider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "bic4a22_04");
            bindingProvider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "IoD6eic");

        return proxy;

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


    public BigDecimal buy(String symbol, int shares) {
        net.froihofer.dsfinance.ws.trading.TradingWebService proxy = getProxyForTradingService();
        BigDecimal val = null;

        try {
            val = proxy.buy(symbol, shares);
        } catch (TradingWSException_Exception e) {
            return new BigDecimal(-1);
        }

        return val;
    }


    private List<String> convertToClientStockQuote(List<PublicStockQuote> stocks) {
        ArrayList<String> stockQuotes = new ArrayList<>();
        for(PublicStockQuote q : stocks) {
            StringBuilder builder = new StringBuilder();
            builder.append(q.getCompanyName());
            builder.append(";");
            builder.append(q.getFloatShares());
            builder.append(";");
            builder.append(q.getLastTradePrice());
            builder.append(";");
            builder.append(q.getLastTradeTime());
            builder.append(";");
            builder.append(q.getMarketCapitalization());
            builder.append(";");
            builder.append(q.getStockExchange());
            builder.append(";");
            builder.append(q.getSymbol());

            stockQuotes.add(builder.toString());
        }

        return stockQuotes;
    }




}
