package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.JobPosition;

@Repository
public interface JobPositionDao extends JpaRepository<JobPosition, Integer>{

	
	//@Query(value = "Select jobPosition From JobPosition jobPosition Where jobPosition.title = ?1")
	JobPosition findByTitle(String title);
	
}
