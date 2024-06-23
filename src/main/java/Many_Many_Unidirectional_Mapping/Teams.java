package Many_Many_Unidirectional_Mapping;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

//Create table with the name of class name by the help of @Entity
//@Entity: Specifies that the class is an entity and is mapped to a database table.
@Entity
public class Teams
{

//	@Id: Specifies the primary key of an entity.
	@Id
	int teams_id;
	
//	@Column(nullable = false): Ensures that the column cannot be null.
//	@Column(unique = true): Ensures that the values in the column are unique.
	@Column(unique = true, nullable = false)
	String team_name ;
	
//	The Teams entity has a many-to-many relationship with the Stadium entity.
	@ManyToMany
	List<Stadium> list;

	public int getTeams_id() {
		return teams_id;
	}

	public void setTeams_id(int teams_id) {
		this.teams_id = teams_id;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public List<Stadium> getList() {
		return list;
	}

	public void setList(List<Stadium> list) {
		this.list = list;
	}
	
	
}