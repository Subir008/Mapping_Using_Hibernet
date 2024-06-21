package One_Many_Unidirectional_Mapping;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//@Entity: Specifies that the class is an entity and is mapped to a database table.
@Entity
public class Provider 
{
	//@Id: Specifies the primary key of an entity.
	@Id
	int provider_id;
	
//	@Column(nullable = false): Ensures that the column cannot be null.
//	@Column(unique = true): Ensures that the values in the column are unique.
	@Column(nullable = false, unique = true)
	String provider_name;
	
//	@OneToMany: Defines a one-to-many relationship with the User entity.
	@OneToMany
	List<User> list;

	// Getters and Setters
	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	public int getProvider_id() {
		return provider_id;
	}

	public void setProvider_id(int provider_id) {
		this.provider_id = provider_id;
	}

	public String getProvider_name() {
		return provider_name;
	}

	public void setProvider_name(String provider_name) {
		this.provider_name = provider_name;
	}

}