package net.froihofer.util.jboss;

import net.froihofer.util.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless(name="AddUserService")
@PermitAll
public class Kunden_Service {
    private static final Logger log = LoggerFactory.getLogger(Kunden_Service.class);

    @PersistenceContext
    private EntityManager entman;


    public Kunde generate_Kunde(String firstName, String lastName, String street, String houseNo, String place, Integer zipCode) {

        Kunde kunde = new Kunde();

        kunde.setFirstName(firstName);
        kunde.setLastName(lastName);
        kunde.setStreet(street);
        kunde.setHouseNo(houseNo);
        kunde.setPlace(place);
        kunde.setZipcode(zipCode);

        log.info("Kunde erstellt!");

        persist_Kunde(kunde);

        return kunde;
    }

    public void persist_Kunde (Kunde kunde){
        try{
            entman.persist(kunde);
            log.info("Kunde persistiert!");

        }catch(NullPointerException e){
            log.error("Something went wrong while trying to persist. (NPE)...", e);
        }
    }

}
