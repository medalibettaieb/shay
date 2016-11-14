package tn.esprit.gl2.travel_advice.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.gl2.travel_advice.persistence.Comment;

@Local
public interface CommentServicesLocal {
	void addComment(int idUser, int idTouristicPlace, String text);

	List<Comment> findAllCommentsByTouristicPlaceId(int idTouristicPlace);
}
