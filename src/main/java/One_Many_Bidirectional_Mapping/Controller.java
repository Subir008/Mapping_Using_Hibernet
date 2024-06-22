package One_Many_Bidirectional_Mapping;

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
        // Create EntityManagerFactory and EntityManager
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Scanner sc = new Scanner(System.in);
		
	    // Create App instance
		App app = new App();
		
		// List to hold App_user instances
		ArrayList<App_user> list = new ArrayList<App_user>();
		
		// Taking Input for App details
		System.out.println();
		System.out.println("Enter App Id : ");
		int app_id = sc.nextInt();
		
		System.out.println("Enter App Name : ");
		String app_name = sc.next();
		
		 // Set App details
		app.setApp_id(app_id);
		app.setApp_name(app_name);
		
		System.out.println();
	     // Input number of users to add for the App
		System.out.println("Enter Number of User Want to Add for the App " + app_name);
		int user_num = sc.nextInt();
		
		  // Loop to input user details and add to list
		for (int no = 0 ; no < user_num ; no++)
		{
			App_user user = new App_user();
			
			System.out.println();
			
			// Taking Input for App User details
			System.out.println("Enter User Id : ");
			int user_id = sc.nextInt();
			
			System.out.println("Enter User Name : ");
			String user_name = sc.next();
			
			System.out.println("Enter User Contact : ");
			long user_contact = sc.nextLong();
			
			
			 // Set user details
			user.setUser_id(user_id);
			user.setUser_name(user_name);
			user.setUser_contact(user_contact);
			user.setApp(app);
			
			// Add user to list
			list.add(user);
			
		}
		
		 // Set list of users in app
		app.setList(list);

		
		// Begin transaction, persist app and users, commit transaction
		entityTransaction.begin();
		entityManager.persist(app);
		for (App_user fb_user : list)
		{
			entityManager.persist(fb_user);
		}
		entityTransaction.commit();
		
		System.out.println();
		
	     // Confirmation message
		System.out.println("One To Many Bidirectional Mapping Established Successfully ..........");
		
	}
}