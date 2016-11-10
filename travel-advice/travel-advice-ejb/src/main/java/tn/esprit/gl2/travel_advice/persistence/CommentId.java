package tn.esprit.gl2.travel_advice.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class CommentId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idUser;
	private int idTouristicPlace;
	private Date date;

	public CommentId() {
		// TODO Auto-generated constructor stub
	}

	public CommentId(int idUser, int idTouristicPlace) {
		super();
		this.idUser = idUser;
		this.idTouristicPlace = idTouristicPlace;
		this.date = new Date();
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdTouristicPlace() {
		return idTouristicPlace;
	}

	public void setIdTouristicPlace(int idTouristicPlace) {
		this.idTouristicPlace = idTouristicPlace;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + idTouristicPlace;
		result = prime * result + idUser;
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
		CommentId other = (CommentId) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (idTouristicPlace != other.idTouristicPlace)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}

}
