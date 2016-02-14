package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Seller
 *
 */
@Entity

public class Seller extends User implements Serializable {

	private String gender;
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "seller")
	private List<Complaints> complaints;

	public Seller() {
		super();
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Seller(String name, String surname, Integer age, String address, String email, String login, String password,
			String gender) {
		super();
		setName(name);
		setSurname(surname);
		setAge(age);
		setAddress(address);
		setEmail(email);
		setLogin(login);
		setPassword(password);
		this.gender = gender;
	}

}
