package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ComplaintsId implements Serializable {
	private Integer idBuyer;
	private Integer idSeller;

	public ComplaintsId() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdBuyer() {
		return idBuyer;
	}

	public void setIdBuyer(Integer idBuyer) {
		this.idBuyer = idBuyer;
	}

	public Integer getIdSeller() {
		return idSeller;
	}

	public void setIdSeller(Integer idSeller) {
		this.idSeller = idSeller;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idBuyer == null) ? 0 : idBuyer.hashCode());
		result = prime * result + ((idSeller == null) ? 0 : idSeller.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComplaintsId other = (ComplaintsId) obj;
		if (idBuyer == null) {
			if (other.idBuyer != null)
				return false;
		} else if (!idBuyer.equals(other.idBuyer))
			return false;
		if (idSeller == null) {
			if (other.idSeller != null)
				return false;
		} else if (!idSeller.equals(other.idSeller))
			return false;
		return true;
	}

	public ComplaintsId(Integer idBuyer, Integer idSeller) {
		super();
		this.idBuyer = idBuyer;
		this.idSeller = idSeller;
	}

}
