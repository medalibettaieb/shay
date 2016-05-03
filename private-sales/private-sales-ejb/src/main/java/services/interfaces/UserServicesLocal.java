package services.interfaces;

import javax.ejb.Local;

import entities.User;

@Local
public interface UserServicesLocal {
	User login(String login, String password);
}
