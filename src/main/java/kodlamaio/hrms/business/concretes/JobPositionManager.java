package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;


@Service
public class JobPositionManager implements JobPositionService{
	
	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		this.jobPositionDao = jobPositionDao;
	}

	
	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), "Is pozisyonlari listelendi.");
	}
	
	public Result isJobPositionExist(String jobTitle) {
		if(this.jobPositionDao.findByTitle(jobTitle) == null) {
			return new SuccessResult();
		}else {
			return new ErrorResult();
		}
	}

	@Override
	public Result add(JobPosition position) {
		if(isJobPositionExist(position.getTitle()).isSuccess()) {
			this.jobPositionDao.save(position);
			return new SuccessResult("Pozisyon basariyla eklendi: " + position.getTitle());
		}else {
			return new ErrorResult("Bu pozisyon daha once eklenmistir: " + position.getTitle());
		}
	}

}
