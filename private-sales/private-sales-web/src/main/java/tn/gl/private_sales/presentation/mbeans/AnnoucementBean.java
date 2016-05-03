package tn.gl.private_sales.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import services.interfaces.AnnoncementServicesLocal;
import services.interfaces.CommentServicesLocal;
import entities.Annoncement;
import entities.Commentaire;

@ManagedBean
@ViewScoped
public class AnnoucementBean {
	private List<Annoncement> annoncements;
	private Annoncement annoncementSelected = new Annoncement();
	private Boolean displayPanel = false;
	private Boolean displayPanel2 = false;
	@EJB
	private AnnoncementServicesLocal annoncementServicesLocal;
	@EJB
	private CommentServicesLocal commentServicesLocal;
	private String textOfCommentaire;
	@ManagedProperty(value = "#{userBean}")
	private UserBean userBean;

	private List<Commentaire> commentaires = new ArrayList<>();

	public void selectAnnoucement(Annoncement annoncement) {
		displayPanel = true;
		annoncementSelected = annoncement;
	}

	public void deleteCommentaire(Commentaire commentaire) {
		commentServicesLocal.deleteCommentaireOfAUser(
				annoncementSelected.getId(), userBean.getUser().getId());
	}

	public void viewCommentaires(Annoncement annoncement) {
		annoncementSelected = annoncement;
		displayPanel2 = true;
		commentaires = commentServicesLocal
				.findAllCommentairesByAnnoncementId(annoncementSelected.getId());
	}

	public void doAddCommentaire() {
		commentServicesLocal.addCommentaireOnAnnouncement(textOfCommentaire,
				annoncementSelected.getId(), userBean.getUser().getId());
	}

	public List<Annoncement> getAnnoncements() {
		annoncements = annoncementServicesLocal.findAllAnnoncements();
		return annoncements;
	}

	public void setAnnoncements(List<Annoncement> annoncements) {
		this.annoncements = annoncements;
	}

	public Annoncement getAnnoncementSelected() {
		return annoncementSelected;
	}

	public void setAnnoncementSelected(Annoncement annoncementSelected) {
		this.annoncementSelected = annoncementSelected;
	}

	public Boolean getDisplayPanel() {
		return displayPanel;
	}

	public void setDisplayPanel(Boolean displayPanel) {
		this.displayPanel = displayPanel;
	}

	public String getTextOfCommentaire() {
		return textOfCommentaire;
	}

	public void setTextOfCommentaire(String textOfCommentaire) {
		this.textOfCommentaire = textOfCommentaire;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Boolean getDisplayPanel2() {
		return displayPanel2;
	}

	public void setDisplayPanel2(Boolean displayPanel2) {
		this.displayPanel2 = displayPanel2;
	}

}
