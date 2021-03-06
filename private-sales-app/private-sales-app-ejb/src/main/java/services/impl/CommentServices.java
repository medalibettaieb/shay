package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import services.interfaces.CommentServicesLocal;
import services.interfaces.CommentServicesRemote;
import entities.Annoncement;
import entities.Commentaire;
import entities.CommentaireId;
import entities.User;

/**
 * Session Bean implementation class CommentServices
 */
@Stateless
public class CommentServices implements CommentServicesRemote,
		CommentServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public CommentServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean addCommentaireOnAnnouncement(String text,
			Integer idAnnoucement, Integer idUser) {
		Boolean b = false;
		Annoncement annoncement = entityManager.find(Annoncement.class,
				idAnnoucement);
		User user = entityManager.find(User.class, idUser);

		Commentaire commentaire = new Commentaire(text, annoncement, user);
		try {
			entityManager.persist(commentaire);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean deleteCommentaireOfAUser(Integer idAnnoucement,
			Integer idUser) {
		Boolean b = false;
		try {
			entityManager.remove(entityManager.find(Commentaire.class,
					new CommentaireId(idUser, idAnnoucement)));
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public List<Commentaire> findAllCommentairesByAnnoncementId(
			Integer idAnnoncement) {
		return entityManager
				.createQuery(
						"select c from Commentaire c where c.annoncement.id=:param",
						Commentaire.class).setParameter("param", idAnnoncement)
				.getResultList();
	}

}
