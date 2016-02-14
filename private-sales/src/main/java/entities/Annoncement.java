package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Annoncement
 *
 */
@Entity

public class Annoncement implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Float price;
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "annoncement")
	private List<Commentaire> commentaires;

	@ManyToOne
	private User user;

	public Annoncement() {
		super();
	}

	public Annoncement(String name, Float price, User user) {
		super();
		this.name = name;
		this.price = price;
		this.user = user;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
