package tn.esprit.gl2.travel_advice.services;

import javax.ejb.Remote;

import tn.esprit.gl2.travel_advice.persistence.User;

@Remote
public interface UserServicesRemote {
	User login(String login, String password);
}
