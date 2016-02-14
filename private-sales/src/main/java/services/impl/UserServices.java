package services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.User;
import services.interfaces.UserServicesLocal;
import services.interfaces.UserServicesRemote;

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

}
