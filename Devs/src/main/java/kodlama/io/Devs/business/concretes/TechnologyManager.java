package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;


import kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.io.Devs.business.requests.Technology.CreateTechnologyRequest;
import kodlama.io.Devs.business.requests.Technology.DeleteTechnologyRequest;
import kodlama.io.Devs.business.requests.Technology.GetTechnologyByIdRequest;
import kodlama.io.Devs.business.requests.Technology.UpdateTechnologyRequest;
import kodlama.io.Devs.business.responses.Technology.GetAllTechnologyResponse;
import kodlama.io.Devs.business.responses.Technology.GetTechnologyByIdResponse;
import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.Devs.entities.concretes.Language;
import kodlama.io.Devs.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService {
	private TechnologyRepository technologyRepository;
	private LanguageRepository languageRepository;

	

	public TechnologyManager(TechnologyRepository technologyRepository, LanguageRepository languageRepository) {
		super();
		this.technologyRepository = technologyRepository;
		this.languageRepository = languageRepository;
	}

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception {
		Language language=new Language();
		Technology technology=new Technology();
		if(createTechnologyRequest.getName().isEmpty()) {
			throw new Exception("Please type a technology!");		
		}else if(!this.isValid(createTechnologyRequest)) {
			throw new Exception("Technology already exists!");	
		}
		else {
	        language.setId(createTechnologyRequest.getLanguageId());
			technology.setName(createTechnologyRequest.getName() );
			technology.setLanguages(language);
			this.technologyRepository.save(technology);				
		}		
		
		
	}

	@Override
	public List<GetAllTechnologyResponse> getAll() {
		List<Technology> technologies=technologyRepository.findAll();
		List<GetAllTechnologyResponse> technologiesResponse=new ArrayList<GetAllTechnologyResponse>();
		
		for(Technology technology : technologies) {
			GetAllTechnologyResponse responseItem=new GetAllTechnologyResponse();
			responseItem.setId(technology.getId());
			responseItem.setName(technology.getName());
			responseItem.setLanguageId(technology.getLanguages().getId());
			
			technologiesResponse.add(responseItem);
		}
		return technologiesResponse;
	}

	@Override
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
       List<Technology> technologies=technologyRepository.findAll();
		
		for(Technology technology:technologies) {
			if(deleteTechnologyRequest.getId()==technology.getId()) {
				technology.setId(deleteTechnologyRequest.getId());	
				this.technologyRepository.delete(technology);
			}
		}
		
	}

	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception {
		
		List<Technology> technologies=technologyRepository.findAll();
		
		for(Technology technology:technologies) {
			if(technology.getName().equalsIgnoreCase(updateTechnologyRequest.getOldName())) {
				technology.setName(updateTechnologyRequest.getNewName());
				technologyRepository.save(technology);
				break;
			}
		}
		
			
	}

	@Override
	public GetTechnologyByIdResponse getById(GetTechnologyByIdRequest getTechnologyByIdRequest) {
		List<Technology> technologies=technologyRepository.findAll();
	       GetTechnologyByIdResponse responseItem=new GetTechnologyByIdResponse();
			List<GetTechnologyByIdResponse> technologiesResponse=new ArrayList<GetTechnologyByIdResponse>();
			for(Technology technology:technologies) {			
				if(technology.getId()==getTechnologyByIdRequest.getId())
				responseItem.setName(technology.getName());
				technologiesResponse.add(responseItem);
				
			}
			return responseItem;
	}

	public boolean isValid(CreateTechnologyRequest createTechnologyRequest){
		List<Technology> technologies=technologyRepository.findAll();
		for(Technology technology : technologies) {
			if(technology.getName().equalsIgnoreCase(createTechnologyRequest.getName())) {
				return false;
			}
		}
		return true;
	}
	
	


}
