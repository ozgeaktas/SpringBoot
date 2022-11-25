package kodlama.io.Devs.business.abstracts;

import java.util.List;



import kodlama.io.Devs.business.requests.Technology.CreateTechnologyRequest;
import kodlama.io.Devs.business.requests.Technology.DeleteTechnologyRequest;
import kodlama.io.Devs.business.requests.Technology.GetTechnologyByIdRequest;
import kodlama.io.Devs.business.requests.Technology.UpdateTechnologyRequest;
import kodlama.io.Devs.business.responses.Technology.GetAllTechnologyResponse;
import kodlama.io.Devs.business.responses.Technology.GetTechnologyByIdResponse;


public interface TechnologyService {
	void add(CreateTechnologyRequest createTechnologyRequest) throws Exception;
	List<GetAllTechnologyResponse> getAll();
	void delete(DeleteTechnologyRequest deleteTechnologyRequest);
	void update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception;
	GetTechnologyByIdResponse getById(GetTechnologyByIdRequest getTechnologyByIdRequest);
	boolean isValid(CreateTechnologyRequest createTechnologyRequest);
	

}
