package tn.esprit.gl2.travel_advice.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.gl2.travel_advice.persistence.User;

@ManagedBean
@SessionScoped
public class LoginBean {
	private User user=new User();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
