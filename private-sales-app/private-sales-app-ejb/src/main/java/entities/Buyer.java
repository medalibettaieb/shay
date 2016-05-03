package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: buyer
 *
 */
@Entity

public class Buyer extends User implements Serializable {

	private Integer bonus_points;
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "buyer")
	private List<Basket> baskets;
	@OneToMany(mappedBy = "buyer")
	private List<Payment> payments;

	@OneToMany(mappedBy = "buyer")
	private List<Complaints> complaints;

	public Buyer() {
		super();
	}

	public Integer getBonus_points() {
		return this.bonus_points;
	}

	public void setBonus_points(Integer bonus_points) {

		this.bonus_points = bonus_points;
	}

	public Buyer(String name, String surname, Integer age, String address, String email, String login, String password,
			Integer bonus_points) {
		super();
		setName(name);
		setSurname(surname);
		setAge(age);
		setAddress(address);
		setEmail(email);
		setLogin(login);
		setPassword(password);
		this.bonus_points = bonus_points;
	}

}
