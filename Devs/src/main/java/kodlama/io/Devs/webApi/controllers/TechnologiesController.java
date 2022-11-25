package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.io.Devs.business.requests.Technology.CreateTechnologyRequest;
import kodlama.io.Devs.business.requests.Technology.DeleteTechnologyRequest;
import kodlama.io.Devs.business.requests.Technology.GetTechnologyByIdRequest;
import kodlama.io.Devs.business.requests.Technology.UpdateTechnologyRequest;
import kodlama.io.Devs.business.responses.Technology.GetAllTechnologyResponse;
import kodlama.io.Devs.business.responses.Technology.GetTechnologyByIdResponse;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {
	private TechnologyService technologyService;

	public TechnologiesController(TechnologyService technologyService) {
		super();
		this.technologyService = technologyService;
	}
	
	@GetMapping("/getall")
	public List<GetAllTechnologyResponse> getAll(){
		return technologyService.getAll();
	}
	
	@PostMapping("/add")
	public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception {
		technologyService.add(createTechnologyRequest);
	}
	@GetMapping("/getbyid")
	public GetTechnologyByIdResponse getById(GetTechnologyByIdRequest getTechnologyByIdRequest) {
		return technologyService.getById(getTechnologyByIdRequest);
	}
	
	@PutMapping("/update")
	public void update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception {
		technologyService.update(updateTechnologyRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		technologyService.delete(deleteTechnologyRequest);
		
	}

}
