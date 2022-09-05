package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.verifications.abstracts.EmailVerificationService;
import kodlamaio.hrms.core.verifications.abstracts.HrmsVerificationService;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private EmailVerificationService emailVerificationService;
	private HrmsVerificationService hrmsVerificationService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailVerificationService emailVerificationService,
			HrmsVerificationService hrmsVerificationService) {
		super();
		this.employerDao = employerDao;
		this.emailVerificationService = emailVerificationService;
		this.hrmsVerificationService = hrmsVerificationService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Sirketler listelendi.");
	}
	
	
	public Result isEmailUsed(String email) {
		if(this.employerDao.findByEmail(email) == null) {
			return new SuccessResult("");
		} else {
			return new ErrorResult("Bu email ile daha önce kayit yapilmistir.");
		}
	}

	@Override
	public Result add(Employer employer) {
		if(isEmailUsed(employer.getEmail()).isSuccess()) {
			this.employerDao.save(employer);
			return new SuccessResult(this.emailVerificationService.verifyAccount(employer.getEmail()).getMessage() 
					+ this.hrmsVerificationService.verifyAccount().getMessage() + "Is veren basariyla eklendi: " 
					+ employer.getCompanyName());
		} else {
			return new ErrorResult(isEmailUsed(employer.getEmail()).getMessage());
		}
	}
	
	

}
