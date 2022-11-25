package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.business.requests.Language.CreateLanguageRequest;
import kodlama.io.Devs.business.requests.Language.DeleteLanguageRequest;
import kodlama.io.Devs.business.requests.Language.GetLanguageByIdRequest;
import kodlama.io.Devs.business.requests.Language.UpdateLanguageRequest;
import kodlama.io.Devs.business.responses.Language.GetAllLanguageResponse;
import kodlama.io.Devs.business.responses.Language.GetLanguageByIdResponse;
import kodlama.io.Devs.business.responses.Technology.GetAllTechnologyResponse;
import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.Devs.entities.concretes.Language;
import kodlama.io.Devs.entities.concretes.Technology;


@Service
public class LanguageManager implements LanguageService {
	private LanguageRepository languageRepository;
	
	
	
	

	public LanguageManager(LanguageRepository languageRepository) {
		super();
		this.languageRepository = languageRepository;
		
	}

	

	@Override
	public List<GetAllLanguageResponse> getAll() {
		List<Language> languages=languageRepository.findAll();
	
		
		List<GetAllLanguageResponse> languagesResponse=new ArrayList<GetAllLanguageResponse>();
		
		for(Language language : languages) {//tek tek languages ler dolaşılır
			GetAllLanguageResponse responseItem=new GetAllLanguageResponse();
			responseItem.setId(language.getId());
			responseItem.setName(language.getName());
			
			languagesResponse.add(responseItem);
		}
		return languagesResponse;
	}
	
	@Override
	public void add(CreateLanguageRequest createLanguageRequest) throws Exception {
		   Language language=new Language();
		  
			if(createLanguageRequest.getName().isEmpty()) {
				throw new Exception("Please type a programming language!");		
			}else if(!this.isValid(createLanguageRequest)) {
				throw new Exception("Programming language already exists!");	
			}
			else {
				language.setName(createLanguageRequest.getName());
				this.languageRepository.save(language);				
			}		
			
			
	}

	@Override
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		List<Language> languages=languageRepository.findAll();
		
		for(Language language:languages) {
			if(deleteLanguageRequest.getId()==language.getId()) {
				language.setId(deleteLanguageRequest.getId());	
				this.languageRepository.delete(language);
				break;
			}
		}
		
		
		
	}



	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest) throws Exception {
		 List<Language> languages=languageRepository.findAll();		  
		 for(Language language: languages) {
			 if(language.getName().equalsIgnoreCase(updateLanguageRequest.getOldName())) {
				 language.setName(updateLanguageRequest.getNewName());
				 this.languageRepository.save(language);
				 break;
			 }
		 }
		
	}



	@Override
	public GetLanguageByIdResponse getById(GetLanguageByIdRequest getLanguageByIdRequest) {
       List<Language> languages=languageRepository.findAll();//languages getLanguageByIdResponse tipine dönüştürülüyor.
       GetLanguageByIdResponse responseItem=new GetLanguageByIdResponse();
		List<GetLanguageByIdResponse> languagesResponse=new ArrayList<GetLanguageByIdResponse>();
		for(Language language:languages) {			
			if(language.getId()==getLanguageByIdRequest.getId())
			responseItem.setName(language.getName());
			languagesResponse.add(responseItem);
			
		}
		return responseItem;
	}
	
	public boolean isValid(CreateLanguageRequest createLanguageRequest){
		List<Language> languages=languageRepository.findAll();
		for(Language language1 : languages) {
			if(language1.getName().equalsIgnoreCase(createLanguageRequest.getName())) {
				return false;
			}
		}
		return true;
	}
	
	



	



	

	}
