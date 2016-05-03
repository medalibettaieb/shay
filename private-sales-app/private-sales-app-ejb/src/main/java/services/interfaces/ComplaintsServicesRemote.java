package services.interfaces;

import javax.ejb.Remote;

import entities.Buyer;
import entities.Seller;

@Remote
public interface ComplaintsServicesRemote {
	Boolean addComplaints(Buyer buyer, Seller seller, String object);

}
