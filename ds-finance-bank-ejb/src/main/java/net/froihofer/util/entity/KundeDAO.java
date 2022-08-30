package net.froihofer.util.entity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Data access object for {@link Client} entity, encapsulating all
 * persistence-related functions for {@link Client}, i.e., saving,
 * searching, and deleting.
 * @author Lorenz Froihofer
 */
public class KundeDAO {
  @PersistenceContext private EntityManager entityManager;
  
  public Kunde findById(int id) {
    return entityManager.find(Kunde.class, id);
  }
  
  public void persist(Kunde client) {

    entityManager.persist(client);

  }
  
  public void delete(Kunde client) {
    entityManager.remove(client);
  }
}
