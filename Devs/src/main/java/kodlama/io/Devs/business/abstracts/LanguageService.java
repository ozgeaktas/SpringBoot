package kodlama.io.Devs.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlama.io.Devs.business.requests.Language.CreateLanguageRequest;
import kodlama.io.Devs.business.requests.Language.DeleteLanguageRequest;
import kodlama.io.Devs.business.requests.Language.GetLanguageByIdRequest;
import kodlama.io.Devs.business.requests.Language.UpdateLanguageRequest;
import kodlama.io.Devs.business.responses.Language.GetAllLanguageResponse;
import kodlama.io.Devs.business.responses.Language.GetLanguageByIdResponse;
import kodlama.io.Devs.entities.concretes.Language;


public interface LanguageService {
	void add(CreateLanguageRequest createLanguageRequest) throws Exception;
	List<GetAllLanguageResponse> getAll();
	void delete(DeleteLanguageRequest deleteLanguageRequest);
	void update(UpdateLanguageRequest updateLanguageRequest) throws Exception;
	GetLanguageByIdResponse getById(GetLanguageByIdRequest getLanguageByIdRequest);
	boolean isValid(CreateLanguageRequest createLanguageRequest);
	

}
