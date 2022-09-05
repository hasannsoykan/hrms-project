package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name="candidates")
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="candidate_id", referencedColumnName = "id")
public class Candidate extends User {
	
	
	@Column(name="first_name")
	@NotBlank
	@NotNull
	private String firstName;
	
	
	@Column(name="last_name")
	@NotBlank
	@NotNull
	private String lastName;
	
	@Column(name="identity_number")
	@NotBlank
	@NotNull
	private String identityNumber;
	
	@Column(name="birth_year")
	@NotBlank
	@NotNull
	private String birthYear;
	
	
	

}

