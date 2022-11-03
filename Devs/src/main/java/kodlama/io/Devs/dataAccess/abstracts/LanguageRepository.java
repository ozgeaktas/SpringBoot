package kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import kodlama.io.Devs.entities.concretes.Language;

public interface LanguageRepository {
	void add(Language language);
	List<Language> getAll();
	void delete(int id);
	void update(Language language,int id);
	Language getById(int id);
	

}
