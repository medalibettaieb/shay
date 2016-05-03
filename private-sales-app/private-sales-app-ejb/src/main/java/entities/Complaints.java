package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Complaints
 *
 */
@Entity

public class Complaints implements Serializable {
	@EmbeddedId
	private ComplaintsId complaintsId;
	private String object;
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "idSeller", referencedColumnName = "id", insertable = false, updatable = false)
	private Seller seller;
	@ManyToOne
	@JoinColumn(name = "idBuyer", referencedColumnName = "id", insertable = false, updatable = false)
	private Buyer buyer;

	public Complaints() {
		super();
	}

	public String getObject() {
		return this.object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public Complaints(String object, Seller seller, Buyer buyer) {
		super();
		this.object = object;
		this.seller = seller;
		this.buyer = buyer;
		this.complaintsId = new ComplaintsId(buyer.getId(), seller.getId());
	}

}
