package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Annoncement;
import entities.User;
import services.interfaces.AnnoncementServicesLocal;
import services.interfaces.AnnoncementServicesRemote;

/**
 * Session Bean implementation class AnnoncementServices
 */
@Stateless
public class AnnoncementServices implements AnnoncementServicesRemote, AnnoncementServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public AnnoncementServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Annoncement> findAllAnnoncements() {
		return entityManager.createQuery("select a from Annoncement a", Annoncement.class).getResultList();
	}

	@Override
	public void addAnnoncement(Annoncement annoncement, Integer idUser) {
		annoncement.setUser(entityManager.find(User.class, idUser));
		entityManager.persist(annoncement);

	}

	@Override
	public Annoncement findAnnoncementById(Integer id) {
		return entityManager.find(Annoncement.class, id);
	}

	@Override
	public void deleteAnnoncement(Integer id) {
		entityManager.remove(findAnnoncementById(id));

	}

	@Override
	public void updateAnnoncement(Annoncement annoncement) {
		entityManager.merge(annoncement);
	}

}
