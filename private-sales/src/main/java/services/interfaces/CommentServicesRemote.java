package services.interfaces;

import javax.ejb.Remote;

@Remote
public interface CommentServicesRemote {
	void sallem(String name);

	Boolean addCommentaireOnAnnouncement(String text, Integer idAnnoucement, Integer idUser);

	Boolean deleteCommentaireOfAUser(Integer idAnnoucement, Integer idUser);
}
