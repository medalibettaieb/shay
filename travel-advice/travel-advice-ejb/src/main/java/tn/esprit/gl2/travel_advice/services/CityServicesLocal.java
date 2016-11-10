package tn.esprit.gl2.travel_advice.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.gl2.travel_advice.persistence.City;
import tn.esprit.gl2.travel_advice.persistence.TouristicPlace;

@Local
public interface CityServicesLocal {
	void addCity(City city);

	void addTouristicPlace(TouristicPlace touristicPlace);

	List<City> findAllCities();

	List<TouristicPlace> findAllTouristicPlacesByIdCity(int idCity);
}
