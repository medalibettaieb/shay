package tn.esprit.gl2.travel_advice.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: TouristicPlace
 *
 */
@Entity

public class TouristicPlace implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String imgLink;

	@ManyToMany
	private List<User> usersWishlisted;

	@OneToMany(mappedBy = "touristicPlace")
	private List<Comment> comments;

	@ManyToOne(cascade = CascadeType.MERGE)
	private City city;
	private static final long serialVersionUID = 1L;

	public TouristicPlace() {
		super();
	}

	public TouristicPlace(String name, City city) {
		super();
		this.name = name;
		this.city = city;
	}

	public TouristicPlace(String name) {
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

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<User> getUsersWishlisted() {
		return usersWishlisted;
	}

	public void setUsersWishlisted(List<User> usersWishlisted) {
		this.usersWishlisted = usersWishlisted;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getImgLink() {
		return imgLink;
	}

	public void setImgLink(String imgLink) {
		this.imgLink = imgLink;
	}

}
