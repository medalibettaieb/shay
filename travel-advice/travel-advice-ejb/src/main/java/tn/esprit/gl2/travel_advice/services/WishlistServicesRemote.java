package tn.esprit.gl2.travel_advice.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.gl2.travel_advice.persistence.TouristicPlace;

@Remote
public interface WishlistServicesRemote {
	void addToWishlist(int idTraveler, int idTouristiPlace);

	List<TouristicPlace> findAllTouristicPlacesByTraveler(int idTraveler);
}
