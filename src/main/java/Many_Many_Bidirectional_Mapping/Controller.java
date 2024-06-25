package Many_Many_Bidirectional_Mapping;

import java.util.ArrayList;
import java.util.Iterator;
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
		ArrayList<Football_Team> team_list = new ArrayList<Football_Team>();
		ArrayList<Football_Stadium> stadium_list = new ArrayList<Football_Stadium>();
		
		System.out.println();
		// Input taken from user for number of teams adding
		System.out.println("Enter Number of Teams Want to be Add : ");
		int team_num = sc .nextInt();
		
		for (int no = 0 ; no < team_num ; no++)
		{
			
			// Create Team instance
			Football_Team football_Team = new Football_Team();
			
			System.out.println();
			
			// Taking Input for Team details
			System.out.println("Enter Team Id : ");
			int team_id = sc.nextInt();
			
			System.out.println("Enter Team Name : ");
			String team_name = sc.next();
			
//			Setting team details
			football_Team.setTeam_id(team_id);
			football_Team.setTeam_name(team_name);
			
			football_Team.setList(stadium_list);
			
//			Add team to team list
			team_list.add(football_Team);
			
		}
		
		System.out.println();
		
		// Input taken from user for number of stadium adding
		System.out.println("Enter Number of Stadiums Want to be Add : ");
		int stadium_num = sc .nextInt();
		
		for (int no = 0 ; no < stadium_num ; no++)
		{
			
		    // Create Stadium instance
			Football_Stadium football_Stadium = new Football_Stadium();
			
			System.out.println();
			
			// Taking Input for Stadium details
			System.out.println("Enter Stadium Id : ");
			int stadium_id = sc.nextInt();
			
			System.out.println("Enter Stadium Name : ");
			String stadium_name = sc.next();
			
//			Setting stadium details
			football_Stadium.setStadium_id(stadium_id);
			football_Stadium.setStadium_name(stadium_name);
			
			football_Stadium.setList(team_list);
			
//			Add stadium to stadium List
			stadium_list.add(football_Stadium);
			
		}
		
		// Begin transaction, persist app and users, commit transaction
		entityTransaction.begin();
		
//		Adding all the stadiums data to the db using for each loop
		for(Football_Stadium football_Stadium : stadium_list)
		{
			entityManager.persist(football_Stadium);
		}
		
//		Adding all the teams data to the db using for each loop
		for(Football_Team football_Team : team_list)
		{
			entityManager.persist(football_Team);
		}
		
		entityTransaction.commit();
		
		System.out.println();
		// Confirmation message
		System.out.println("Many To Many Biidirectional Mapping Established Successfully ..........");
		
		
	}
}
