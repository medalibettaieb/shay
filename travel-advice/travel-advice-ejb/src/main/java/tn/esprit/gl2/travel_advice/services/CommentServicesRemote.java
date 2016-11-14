package tn.esprit.gl2.travel_advice.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.gl2.travel_advice.persistence.Comment;

@Remote
public interface CommentServicesRemote {
	void addComment(int idUser, int idTouristicPlace, String text);

	List<Comment> findAllCommentsByTouristicPlaceId(int idTouristicPlace);
}
