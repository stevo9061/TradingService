package net.froihofer.dsfinance.bank.client;




import net.froihofer.util.AuthCallbackHandler;
import net.froihofer.util.JBoss7JndiLookupHelper;
import net.froihofer.util.jboss.StockService;
import net.froihofer.util.jboss.StockServiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.ws.BindingProvider;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

/**
 * Main class for starting the bank client.
 *
 */

public class BankClient {
  private static Logger log = LoggerFactory.getLogger(BankClient.class);

  /*
  public static void main(String[] args) {


//    AuthCallbackHandler.setUsername("customer");
//    AuthCallbackHandler.setPassword("customerpass");
//    Properties props = new Properties();
//    props.put(Context.SECURITY_PRINCIPAL,AuthCallbackHandler.getUsername());
//    props.put(Context.SECURITY_CREDENTIALS,AuthCallbackHandler.getPassword());

    Properties props = new Properties();

    try {
      JBoss7JndiLookupHelper jndiHelper = new JBoss7JndiLookupHelper(new InitialContext(props), "ds-finance-bank-ear", "ds-finance-bank-ejb", "");
      //TODO: Implement the rest of the functionality


      StockServiceService tradingWebServiceService = new StockServiceService(new URL(
              "http://localhost:8080/ds-finance-bank/ws/StockService?wsdl"));

              StockService proxy = tradingWebServiceService.getStockServicePort();

      BindingProvider bindingProvider = (BindingProvider) proxy;

      bindingProvider.getRequestContext().put(
              BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
              "http://localhost:8080/ds-finance-bank/ws/StockService?wsdl");

              bindingProvider.getRequestContext().put(
                      BindingProvider.USERNAME_PROPERTY, "bic4a22_04");

      bindingProvider.getRequestContext().put(
              BindingProvider.PASSWORD_PROPERTY, "IoD6eic");
      System.out.println("");
      System.out.println("###>>>> Client has connected to the Server successfully! <<<<###");



      System.out.println("Which company do you want to search for?");
      Scanner scanName = new Scanner(System.in);
      String companyName = scanName.nextLine();


      List<PublicStockQuote> client = proxy.findStockQuotesByCompanyName(companyName);


      for(PublicStockQuote publicStockQuote: client) {
        System.out.println("Company name: " + publicStockQuote.getCompanyName());
        System.out.println("Symbol (You need this to buy the stock): " + publicStockQuote.getSymbol());
        System.out.println("Trading Price: " + publicStockQuote.getLastTradePrice());
        System.out.println();
      }


      System.out.println("Which stock do you want to buy, type in the symbol:");
      Scanner symbolName = new Scanner(System.in);
      String symbol = symbolName.nextLine();

      BigDecimal lastPriceStock = null;
      for(PublicStockQuote iterator : client) {
        if(iterator.getSymbol().equals(symbol)) {
          System.out.println();
          System.out.println("The trade price from this stock is: " + iterator.getLastTradePrice() + "€");
          System.out.println();
          lastPriceStock = iterator.getLastTradePrice();
        break;
        }
      }
//      System.out.println(client.get(0).getSymbol());

      System.out.println("How often are you going to buy the stock?");
      Scanner scannerStockCount = new Scanner(System.in);
      int stockCount = scannerStockCount.nextInt();
      proxy.buy(symbol, stockCount);

      System.out.println("You have successfully bought " + stockCount + "x shares of the stock at a price of " + lastPriceStock + "€");




    }
    catch (NamingException | MalformedURLException | TradingWSException_Exception e) {
      log.error("Failed to initialize InitialContext.",e);
    }

  }

*/

}
