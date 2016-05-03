package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Commentaire;

@Remote
public interface CommentServicesRemote {
	void sallem(String name);

	Boolean addCommentaireOnAnnouncement(String text, Integer idAnnoucement, Integer idUser);

	Boolean deleteCommentaireOfAUser(Integer idAnnoucement, Integer idUser);

	List<Commentaire> findAllCommentairesByAnnoncementId(Integer idAnnoncement);
}
