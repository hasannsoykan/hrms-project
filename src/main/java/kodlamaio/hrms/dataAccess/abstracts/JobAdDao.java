package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAd;
import kodlamaio.hrms.entities.dtos.JobAdWithCompanyDto;

public interface JobAdDao extends JpaRepository<JobAd, Integer>{
	
	List<JobAd> getByIsActiveTrue();
	List<JobAd> getByEmployer_CompanyNameAndIsActiveTrue(String companyName);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdWithCompanyDto(e.companyName, j.openPositionCount, j.releaseDate, j.applicationDeadline) From Employer e Inner Join e.jobAds j")
	List<JobAdWithCompanyDto> getJobAdWithDetails();

}
