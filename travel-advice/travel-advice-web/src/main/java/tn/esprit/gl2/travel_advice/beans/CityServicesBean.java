package tn.esprit.gl2.travel_advice.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.gl2.travel_advice.persistence.City;
import tn.esprit.gl2.travel_advice.persistence.TouristicPlace;
import tn.esprit.gl2.travel_advice.services.CityServicesLocal;

@ManagedBean
@SessionScoped
public class CityServicesBean {
	private List<City> cities = new ArrayList<>();
	private List<TouristicPlace> touristicPlaces = new ArrayList<>();
	private boolean showTouristicPlacesByCity = false;
	private boolean showCities = true;
	@EJB
	private CityServicesLocal cityServicesLocal;
	private int idCity;

	public String doSelect() {
		showTouristicPlacesByCity = true;
		showCities = false;
		return "";
	}
	public String doDeSelect() {
		showTouristicPlacesByCity = false;
		showCities = true;
		return "";
	}
	public String doComment() {
		return "/pages/addComment?faces-redirect=true";
	}

	public List<City> getCities() {
		cities = cityServicesLocal.findAllCities();
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public List<TouristicPlace> getTouristicPlaces() {
		touristicPlaces = cityServicesLocal.findAllTouristicPlacesByIdCity(idCity);
		return touristicPlaces;
	}

	public void setTouristicPlaces(List<TouristicPlace> touristicPlaces) {
		this.touristicPlaces = touristicPlaces;
	}

	public boolean isShowTouristicPlacesByCity() {
		return showTouristicPlacesByCity;
	}

	public void setShowTouristicPlacesByCity(boolean showTouristicPlacesByCity) {
		this.showTouristicPlacesByCity = showTouristicPlacesByCity;
	}

	public int getIdCity() {
		return idCity;
	}

	public void setIdCity(int idCity) {
		this.idCity = idCity;
	}

	public boolean isShowCities() {
		return showCities;
	}

	public void setShowCities(boolean showCities) {
		this.showCities = showCities;
	}

}
