package entities;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: service
 *
 */
@Entity

public class Service extends User implements Serializable {

	private String service_category;
	private String rating;
	private static final long serialVersionUID = 1L;

	public Service() {
		super();
	}

	public String getService_category() {
		return this.service_category;
	}

	public void setService_category(String service_category) {
		this.service_category = service_category;
	}

	public String getRating() {
		return this.rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

}
