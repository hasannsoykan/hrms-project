package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdDao;
import kodlamaio.hrms.entities.concretes.JobAd;
import kodlamaio.hrms.entities.dtos.JobAdWithCompanyDto;

@Service
public class JobAdManager implements JobAdService{
	
	private JobAdDao jobAdDao;
	
	@Autowired
	public JobAdManager(JobAdDao jobAdDao) {
		super();
		this.jobAdDao = jobAdDao;
	}

	@Override
	public DataResult<List<JobAd>> getActiveAds() {
		return new SuccessDataResult<List<JobAd>>(this.jobAdDao.getByIsActiveTrue(), "Aktif is ilanlari listelendi.");
	}
	

	@Override
	public Result add(JobAd jobAd) {
		this.jobAdDao.save(jobAd);
		jobAd.setIsActive(true);
		return new SuccessResult("Yeni iş ilanı oluşturuldu");

	}

	@Override
	public DataResult<List<JobAd>> getByCompanyNameAndIsActiveTrue(String companyName) {
		return new SuccessDataResult<List<JobAd>>(this.jobAdDao.getByEmployer_CompanyNameAndIsActiveTrue(companyName), 
				companyName + " sirketine ait aktif is ilanlari listelenmistir.");
	}

	@Override
	public DataResult<List<JobAdWithCompanyDto>> getJobAdWithDetails() {
		return new SuccessDataResult<List<JobAdWithCompanyDto>>(this.jobAdDao.getJobAdWithDetails(), "Data listelendi.");
	}

}
