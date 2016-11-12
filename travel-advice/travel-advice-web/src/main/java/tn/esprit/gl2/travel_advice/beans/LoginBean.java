package tn.esprit.gl2.travel_advice.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.gl2.travel_advice.persistence.Traveler;
import tn.esprit.gl2.travel_advice.persistence.User;
import tn.esprit.gl2.travel_advice.services.UserServicesLocal;

@ManagedBean
@SessionScoped
public class LoginBean {
	private User user = new User();
	@EJB
	private UserServicesLocal userServicesLocal;

	public String doLogin() {
		String navigateTo = null;
		System.out.println(navigateTo);
		User userLoggedIn = userServicesLocal.login(user.getLogin(), user.getPassword());
		if (userLoggedIn != null) {
			if (userLoggedIn instanceof Traveler) {
				navigateTo = "/pages/travelerHome";
				user = userLoggedIn;
				System.out.println(navigateTo);
			}
		}

		return navigateTo;

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
