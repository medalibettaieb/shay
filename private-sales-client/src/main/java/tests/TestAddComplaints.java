package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Buyer;
import entities.Seller;
import services.interfaces.ComplaintsServicesRemote;
import services.interfaces.UserServicesRemote;

public class TestAddComplaints {
	public static void main(String[] args) throws NamingException {

		Context context = new InitialContext();
		UserServicesRemote userServicesRemote = (UserServicesRemote) context
				.lookup("/private-sales/UserServices!services.interfaces.UserServicesRemote");
		ComplaintsServicesRemote complaintsServicesRemote = (ComplaintsServicesRemote) context
				.lookup("/private-sales/ComplaintsServices!services.interfaces.ComplaintsServicesRemote");

		Buyer buyer = (Buyer) userServicesRemote.findUserById(1);
		Seller seller = (Seller) userServicesRemote.findUserById(2);

		System.out.println(complaintsServicesRemote.addComplaints(buyer, seller, "ay 7aja"));

	}
}
