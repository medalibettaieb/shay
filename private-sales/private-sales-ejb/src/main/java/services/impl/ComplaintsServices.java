package services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Buyer;
import entities.Complaints;
import entities.Seller;
import services.interfaces.ComplaintsServicesLocal;
import services.interfaces.ComplaintsServicesRemote;

/**
 * Session Bean implementation class ComplaintsServices
 */
@Stateless
public class ComplaintsServices implements ComplaintsServicesRemote, ComplaintsServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public ComplaintsServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean addComplaints(Buyer buyer, Seller seller, String object) {
		Boolean b = false;
		try {
			Complaints complaints = new Complaints(object, seller, buyer);
			entityManager.persist(complaints);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

}
