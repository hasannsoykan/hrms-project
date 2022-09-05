package kodlamaio.hrms.core.adapters;

import java.rmi.RemoteException;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface CheckService {
	
	public boolean checkIfRealPerson(Candidate candidate)throws NumberFormatException, RemoteException;

}
