package worldFacade;

import entity.Country;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author joaci
 */
public class WorldFacade {

    private EntityManagerFactory emf;

    public WorldFacade(String persistenceUnit) {
        this.emf = Persistence.createEntityManagerFactory(persistenceUnit);
    }
    
    public Country getCountry(String country){
        return getEntityManager().find(Country.class, country);
    }

    public List<Object[]> getCountries() {
        List<Object[]> r = getEntityManager().createQuery("SELECT c.code,c.name,c.continent,c.capital.name FROM Country c").getResultList();
        return r;
    }

    public List<Object[]> getCountriesPopGreather(int greater) {
        List<Object[]> r = getEntityManager().createQuery("SELECT c.code,c.name,c.continent,c.capital.name FROM Country c WHERE c.population > :greater ").setParameter("greater", greater).getResultList();
        return r;
    }

    public List<Object[]> getCitiesInCountry(String code) {
        List<Object[]> r = getEntityManager().createQuery("SELECT c.name,c.population from City c where c.countryCode.code = :code ").setParameter("code", code).getResultList();
        return r;
    }

    public Country updateCountry(Country country) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(country);
        em.getTransaction().commit();
        em.close();
        return country;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
