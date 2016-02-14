package delegate;

import locator.ServiceLocator;
import services.interfaces.CommentServicesRemote;

public class CommentaireDelegate {
	private static final String jndiName = "/private-sales/CommentServices!services.interfaces.CommentServicesRemote";

	private static CommentServicesRemote getProxy() {
		return (CommentServicesRemote) ServiceLocator.getInstance().getProxy(jndiName);
	}

	public static Boolean doAddCommentaireOnAnnouncement(String text, Integer idAnnoucement, Integer idUser) {
		return getProxy().addCommentaireOnAnnouncement(text, idAnnoucement, idUser);

	}

	public static Boolean doDeleteCommentaireOfAUser(Integer idAnnoucement, Integer idUser) {
		return getProxy().deleteCommentaireOfAUser(idAnnoucement, idUser);

	}

}
