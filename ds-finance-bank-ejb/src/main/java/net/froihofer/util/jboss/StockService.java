package net.froihofer.util.jboss;

import common.CustomerDTO;
import common.StockExchange;
import net.froihofer.dsfinance.ws.trading.*;
import net.froihofer.util.entity.KundeDAO;
import net.froihofer.util.entity.CustomerTranslator;
import net.froihofer.util.entity.Kunde;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.annotation.security.PermitAll;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.BindingProvider;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


@Stateless(name = "StockService") /* Stateless weil Zustandlos, es werden keinerlei Daten persistiert */
@PermitAll /* Jeder der sich am Jboss Server anmelden kann, darf auch auf dieses Service/Bean zugreifen */
@Remote
@WebService
public class StockService implements StockExchange {


    private static final Logger log = LoggerFactory.getLogger(StockService.class);

    @PersistenceContext
    private EntityManager entityManager;


    @Inject
    KundeDAO kundeDAO;

    @Inject
    CustomerTranslator customerTranslator;


    public List<String> searchForStock(String txt) {

        TradingWebService proxy = getProxyForTradingService();
        List<PublicStockQuote> searchResults;
        List<PublicStockQuote> symbolResults;

        try {
            searchResults = proxy.findStockQuotesByCompanyName(txt);

        } catch (TradingWSException_Exception e) {
            return new ArrayList<String>();
        }

        /* Schick die Anfrage an den Client zurück */
        return convertToClientStockQuote(searchResults);


    }


    /* Helper Methode die uns dieses TradingWebservice und den Proxy dazu erstellt. Username + Passwort wird
       uns auch mitgegeben */
    private TradingWebService getProxyForTradingService() {

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
        TradingWebService proxy = getProxyForTradingService();
        BigDecimal val = null;

        try {
            val = proxy.buy(symbol, shares);
        } catch (TradingWSException_Exception e) {
            return new BigDecimal(-1);
        }

        return val;
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {

    Kunde kunde = customerTranslator.toEntity(customerDTO);
    kundeDAO.persist(kunde);

        return customerTranslator.toDTO(kunde);
    }

    @Override
    public CustomerDTO findById(int id) {

        return customerTranslator.toDTO(kundeDAO.findById(id));
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
