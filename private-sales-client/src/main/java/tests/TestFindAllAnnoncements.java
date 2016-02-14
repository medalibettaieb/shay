package tests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Annoncement;
import services.interfaces.AnnoncementServicesRemote;

public class TestFindAllAnnoncements {
	public static void main(String[] args) throws NamingException {

		Context context = new InitialContext();
		AnnoncementServicesRemote annoncementServicesRemote = (AnnoncementServicesRemote) context
				.lookup("/private-sales/AnnoncementServices!services.interfaces.AnnoncementServicesRemote");

		List<Annoncement> annoncements = annoncementServicesRemote.findAllAnnoncements();
		for (Annoncement a : annoncements) {
			System.out.println(a.getName());
		}
	}
}
