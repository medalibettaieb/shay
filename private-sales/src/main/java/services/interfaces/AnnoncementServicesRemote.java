package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Annoncement;

@Remote
public interface AnnoncementServicesRemote {
	List<Annoncement> findAllAnnoncements();

	void addAnnoncement(Annoncement annoncement, Integer idUser);

	Annoncement findAnnoncementById(Integer id);

	void deleteAnnoncement(Integer id);

	void updateAnnoncement(Annoncement annoncement);
}
