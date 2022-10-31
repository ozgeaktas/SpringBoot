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
	public void add(Language language) {
		if(language.getName().isEmpty()) {
			System.out.println("isim alanı boş bırakılamaz.");
			
		}else {
			languageRepository.add(language);
		}
		
		
	}

	@Override
	public List<Language> getAll() {
		// TODO Auto-generated method stub
		return languageRepository.getAll();
	}

	@Override
	public void delete(Language language) {
		// TODO Auto-generated method stub
		 languageRepository.delete(language);
		
	}

	@Override
	public void update(Language language, String name) {
		if(language.getName().equals(name)) {
			System.out.println("İsim tekrar edemez.");
		}else {
			languageRepository.update(language, name);
		}
		
		
	}

	@Override
	public Language getById(int id) {
		// TODO Auto-generated method stub
		return languageRepository.getById(id);
	}

}
