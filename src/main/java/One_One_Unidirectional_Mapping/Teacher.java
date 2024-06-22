package One_One_Unidirectional_Mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//Create table with the name of class name by the help of @Entity
//@Entity: Specifies that the class is an entity and is mapped to a database table.
@Entity
public class Teacher 
{
//	@Id: Specifies the primary key of an entity.
	@Id
	int teacher_id;

//	@Column(nullable = false): Ensures that the column cannot be null.
//	@Column(unique = true): Ensures that the values in the column are unique.
	@Column(nullable = false)
	String teacher_name;

	// Getters and Setters
	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	
	
}