package tn.esprit.gl2.travel_advice.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.gl2.travel_advice.persistence.TouristicPlace;

@Local
public interface WishlistServicesLocal {
	void addToWishlist(int idTraveler, int idTouristiPlace);

	List<TouristicPlace> findAllTouristicPlacesByTraveler(int idTraveler);
}
