package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.CommentServicesRemote;

public class TestSallem {

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();
			String jndiName = "/private-sales/CommentServices!services.interfaces.CommentServicesRemote";
			CommentServicesRemote proxy = (CommentServicesRemote) context.lookup(jndiName);

			proxy.sallem("chay maa");

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
