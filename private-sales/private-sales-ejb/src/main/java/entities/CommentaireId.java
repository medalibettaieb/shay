package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CommentaireId implements Serializable {
	private Integer idUser;
	private Integer idAnnoncement;

	public CommentaireId() {
		// TODO Auto-generated constructor stub
	}

	public CommentaireId(Integer idUser, Integer idAnnoncement) {
		super();
		this.idUser = idUser;
		this.idAnnoncement = idAnnoncement;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAnnoncement == null) ? 0 : idAnnoncement.hashCode());
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
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
		CommentaireId other = (CommentaireId) obj;
		if (idAnnoncement == null) {
			if (other.idAnnoncement != null)
				return false;
		} else if (!idAnnoncement.equals(other.idAnnoncement))
			return false;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		return true;
	}

}
