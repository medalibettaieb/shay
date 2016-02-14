package tests;

import java.util.List;

import delegate.CommentaireDelegate;
import entities.Commentaire;

public class TestFindAllCommentaireByAnnoncementId {

	public static void main(String[] args) {
		List<Commentaire> commentaires = CommentaireDelegate.doFindAllCommentairesByAnnoncementId(1);
		System.out.println(commentaires.size());

	}

}
