package tn.esprit.gl2.travel_advice.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.gl2.travel_advice.persistence.City;
import tn.esprit.gl2.travel_advice.persistence.TouristicPlace;

@Remote
public interface CityServicesRemote {
	void addCity(City city);

	void addTouristicPlace(TouristicPlace touristicPlace);

	List<City> findAllCities();
}
