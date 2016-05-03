package util;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Annoncement;
import entities.Buyer;
import entities.Seller;
import entities.User;
import services.interfaces.CommentServicesRemote;

/**
 * Session Bean implementation class DbPopulate
 */
@Singleton
@LocalBean
@Startup
public class DbPopulate {

	@PersistenceContext
	private EntityManager entityManager;
	@EJB
	private CommentServicesRemote commentServicesRemote;

	/**
	 * Default constructor.
	 */
	public DbPopulate() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void initDB() {
		Buyer buyer = new Buyer("shay ma", "khlifi", 24, "esprit", "shayma@esprit.tn", "shay", "ma", 150);

		Seller seller = new Seller("med", "mohsen", 30, "tunis", "mohsen@esprit.tn", "med", "mohsen", "male");
		User user = new User( "julien", "jojo", 40, "tunis", "jojo@esprit.tn", "julien", "jojo123");

		Annoncement annoncement = new Annoncement("for sale", 123F, seller);
		Annoncement annoncement1 = new Annoncement("for sale", 133F, seller);

		

		entityManager.persist(buyer);
		entityManager.persist(seller);
		entityManager.persist(user);
		entityManager.persist(annoncement);
		entityManager.persist(annoncement1);
	}

}
