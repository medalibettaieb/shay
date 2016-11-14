package tn.esprit.gl2.travel_advice.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.gl2.travel_advice.persistence.Comment;
import tn.esprit.gl2.travel_advice.persistence.TouristicPlace;
import tn.esprit.gl2.travel_advice.persistence.Traveler;

/**
 * Session Bean implementation class CommentServices
 */
@Stateless
public class CommentServices implements CommentServicesRemote, CommentServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public CommentServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addComment(int idUser, int idTouristicPlace, String text) {
		Traveler traveler = entityManager.find(Traveler.class, idUser);
		TouristicPlace touristicPlace = entityManager.find(TouristicPlace.class, idTouristicPlace);

		Comment comment = new Comment(text, traveler, touristicPlace);

		entityManager.merge(comment);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> findAllCommentsByTouristicPlaceId(int idTouristicPlace) {
		return entityManager.createQuery("select c from Comment c where c.touristicPlace.id=:p")
				.setParameter("p", idTouristicPlace).getResultList();
	}

}
