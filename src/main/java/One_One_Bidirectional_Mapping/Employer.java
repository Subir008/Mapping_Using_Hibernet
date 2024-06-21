package One_One_Bidirectional_Mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

//@Entity: Specifies that the class is an entity and is mapped to a database table.
@Entity
public class Employer 
{
//	@Id: Specifies the primary key of an entity.
	@Id
	int employer_id;
	
	@Column(nullable = false)
	String employer_name;
	
//	@Column(nullable = false): Ensures that the column cannot be null.
//	@Column(unique = true): Ensures that the values in the column are unique.
	@Column(nullable = false, unique = true)
	long employer_contact;
	
//	@OneToOne: Defines a one-to-one relationship with the Employee entity.
	@OneToOne
	Employee employee;

	
	// Getters and Setters
	public int getEmployer_id() {
		return employer_id;
	}

	public void setEmployer_id(int employer_id) {
		this.employer_id = employer_id;
	}

	public String getEmployer_name() {
		return employer_name;
	}

	public void setEmployer_name(String employer_name) {
		this.employer_name = employer_name;
	}

	public long getEmployer_contact() {
		return employer_contact;
	}

	public void setEmployer_contact(long employer_contact) {
		this.employer_contact = employer_contact;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
}