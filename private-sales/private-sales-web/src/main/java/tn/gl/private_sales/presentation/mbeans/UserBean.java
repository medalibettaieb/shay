package tn.gl.private_sales.presentation.mbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import services.interfaces.UserServicesLocal;
import entities.Buyer;
import entities.User;

@ManagedBean
@SessionScoped
public class UserBean {
	private User user = new User();
	@EJB
	private UserServicesLocal userServicesLocal;

	public String doLogin() {

		String navigateTo = "";
		User userLoggedIn = userServicesLocal.login(user.getLogin(),
				user.getPassword());
		if (userLoggedIn instanceof Buyer) {
			user = userLoggedIn;
			navigateTo = "/buyerHome/listAnnoucement?faces-redirect=true";
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
