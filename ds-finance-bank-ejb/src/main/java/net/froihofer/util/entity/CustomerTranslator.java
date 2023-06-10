package net.froihofer.util.entity;

import common.CustomerDTO;

/**
 * @author Lorenz Froihofer
 */





public class CustomerTranslator {
  /** Converts a DTO instance to an entity instance. */
//  public Client toEntity(ClientDTO client) {
  public Kunde toEntity(CustomerDTO client) {

    if (client == null) return null;

    Kunde result = new Kunde();
    result.setFirstName(client.getFirstName());
    result.setLastName(client.getLastName());
    result.setHouseNo(client.getHouseNo());
    result.setPlace(client.getPlace());
    result.setZipcode(client.getZipCode());
    result.setId(client.getId());

    return result;
  }

  /** Converts an entity instance to a DTO instance. */
  public CustomerDTO toDTO(Kunde client) {

    if (client == null) return null;

    CustomerDTO result = new CustomerDTO();
    result.setFirstName(client.getFirstName());
    result.setLastName(client.getLastName());
    result.setHouseNo(client.getHouseNo());
    result.setPlace(client.getPlace());
    result.setZipCode(client.getZipcode());
    result.setId(client.getId());

    return result;
  }
}