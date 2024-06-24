package Many_Many_Bidirectional_Mapping;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

//Create table with the name of class name by the help of @Entity
//@Entity: Specifies that the class is an entity and is mapped to a database table.
@Entity
public class Football_Team 
{

//	@Id: Specifies the primary key of an entity.
	@Id
	int team_id;
	
//	@Column(nullable = false): Ensures that the column cannot be null.
//	@Column(unique = true): Ensures that the values in the column are unique.
	@Column(nullable = false, unique = true)
	String team_name;
	
//	The Football_Team entity has a many-to-many relationship with the Football_Stadium entity.
	@ManyToMany
	List<Football_Stadium> list ;

	// Getters and Setters
	public int getTeam_id() {
		return team_id;
	}

	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public List<Football_Stadium> getList() {
		return list;
	}

	public void setList(List<Football_Stadium> list) {
		this.list = list;
	}
	
	
	
	
}
