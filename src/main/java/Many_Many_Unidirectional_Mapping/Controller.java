package Many_Many_Unidirectional_Mapping;

import java.util.ArrayList;
import java.util.List;
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
		
		// List to hold Stadium,Teams instances
		ArrayList<Stadium> stadium_list = new ArrayList<Stadium>();
		ArrayList<Teams> team_list = new ArrayList<Teams>();
		
		System.out.println();
		
		// Input taken for number of stadium adding
		System.out.println("Enter Number of Stadium to be Added : ");
		int stadium_num = sc.nextInt();
		
		for (int no = 0; no < stadium_num ; no ++)
		{
		    // Create Stadium instance
			Stadium stadium = new Stadium();
			
			System.out.println();
			
			// Taking Input for Stadium details
			
			System.out.println("Enter Stadium Id : ");
			int stadium_id = sc.nextInt();
			
			System.out.println("Enter Stadium Name : ");
			String stadium_name = sc.next();
			
//			Setting stadium details
			stadium.setStadium_id(stadium_id);
			stadium.setStadium_name(stadium_name);
			
//			Add stadium to stadium List
			stadium_list.add(stadium);
			
		}
		
		System.out.println();
		
		// Input taken for number of teams adding
		System.out.println("Enter Number of Teams to be Added : ");
		int team_num = sc.nextInt();
		
		for (int no = 0; no < team_num ; no ++)
		{		 
			// Create Team instance
			Teams team = new Teams();
			
			System.out.println();
			
			// Taking Input for Team details
			System.out.println("Enter Team Id : ");
			int team_id = sc.nextInt();
			
			System.out.println("Enter Team Name : ");
			String team_name = sc.next();
			
//			Setting team details
			team.setTeams_id(team_id);
			team.setTeam_name(team_name);
			team.setList(stadium_list);
			
//			Add team to team list
			team_list.add(team);
			
		}
		
		// Begin transaction, persist app and users, commit transaction
		entityTransaction.begin();
		
//		Adding all the stadiums data to the db using for each loop
		for (Stadium stadium : stadium_list)
		{
			entityManager.persist(stadium);
		}
		
//		Adding all the teams data to the db using for each loop
		for(Teams team : team_list)
		{
			entityManager.persist(team);
		}
		entityTransaction.commit();
		
		System.out.println();
		// Confirmation message
		System.out.println("Many To Many Unidirectional Mapping Established Successfully ..........");
				
		
	}
}