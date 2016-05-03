package entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: payment
 *
 */
@Entity

public class Payment implements Serializable {

	   
	@Id
	private int id_payment;
	private int id_user;
	private int id_annoncement;
	private String type;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Buyer buyer;

	public Payment() {
		super();
	}   
	public int getId_payment() {
		return this.id_payment;
	}

	public void setId_payment(int id_payment) {
		this.id_payment = id_payment;
	}   
	public int getId_user() {
		return this.id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}   
	public int getId_annoncement() {
		return this.id_annoncement;
	}

	public void setId_annoncement(int id_annoncement) {
		this.id_annoncement = id_annoncement;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
   
}
