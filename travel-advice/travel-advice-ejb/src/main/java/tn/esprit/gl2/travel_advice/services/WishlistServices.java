package tn.esprit.gl2.travel_advice.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.gl2.travel_advice.persistence.TouristicPlace;
import tn.esprit.gl2.travel_advice.persistence.Traveler;

/**
 * Session Bean implementation class WishlistServices
 */
@Stateless
public class WishlistServices implements WishlistServicesRemote, WishlistServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public WishlistServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addToWishlist(int idTraveler, int idTouristiPlace) {
		Traveler traveler = entityManager.find(Traveler.class, idTraveler);
		TouristicPlace touristicPlace = entityManager.find(TouristicPlace.class, idTouristiPlace);

		touristicPlace.getUsersWishlisted().add(traveler);

		entityManager.merge(touristicPlace);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TouristicPlace> findAllTouristicPlacesByTraveler(int idTraveler) {
		Traveler traveler = entityManager.find(Traveler.class, idTraveler);
		return entityManager.createQuery("select t from TouristicPlace t where :param member of t.usersWishlisted")
				.setParameter("param", traveler).getResultList();
	}

}
