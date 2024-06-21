package One_Many_Unidirectional_Mapping;

import java.util.ArrayList;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Controller
{
	public static void main(String[] args) 
	{
		// Initialize EntityManager and EntityTransaction
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		// Initialize Scanner
		Scanner sc = new Scanner(System.in);
		
		// Create list to hold users
		ArrayList<User> list = new ArrayList<User>();
		
	    // Create provider instance
		Provider provider = new Provider();
		
		// Get provider details
		System.out.println("Enter Provider Id : ");
		int provider_id = sc.nextInt();
		
		System.out.println("Enter Provider Name : ");
		String provider_name = sc.next();
		
		// Taking the number of users to be added from User
		System.out.println("Enter number of user want to add for the Provider " + provider_name );
		int user_num = sc.nextInt();
		
        // Loop to add users
		for(int no = 0 ; no < user_num ; no++)
		{
			// Create a new User instance for each user for every iteration
			User user = new User();
			
			System.out.println("Enter User Id : ");
			int user_id = sc.nextInt();
			
			System.out.println("Enter User Name : ");
			String user_name = sc.next();
			
			System.out.println("Enter User Contact");
			long user_contact = sc.nextLong();
			
			// Set user details
			user.setUser_id(user_id);
			user.setUser_name(user_name);
			user.setUser_contact(user_contact);
			
			// Add all the user to list
			list.add(user);
			
		}
		
		// Set provider details
		provider.setProvider_id(provider_id);
		provider.setProvider_name(provider_name);
		provider.setList(list);

		
		entityTransaction.begin();
		// Persist entities
		for (User user : list)
		{
	         entityManager.persist(user);
		}
		entityManager.persist(provider);
		entityTransaction.commit();
		
		System.out.println();
		System.out.println("One To Many Unidirectional Mapping Established Successfully ...........");
	}
}