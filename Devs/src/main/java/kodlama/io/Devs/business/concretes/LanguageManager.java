package kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.entities.concretes.Language;


@Service
public class LanguageManager implements LanguageService {
	private LanguageRepository languageRepository;
	

	public LanguageManager(LanguageRepository languageRepository) {
		super();
		this.languageRepository = languageRepository;
	}

	

	@Override
	public List<Language> getAll() {
		// TODO Auto-generated method stub
		return languageRepository.getAll();
	}
	
	@Override
	public void add(Language language) throws Exception {
		  
			if(language.getName().isEmpty()) {
				throw new Exception("Please type a programming language!");		
			}else if(!this.isValid(language)) {
				throw new Exception("Programming language already exists!");	
			}
			else {
				languageRepository.add(language);					
			}		
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		 languageRepository.delete(id);
		
	}

	@Override
	public void update(Language language, int id) {
		
			languageRepository.update(language, id);
		
		
		
	}

	@Override
	public Language getById(int id) {
		// TODO Auto-generated method stub
		return languageRepository.getById(id);
	}
	
	public boolean isValid(Language language){
		for(Language language1 : getAll()) {
			if(language1.getName().equalsIgnoreCase(language.getName())) {
				return false;
			}
		}
		return true;
	}
	



	

	}
