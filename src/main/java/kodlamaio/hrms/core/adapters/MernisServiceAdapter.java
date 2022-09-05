package kodlamaio.hrms.core.adapters;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements CheckService {

	@Override
	public boolean checkIfRealPerson(Candidate candidate) throws NumberFormatException, RemoteException {

		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
		return kpsPublicSoapProxy.TCKimlikNoDogrula(
				(Long.parseLong(candidate.getIdentityNumber())),
				candidate.getFirstName().toUpperCase(),
				candidate.getLastName().toUpperCase(),
				Integer.parseInt(candidate.getBirthYear()));
	}

	
	
}
