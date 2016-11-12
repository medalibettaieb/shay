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

		Traveler traveler = new Traveler("t", "t", "tarek", "kouki", "32145699", format.parse("01/01/1991"));
		Traveler traveler2 = new Traveler("r", "r", "rim", "mahmoudi", "32145687", format.parse("01/01/1992"));
		Traveler traveler3 = new Traveler("h", "h", "hela", "mohamed", "32145658", format.parse("01/01/1993"));
		Traveler traveler4 = new Traveler("z", "z", "zied", "radhi", "32154456", format.parse("01/01/1994"));

		City city = new City("PARIS");
		city.setImgLink("fr.png");
		
		City city2 = new City("TUNISIE");
		city2.setImgLink("t.jpg");

		TouristicPlace place = new TouristicPlace("TOUR EFFEL", city);
		place.setImgLink("tour.jpg");
		TouristicPlace place2 = new TouristicPlace("SIDI BOUSAIID", city2);
		place2.setImgLink("sidi.jpg");
		TouristicPlace place3 = new TouristicPlace("MEDINA", city2);
		place3.setImgLink("medina.jpg");
		TouristicPlace place4 = new TouristicPlace("HAMMAMET", city2);
		place4.setImgLink("ham.jpg");

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
		entityManager.merge(traveler4);

		entityManager.merge(city);
		entityManager.merge(city2);
	}
}
