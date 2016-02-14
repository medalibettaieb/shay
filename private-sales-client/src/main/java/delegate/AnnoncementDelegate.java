package delegate;

import java.util.List;

import entities.Annoncement;
import locator.ServiceLocator;
import services.interfaces.AnnoncementServicesRemote;

public class AnnoncementDelegate {
	private static final String jndiName = "/private-sales/AnnoncementServices!services.interfaces.AnnoncementServicesRemote";

	private static AnnoncementServicesRemote getProxy() {
		return (AnnoncementServicesRemote) ServiceLocator.getInstance().getProxy(jndiName);
	}

	public static List<Annoncement> doFindAllAnnoncements() {
		return getProxy().findAllAnnoncements();
	}

	public static void doAddAnnoncement(Annoncement annoncement, Integer idUser) {
		getProxy().addAnnoncement(annoncement, idUser);
	}

	public static Annoncement doFindAnnoncementById(Integer id) {
		return getProxy().findAnnoncementById(id);
	}

	public static void doDeleteAnnoncementById(Integer id) {
		getProxy().deleteAnnoncement(id);
	}

	public static void doUpdateAnnoncement(Annoncement	annoncement) {
		getProxy().updateAnnoncement(annoncement);
	}
}
