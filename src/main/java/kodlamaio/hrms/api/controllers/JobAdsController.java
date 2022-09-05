package kodlamaio.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.JobAd;
import kodlamaio.hrms.entities.dtos.JobAdWithCompanyDto;

@RestController
@RequestMapping("/api/jobAds")
public class JobAdsController {
	
	private JobAdService jobAdService;

	@Autowired
	public JobAdsController(JobAdService jobAdService) {
		super();
		this.jobAdService = jobAdService;
	}
	
	@GetMapping("/getActiveAds")
	public 	DataResult<List<JobAd>> getActiveAds(){
		return this.jobAdService.getActiveAds();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobAd jobAd) {
		return ResponseEntity.ok(this.jobAdService.add(jobAd));
	}
	
	@GetMapping("/getByCompanyNameAndIsActiveTrue")
	public DataResult<List<JobAd>> getByCompanyNameAndIsActiveTrue(@RequestParam String companyName){
		return this.jobAdService.getByCompanyNameAndIsActiveTrue(companyName);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String, String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Dogrulama hatalari");
		return errors;
	}
	
	@GetMapping("/getJobAdWithDetails")
	public DataResult<List<JobAdWithCompanyDto>> getJobAdWithDetails(){
		return this.jobAdService.getJobAdWithDetails();
	}
	
	
	
	

}
