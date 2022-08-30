package net.froihofer.dsfinance.bank.client;

import net.froihofer.util.AuthCallbackHandler;
import net.froihofer.util.jboss.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.Context;
import javax.xml.ws.BindingProvider;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class BankClient {
    private static Logger log = LoggerFactory.getLogger(BankClient.class);

    public static void main(String[] args) {


/**
 * Login from customer to pseudo bank portal, user was created with attached add-user script.
 *
 * 1st step, start Wildfly server and successfully authenticate the customer with the same credentials.
 * 2nd step, start BankClient.
 *
 */
        AuthCallbackHandler.setUsername("Balou");
        AuthCallbackHandler.setPassword("1234");
        Properties props = new Properties();
        props.put(Context.SECURITY_PRINCIPAL, AuthCallbackHandler.getUsername());
        props.put(Context.SECURITY_CREDENTIALS, AuthCallbackHandler.getPassword());


/**
 * Here we access "Stockservice" with the client "Balou" in which specific methods are available,
 * searchForStock(), getProxyForTradingService(), buy(), createCustomer(), findById(), and convertToClientStockQuote().
 *
 * It is important to understand that the client is not allowed to access all methods available to the bank.
 * The client is only allowed to use the specific defined and allowed methods by the bank,
 * which are offered via the interface "StockService".
 *
 */

        StockService stockService = getProxyForTradingService();

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName("Stefan");
        customerDTO.setLastName("Bittgen");

        CustomerDTO result = stockService.createCustomer(customerDTO);

        System.out.println("Kundennummer: " + result.getId());
        System.out.println(result.getFirstName());

        System.out.println();
        System.out.println("###>>>> Client has connected to the Server successfully! <<<<###");


        System.out.println("Which Company/Symbol do you want to search for?");
        Scanner scanName = new Scanner(System.in);
        String companyName = scanName.nextLine();


        List<String> searchResult = stockService.searchForStock(companyName);


        searchResult.forEach(x -> System.out.println(x));

        System.out.println("Which stock do you want to buy, type in the symbol:");
        Scanner scanner = new Scanner(System.in);
        String symbol = scanner.nextLine();

        System.out.println("How many shares do you want to buy?");
        Scanner scanner2 = new Scanner(System.in);
        int symbolCtr = scanner2.nextInt();

        BigDecimal searchPrice = stockService.buy(symbol, symbolCtr);
        BigDecimal priceStocks = BigDecimal.ONE.add(searchPrice).multiply(new BigDecimal(symbolCtr));
        System.out.println("Congratulations! You have successfully bought " + symbolCtr + "x " + symbol + " Stocks from "
                + companyName + "" + " and you paid " + priceStocks + ".");
        System.out.println("The Price for one " + companyName + " Stock is " + searchPrice + ".");


    }

    /**
     * Helper method for "Stockservice" which creates TradingWebservice and proxy for us.
     * Username + password is also given to us.
     */
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
