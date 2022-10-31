package kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import kodlama.io.Devs.entities.concretes.Language;

public interface LanguageRepository {
	void add(Language language);
	List<Language> getAll();
	void delete(Language language);
	void update(Language language,String name);
	Language getById(int id);
	

}
