package One_One_Bidirectional_Mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

//@Entity: Specifies that the class is an entity and is mapped to a database table.
@Entity
public class Employee
{
//	@Id: Specifies the primary key of an entity.
	@Id
	int employer_id;
	
	@Column(nullable = false)
	String employee_name;
	
//	@Column(nullable = false): Ensures that the column cannot be null.
//	@Column(unique = true): Ensures that the values in the column are unique.
	@Column(nullable = false, unique = true)
	long employee_contact;
	
//	@OneToOne: Defines a one-to-one relationship between entities. The mappedBy attribute indicates the owning side of the relationship.
	@OneToOne
	Employer employer;

	
	// Getters and Setters
	public int getEmployer_id() {
		return employer_id;
	}

	public void setEmployer_id(int employer_id) {
		this.employer_id = employer_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public long getEmployee_contact() {
		return employee_contact;
	}

	public void setEmployee_contact(long employee_contact) {
		this.employee_contact = employee_contact;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	
	
	
}