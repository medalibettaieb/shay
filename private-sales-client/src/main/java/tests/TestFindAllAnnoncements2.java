package tests;

import java.util.List;

import javax.naming.NamingException;

import delegate.AnnoncementDelegate;
import entities.Annoncement;

public class TestFindAllAnnoncements2 {
	public static void main(String[] args) throws NamingException {

		List<Annoncement> annoncements = AnnoncementDelegate.doFindAllAnnoncements();
		for (Annoncement a : annoncements) {
			System.out.println(a.getName());
		}
	}
}
