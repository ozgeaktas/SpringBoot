package kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.entities.concretes.Language;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {
	List<Language> languages;
	
	

	public InMemoryLanguageRepository() {
		languages=new ArrayList<Language>();
		languages.add(new Language(1,"C#"));
		languages.add(new Language(2,"Java"));
		languages.add(new Language(3,".NET Core"));
		languages.add(new Language(4,"C"));
		languages.add(new Language(5,"Python"));
	}



	@Override
	public void add(Language language) {
		languages.add(language);
		
	}



	@Override
	public List<Language> getAll() {
		return languages;
	}



	@Override
	public void delete(int id) {
		for(Language language1: languages) {
			if(language1.getId()==id) {
				languages.remove(id);
			}
		}
		
		
		
	}



	@Override
	public void update(Language language, int id) {
		 Language language1 = getById(language.getId());
		 language1.setName(language.getName());
		
				
	}

	@Override
	public Language getById(int id) {
		for(Language language1: languages) {
			if(language1.getId()==id) {
				return language1;
			}
		}
		return null;
		
		
	}

	
}
