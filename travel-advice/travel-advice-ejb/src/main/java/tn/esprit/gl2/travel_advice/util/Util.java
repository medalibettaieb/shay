package tn.esprit.gl2.travel_advice.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.gl2.travel_advice.persistence.City;
import tn.esprit.gl2.travel_advice.persistence.TouristicPlace;
import tn.esprit.gl2.travel_advice.persistence.Traveler;

/**
 * Session Bean implementation class Util
 */
@Singleton
@LocalBean
@Startup
public class Util {
	@PersistenceContext
	private EntityManager entityManager;
	private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

	/**
	 * Default constructor.
	 */
	public Util() {
	}

	@PostConstruct
	public void initDB() throws ParseException {

		Traveler traveler = new Traveler("t", "t", "t@esprit.tn", "tarek", "kouki", "0936251",
				format.parse("06/11/1980"));
		Traveler traveler2 = new Traveler("r", "r", "r@esprit.tn", "ramzi", "toumi", "0978251",
				format.parse("01/01/1990"));
		Traveler traveler3 = new Traveler("c", "c", "c@esprit.tn", "chayma", "khelifi", "0236588",
				format.parse("01/01/1991"));

		City city = new City("PARIS");
		city.setImgLink("avatar2");
		
		City city2 = new City("TUNISIE");
		city2.setImgLink("avatar3");

		TouristicPlace place = new TouristicPlace("TOUR EFFEL", city);
		TouristicPlace place2 = new TouristicPlace("SIDI BOUSAIID", city2);
		TouristicPlace place3 = new TouristicPlace("MEDINA", city2);
		TouristicPlace place4 = new TouristicPlace("HAMMAMET", city2);

		List<TouristicPlace> touristicPlaces = new ArrayList<>();
		touristicPlaces.add(place);

		List<TouristicPlace> touristicPlaces2 = new ArrayList<>();
		touristicPlaces2.add(place2);
		touristicPlaces2.add(place3);
		touristicPlaces2.add(place4);

		city.link(touristicPlaces);
		city2.link(touristicPlaces2);

		entityManager.merge(traveler);
		entityManager.merge(traveler2);
		entityManager.merge(traveler3);

		entityManager.merge(city);
		entityManager.merge(city2);
	}
}
