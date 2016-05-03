package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Annoncement;

@Local
public interface AnnoncementServicesLocal {
	List<Annoncement> findAllAnnoncements();

	void addAnnoncement(Annoncement annoncement, Integer idUser);

	Annoncement findAnnoncementById(Integer id);

	void deleteAnnoncement(Integer id);

	void updateAnnoncement(Annoncement annoncement);
}
