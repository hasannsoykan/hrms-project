package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{
	
	//@Query(value = "Select employer From Employer employer Where employer.email = ?1")
	Employer findByEmail(String email);

}
