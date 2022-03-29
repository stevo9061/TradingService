package stocks;

import net.froihofer.dsfinance.ws.trading.FindStockQuotesByCompanyName;
import net.froihofer.dsfinance.ws.trading.PublicStockQuote;
import net.froihofer.dsfinance.ws.trading.TradingWebService;
import net.froihofer.util.jboss.TradingImpl;
import net.froihofer.util.jboss.WildflyAuthDBHelper;

import javax.xml.ws.Endpoint;
import java.util.Collections;
import java.util.List;


public class StocksMain {
    public static void main(String[] args) {

        try {


           TradingImpl tradingImpl = new TradingImpl();
            String address = "http://localhost:8080/ds-finance-bank-web";
            Endpoint endpoint = Endpoint.publish(address, tradingImpl);
            System.out.println("Server started. Press any key to stop...");

        TradingImpl searchAndBuyShares = new TradingImpl();
        searchAndBuyShares.findStockQuotesByCompanyName("Apple");
       List<PublicStockQuote> reply = searchAndBuyShares.getStockQuotes(Collections.singletonList("AAPL"));

            System.out.println("Done");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        final FindStockQuotesByCompanyName serviceRequest = new FindStockQuotesByCompanyName();

        serviceRequest.setPartOfCompanyName("Apple");
        serviceRequest.getPartOfCompanyName();



    }



}
