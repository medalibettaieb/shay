package tn.esprit.gl2.travel_advice.services;

import javax.ejb.Local;

import tn.esprit.gl2.travel_advice.persistence.User;

@Local
public interface UserServicesLocal  {
	User login(String login, String password);
}
