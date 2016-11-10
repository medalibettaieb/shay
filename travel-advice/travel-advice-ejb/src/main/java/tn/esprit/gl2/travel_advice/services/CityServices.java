package tn.esprit.gl2.travel_advice.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.gl2.travel_advice.persistence.City;
import tn.esprit.gl2.travel_advice.persistence.TouristicPlace;

/**
 * Session Bean implementation class CityServices
 */
@Stateless
public class CityServices implements CityServicesRemote, CityServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public CityServices() {
	}

	@Override
	public void addCity(City city) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTouristicPlace(TouristicPlace touristicPlace) {

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<City> findAllCities() {
		Query query = entityManager.createQuery("select c from City c");
		return query.getResultList();
	}

	@Override
	public List<TouristicPlace> findAllTouristicPlacesByIdCity(int idCity) {
		Query query = entityManager.createQuery("select t from TouristicPlace t where t.city.id=:param1");
		query.setParameter("param1", idCity);
		return query.getResultList();

	}

}
