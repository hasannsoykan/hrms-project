package kodlamaio.hrms.entities.concretes;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_ads")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class JobAd {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "id")
	private int id;
	
	@Column(name = "description")
	@NotBlank
	@NotNull
	private String description;
	
	@Column(name = "open_positions")
	@NotNull
	private int openPositionCount;
	
	@Column(name = "salary_min")
	private int minSalary;
	
	@Column(name = "salary_max")
	private int maxSalary;
	
	@Column(name = "release_date")
	private LocalDateTime releaseDate = LocalDateTime.now();
	
	@Column(name = "application_deadline")
	private Date applicationDeadline;
	
	@Column(name = "is_active")
	private Boolean isActive;
	
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;

}
