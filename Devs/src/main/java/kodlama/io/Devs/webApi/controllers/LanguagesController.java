package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.LanguageService;
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
	public List<Language> getAll(){
		return languageService.getAll();
	}
	
	@GetMapping("/getbyid")
	public Language getById(int id) {
		return languageService.getById(id);
	}
	
	@PostMapping("/add")
	public void add(Language language) {
		languageService.add(language);
	}
	
	@PutMapping("/update")
	public void update(Language language, String name) {
		languageService.update(language, name);
	}
	
	@DeleteMapping("/delete")
	public void delete(Language language) {
		languageService.delete(language);
		
	}
	

}
