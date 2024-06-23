package Many_Many_Unidirectional_Mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//Create table with the name of class name by the help of @Entity
//@Entity: Specifies that the class is an entity and is mapped to a database table.
@Entity
public class Stadium 
{
	
//	@Id: Specifies the primary key of an entity.
	@Id
	int stadium_id;
	
//	@Column(nullable = false): Ensures that the column cannot be null.
//	@Column(unique = true): Ensures that the values in the column are unique.
	@Column(nullable = false, unique = true)
	String stadium_name;

	// Getters and Setters
	public int getStadium_id() {
		return stadium_id;
	}

	public void setStadium_id(int stadium_id) {
		this.stadium_id = stadium_id;
	}

	public String getStadium_name() {
		return stadium_name;
	}

	public void setStadium_name(String stadium_name) {
		this.stadium_name = stadium_name;
	}
	
	
}