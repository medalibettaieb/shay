package tn.esprit.gl2.travel_advice.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: City
 *
 */
@Entity

public class City implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String imgLink;

	@OneToMany(mappedBy = "city", cascade = CascadeType.MERGE)
	private List<TouristicPlace> touristicPlaces;
	private static final long serialVersionUID = 1L;

	public City() {
		super();
	}

	public City(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TouristicPlace> getTouristicPlaces() {
		return touristicPlaces;
	}

	public void setTouristicPlaces(List<TouristicPlace> touristicPlaces) {
		this.touristicPlaces = touristicPlaces;
	}

	public void link(List<TouristicPlace> touristicPlaces) {
		this.touristicPlaces = touristicPlaces;
		for (TouristicPlace t : touristicPlaces) {
			t.setCity(this);
		}
	}

	public String getImgLink() {
		return imgLink;
	}

	public void setImgLink(String imgLink) {
		this.imgLink = imgLink;
	}

}
