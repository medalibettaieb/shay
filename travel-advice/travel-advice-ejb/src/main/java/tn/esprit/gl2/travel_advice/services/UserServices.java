package tn.esprit.gl2.travel_advice.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.gl2.travel_advice.persistence.User;

/**
 * Session Bean implementation class UserServices
 */
@Stateless
public class UserServices implements UserServicesRemote, UserServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public UserServices() {
	}

	@Override
	public User login(String login, String password) {
		User utilisateur = null;
		Query query = entityManager.createQuery("select u from User u where u.login=:l and u.password=:p");
		query.setParameter("l", login);
		query.setParameter("p", password);
		try {
			utilisateur = (User) query.getSingleResult();
		} catch (Exception e) {
		}

		return utilisateur;
	}

}
