package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Commentaire;

@Local
public interface CommentServicesLocal {
	Boolean addCommentaireOnAnnouncement(String text, Integer idAnnoucement, Integer idUser);

	Boolean deleteCommentaireOfAUser(Integer idAnnoucement, Integer idUser);

	List<Commentaire> findAllCommentairesByAnnoncementId(Integer idAnnoncement);
}
