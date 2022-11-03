package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.entities.concretes.Language;

public interface LanguageService {
	void add(Language language) throws Exception;
	List<Language> getAll();
	void delete(int id);
	void update(Language language,int id);
	Language getById(int id);
	boolean isValid(Language language);
	

}
