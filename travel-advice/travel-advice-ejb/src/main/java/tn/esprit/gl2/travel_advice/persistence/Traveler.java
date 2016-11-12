package tn.esprit.gl2.travel_advice.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Traveler extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String firstname;
	private String lastname;
	private String phoneNumber;
	private Date birthDate;

	public Traveler() {
	}

	public Traveler(String firstname, String lastname, String phoneNumber, Date birthDate) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.phoneNumber = phoneNumber;
		this.birthDate = birthDate;
	}

	public Traveler(String login, String password, String firstname, String lastname, String phoneNumber,
			Date birthDate) {
		super(login, password);
		this.firstname = firstname;
		this.lastname = lastname;
		this.phoneNumber = phoneNumber;
		this.birthDate = birthDate;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

}
