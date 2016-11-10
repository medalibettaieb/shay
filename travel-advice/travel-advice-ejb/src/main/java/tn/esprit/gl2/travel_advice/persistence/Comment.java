package tn.esprit.gl2.travel_advice.persistence;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Comment
 *
 */
@Entity

public class Comment implements Serializable {
	@EmbeddedId
	private CommentId commentId;
	private String text;

	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "id", insertable = false, updatable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "idTouristicPlace", referencedColumnName = "id", insertable = false, updatable = false)
	private TouristicPlace touristicPlace;
	private static final long serialVersionUID = 1L;

	public Comment() {
		super();
	}

	public Comment(String text, User user, TouristicPlace touristicPlace) {
		super();
		this.text = text;
		this.user = user;
		this.touristicPlace = touristicPlace;
		this.commentId = new CommentId(user.getId(), touristicPlace.getId());
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public TouristicPlace getTouristicPlace() {
		return touristicPlace;
	}

	public void setTouristicPlace(TouristicPlace touristicPlace) {
		this.touristicPlace = touristicPlace;
	}

}
