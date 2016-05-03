package services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import services.interfaces.UserServicesLocal;
import services.interfaces.UserServicesRemote;
import entities.User;

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
		// TODO Auto-generated constructor stub
	}

	@Override
	public User findUserById(Integer id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public User login(String login, String password) {
		User user = null;
		try {
			user = (User) entityManager
					.createQuery(
							"select u from User u where u.login=:l and u.password=:p")
					.setParameter("l", login).setParameter("p", password)
					.getSingleResult();
		} catch (Exception e) {
		}
		return user;
	}

}
