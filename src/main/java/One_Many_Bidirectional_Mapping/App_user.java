package One_Many_Bidirectional_Mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//Create table with the name of class name by the help of @Entity
//@Entity: Specifies that the class is an entity and is mapped to a database table.
@Entity
public class App_user
{
	
//	@Id: Specifies the primary key of an entity.
	@Id
	int user_id;
	
	@Column(nullable = false)
	String user_name;
	
//	@Column(nullable = false): Ensures that the column cannot be null.
//	@Column(unique = true): Ensures that the values in the column are unique.
	@Column(nullable = false, unique = true)
	long user_contact;
	
//	@ManyToOne: Defines a many-to-one relationship with the App entity.
	@ManyToOne
	App app;
	
	// Getters and Setters

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public long getUser_contact() {
		return user_contact;
	}

	public void setUser_contact(long user_contact) {
		this.user_contact = user_contact;
	}

	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}

	
	
}