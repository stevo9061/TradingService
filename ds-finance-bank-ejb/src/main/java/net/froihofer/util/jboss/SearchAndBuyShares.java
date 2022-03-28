package net.froihofer.util.jboss;

import net.froihofer.dsfinance.ws.trading.FindStockQuotesByCompanyName;
import net.froihofer.dsfinance.ws.trading.FindStockQuotesByCompanyNameResponse;
import net.froihofer.dsfinance.ws.trading.ObjectFactory;

import javax.ejb.Stateless;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

@Stateless
public class SearchAndBuyShares   {
    public static void main(String[] args) throws MalformedURLException {


  //  WildflyAuthDBHelper wildflyAuthDBHelper = new WildflyAuthDBHelper();

    final String endpoint = "http://edu.dedisys.org/ds-finance/ws/TradingService";

    final URL url = URI.create(endpoint).toURL();

    final FindStockQuotesByCompanyName serviceRequest = new FindStockQuotesByCompanyName();

    serviceRequest.setPartOfCompanyName("Apple");
    serviceRequest.getPartOfCompanyName();


    final FindStockQuotesByCompanyNameResponse serviceResponse = new FindStockQuotesByCompanyNameResponse();



    final ObjectFactory factory = new ObjectFactory();



   }
}
