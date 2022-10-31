package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.entities.concretes.Language;

public interface LanguageService {
	void add(Language language);
	List<Language> getAll();
	void delete(Language language);
	void update(Language language,String name);
	Language getById(int id);

}
