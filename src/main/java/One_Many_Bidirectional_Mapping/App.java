package One_Many_Bidirectional_Mapping;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//Create table with the name of class name by the help of @Entity
//@Entity: Specifies that the class is an entity and is mapped to a database table.
@Entity
public class App
{
//	@Id: Specifies the primary key of an entity.
	@Id
	int app_id;
	
//	@Column(nullable = false): Ensures that the column cannot be null.
//	@Column(unique = true): Ensures that the values in the column are unique.
	@Column(nullable = false, unique = true)
	String app_name;
	
//	@OneToMany: Defines a one-to-many relationship with the App_user entity.
	@OneToMany
	List<App_user> list;

	// Getters and Setters
	public int getApp_id() {
		return app_id;
	}

	public void setApp_id(int app_id) {
		this.app_id = app_id;
	}

	public String getApp_name() {
		return app_name;
	}

	public void setApp_name(String app_name) {
		this.app_name = app_name;
	}

	public List<App_user> getList() {
		return list;
	}

	public void setList(List<App_user> list) {
		this.list = list;
	}
	
	
}