package tn.esprit.gl2.travel_advice.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import tn.esprit.gl2.travel_advice.persistence.Comment;
import tn.esprit.gl2.travel_advice.services.CommentServicesLocal;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class CommentServicesBean implements Serializable {
	private List<Comment> comments = new ArrayList<>();
	@EJB
	private CommentServicesLocal commentServicesLocal;
	@ManagedProperty(value = "#{loginBean}")
	private LoginBean loginBean;
	private String text;

	public String doAddComment() {
		commentServicesLocal.addComment(loginBean.getUser().getId(), loginBean.getIdT(), text);
		comments = commentServicesLocal.findAllCommentsByTouristicPlaceId(loginBean.getIdT());
		return "/pages/listComment?faces-redirect=true";
	}

	public String doRefrech() {
		comments = commentServicesLocal.findAllCommentsByTouristicPlaceId(loginBean.getIdT());
		return "";
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}
