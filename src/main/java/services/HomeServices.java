package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import opower.Home;
import opower.Person;

public class HomeServices extends GeneralQueries {

	
    CriteriaQuery<Home> criteriaQuery = cb.createQuery(Home.class);
    Root<Home> homeRoot = criteriaQuery.from(Home.class);

    public HomeServices(EntityManager manager) {
        super(manager);
    }

    public void showResponse(List<Home> homes) {
        for (Home home : homes) {
            System.out.println(">:" + home.getName());
            System.out.println(">:" + home.getPieces());
            System.out.println(">:" + home.getPieces());
        }
    }

    public List<Home> getPersonByIdentifier(int identifier) {
        criteriaQuery.select(homeRoot);
        criteriaQuery.where(cb.equal(homeRoot.get("id"), identifier));

        List<Home> homes = manager.createQuery(criteriaQuery).getResultList();

        showResponse(homes);

        return homes;
    }

    public List<Home> getPersonByName(String name) {
        criteriaQuery.select(homeRoot);
        criteriaQuery.where(cb.equal(homeRoot.get("name"), name));

        List<Home> homes = manager.createQuery(criteriaQuery).getResultList();

        showResponse(homes);

        return homes;
    }

    public List<Home> getPersonBySurname(String surname) {
        criteriaQuery.select(homeRoot);
        criteriaQuery.where(cb.equal(homeRoot.get("surname"), surname));

        List<Home> homes = manager.createQuery(criteriaQuery).getResultList();

        showResponse(homes);

        return homes;
    }

    public List<Home> getPersons() {
        CriteriaQuery<Home> all = criteriaQuery.select(homeRoot);
        TypedQuery<Home> allQuery = manager.createQuery(all);
        List<Home> homes = allQuery.getResultList();

        showResponse(homes);

        return homes;
    }
    
}
