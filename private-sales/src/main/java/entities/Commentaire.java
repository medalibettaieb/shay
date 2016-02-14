package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Commentaire
 *
 */
@Entity

public class Commentaire implements Serializable {
	@EmbeddedId
	private CommentaireId commentaireId;
	private String text;
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "idAnnoncement", referencedColumnName = "id", insertable = false, updatable = false)
	private Annoncement annoncement;
	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "id", insertable = false, updatable = false)
	private User user;

	public Commentaire() {
		super();
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public CommentaireId getCommentaireId() {
		return commentaireId;
	}

	public void setCommentaireId(CommentaireId commentaireId) {
		this.commentaireId = commentaireId;
	}

	public Commentaire(String text, Annoncement annoncement, User user) {
		super();
		this.text = text;
		this.annoncement = annoncement;
		this.user = user;
		this.commentaireId = new CommentaireId(user.getId(), annoncement.getId());
	}

}
