package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.Candidate;

@Repository
public interface CandidateDao extends JpaRepository<Candidate, Integer> {
	
	//@Query(value="SELECT candidate FROM Candidate candidate WHERE candidate.email = ?1")
	Candidate findByEmail(String email);
	
	//@Query(value="SELECT candidate FROM Candidate candidate WHERE candidate.identityNumber = ?1")
	Candidate findByIdentityNumber(String identityNumber);

}
