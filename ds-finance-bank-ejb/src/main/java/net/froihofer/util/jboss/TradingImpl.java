package net.froihofer.util.jboss;

import net.froihofer.dsfinance.ws.trading.*;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;



@Stateless(name="StockService")
@PermitAll
//@WebService
@WebService(endpointInterface = "net.froihofer.dsfinance.ws.trading.TradingWebService",
serviceName = "TradingWebService", portName = "TradingWebServicePort")
public class TradingImpl implements TradingWebService  {

   // TradingWebServiceService tradingWebServiceService = new TradingWebServiceService(TradingWebServiceService.WSDL_LOCATION);

//      TradingWebServiceService.SERVICE = new QName("http://trading.ws.dsfinance.froihofer.net/", "TradingWebServiceService");

    TradingWebServiceService tradingWebServiceService = new TradingWebServiceService();




    @Override
    public BigDecimal buy(String symbol, int shares) throws TradingWSException_Exception {
        return null;
    }

    @Override
    public List<PublicStockQuote> findStockQuotesByCompanyName(String partOfCompanyName) throws TradingWSException_Exception {

        PublicStockQuote publicStockQuote = new PublicStockQuote();
        publicStockQuote.setCompanyName(partOfCompanyName);
        publicStockQuote.getSymbol();

        List<PublicStockQuote> listPublicStockQuote = new ArrayList<>();
        listPublicStockQuote.add(publicStockQuote);


    return listPublicStockQuote;
    }

    @Override
    public BigDecimal sell(String symbol, int shares) throws TradingWSException_Exception {
        return null;
    }

    @Override
    public List<PublicStockQuote> getStockQuotes(List<String> symbols) throws TradingWSException_Exception {
        return null;
    }

    @Override
    public List<PublicStockQuote> getStockQuoteHistory(String symbol) throws TradingWSException_Exception {
        return null;
    }



}
