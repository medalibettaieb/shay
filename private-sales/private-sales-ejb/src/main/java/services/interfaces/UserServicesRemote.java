package services.interfaces;

import javax.ejb.Remote;

import entities.User;

@Remote
public interface UserServicesRemote {
	User findUserById(Integer id);
}
