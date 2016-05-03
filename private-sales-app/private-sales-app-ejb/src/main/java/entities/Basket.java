package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: basket
 *
 */
@Entity

public class Basket implements Serializable {

	@Id
	private int id_bascket;
	private int id_user;
	private int id_annoncement;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Buyer buyer;

	public Basket() {
		super();
	}

	public int getId_bascket() {
		return this.id_bascket;
	}

	public void setId_bascket(int id_bascket) {
		this.id_bascket = id_bascket;
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

}
