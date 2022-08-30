package common;

import javax.ejb.Remote;
import java.math.BigDecimal;
import java.util.List;


@Remote
public interface StockExchange {


    List<String> searchForStock(String txt);
    BigDecimal buy(String symbol, int shares);

    public CustomerDTO createCustomer(CustomerDTO customerDTO);

    public CustomerDTO findById(int id);

    /*
  *//** Persistently stores the value of the given variable. *//*
    public void storeClient(ClientDTO variable) throws ClientException;

    public void storeClient(ClientDTO client) throws ClientException {

   *//** Returns the value of a persisted variable. *//*
    public long getClient(String name) throws ClientException;

    



    public void persist(Client client);

    public void delete(Client client);*/


    }
