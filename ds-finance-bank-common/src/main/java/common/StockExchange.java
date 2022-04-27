package common;

import java.math.BigDecimal;
import java.util.List;



public interface StockExchange {

    List<String> searchForStock(String txt);
    BigDecimal buy(String symbol, int shares);



    }
