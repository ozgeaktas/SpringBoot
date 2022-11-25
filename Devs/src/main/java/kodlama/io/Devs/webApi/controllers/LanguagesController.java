package kodlama.io.Devs.webApi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.business.requests.Language.CreateLanguageRequest;
import kodlama.io.Devs.business.requests.Language.DeleteLanguageRequest;
import kodlama.io.Devs.business.requests.Language.GetLanguageByIdRequest;
import kodlama.io.Devs.business.requests.Language.UpdateLanguageRequest;
import kodlama.io.Devs.business.responses.Language.GetAllLanguageResponse;
import kodlama.io.Devs.business.responses.Language.GetLanguageByIdResponse;
import kodlama.io.Devs.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	private LanguageService languageService;

	public LanguagesController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	@GetMapping("/getall")
	public List<GetAllLanguageResponse> getAll(){
		return languageService.getAll();
	}
	
	@GetMapping("/getbyid")
	public GetLanguageByIdResponse getById(GetLanguageByIdRequest getLanguageByIdRequest) {
		return languageService.getById(getLanguageByIdRequest);
	}
	
	@PostMapping("/add")
	public void add(CreateLanguageRequest createLanguageRequest) throws Exception {
		languageService.add(createLanguageRequest);
	}
	
	@PutMapping("/update")
	public void update(UpdateLanguageRequest updateLanguageRequest) throws Exception {
		languageService.update(updateLanguageRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		languageService.delete(deleteLanguageRequest);
		
	}
	

}
