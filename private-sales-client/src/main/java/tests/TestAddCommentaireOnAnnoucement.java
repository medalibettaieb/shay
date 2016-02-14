package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.CommentServicesRemote;

public class TestAddCommentaireOnAnnoucement {

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();
			String jndiName = "/private-sales/CommentServices!services.interfaces.CommentServicesRemote";
			CommentServicesRemote proxy = (CommentServicesRemote) context.lookup(jndiName);

			System.out.println(proxy.addCommentaireOnAnnouncement("makhiebha ", 1, 1));

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
