package One_One_Bidirectional_Mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Employee
{
	@Id
	int employer_id;
	
	@Column(nullable = false)
	String employee_name;
	
	@Column(nullable = false, unique = true)
	long employee_contact;
	
	@OneToOne
	Employer employer;

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