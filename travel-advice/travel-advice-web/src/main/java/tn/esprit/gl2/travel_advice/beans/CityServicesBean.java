package tn.esprit.gl2.travel_advice.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import tn.esprit.gl2.travel_advice.persistence.City;
import tn.esprit.gl2.travel_advice.persistence.TouristicPlace;
import tn.esprit.gl2.travel_advice.services.CityServicesLocal;
import tn.esprit.gl2.travel_advice.services.WishlistServicesLocal;

@ManagedBean
@SessionScoped
public class CityServicesBean {
	private List<City> cities = new ArrayList<>();
	private List<TouristicPlace> touristicPlaces = new ArrayList<>();
	private boolean showTouristicPlacesByCity = false;
	private boolean showCities = true;
	private List<TouristicPlace> wishlist;
	@EJB
	private CityServicesLocal cityServicesLocal;
	@EJB
	private WishlistServicesLocal wishlistServicesLocal;
	@ManagedProperty(value = "#{loginBean}")
	private LoginBean loginBean;
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

	public String doSelectWish() {
		wishlist = wishlistServicesLocal.findAllTouristicPlacesByTraveler(loginBean.getUser().getId());
		return "";
	}

	public String doAddTouristicPlace() {
		wishlistServicesLocal.addToWishlist(loginBean.getUser().getId(), loginBean.getIdT());
		return "/pages/listWish?faces-redirect=true";
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

	public CityServicesLocal getCityServicesLocal() {
		return cityServicesLocal;
	}

	public void setCityServicesLocal(CityServicesLocal cityServicesLocal) {
		this.cityServicesLocal = cityServicesLocal;
	}

	public WishlistServicesLocal getWishlistServicesLocal() {
		return wishlistServicesLocal;
	}

	public void setWishlistServicesLocal(WishlistServicesLocal wishlistServicesLocal) {
		this.wishlistServicesLocal = wishlistServicesLocal;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public List<TouristicPlace> getWishlist() {
		return wishlist;
	}

	public void setWishlist(List<TouristicPlace> wishlist) {
		this.wishlist = wishlist;
	}

}
