package kodlamaio.hrms.core.verifications.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.verifications.abstracts.HrmsVerificationService;

@Service
public class HrmsVerificationManager implements HrmsVerificationService {

	@Override
	public Result verifyAccount() {
		return new SuccessResult("Hesap onaylandi.");
	}

}
