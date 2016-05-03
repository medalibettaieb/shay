package services.interfaces;

import javax.ejb.Local;

import entities.Buyer;
import entities.Seller;

@Local
public interface ComplaintsServicesLocal {
	Boolean addComplaints(Buyer buyer, Seller seller, String object);

}
