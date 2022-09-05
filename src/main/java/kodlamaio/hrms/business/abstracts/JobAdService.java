package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAd;
import kodlamaio.hrms.entities.dtos.JobAdWithCompanyDto;

public interface JobAdService {

	DataResult<List<JobAd>> getActiveAds();
	Result add(JobAd jobAd);
	
	DataResult<List<JobAd>> getByCompanyNameAndIsActiveTrue(String companyName);
	DataResult<List<JobAdWithCompanyDto>> getJobAdWithDetails();
	
}
