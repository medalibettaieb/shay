package tn.esprit.gl2.travel_advice.services;

import javax.ejb.Remote;

@Remote
public interface CommentServicesRemote {
	void addComment(int idUser, int idTouristicPlace, String text);

}
