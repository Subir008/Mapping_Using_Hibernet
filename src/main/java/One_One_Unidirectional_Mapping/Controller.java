package One_One_Unidirectional_Mapping;

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
		
	    // Create instance for Teacher and Student
		Teacher teacher = new Teacher();
		Student student = new Student();
		Scanner sc = new Scanner(System.in);
		
		// Taking Input for Teacher details
		System.out.println("Enter the Teacher Id : ");
		int teacher_id = sc.nextInt();
		
		System.out.println("Enter The Teacher Name : ");
		String teacher_name = sc.next();
		
		 // Set Teacher details
		teacher.setTeacher_id(teacher_id);
		teacher.setTeacher_name(teacher_name);
		
		// Taking Input for Student details
		System.out.println("Enter The Student Id : ");
		int student_id = sc.nextInt();
		
		System.out.println("Enter The Student Name : ");
		String student_name = sc.next();
		
		 // Set Student details
		student.setStudent_id(student_id);
		student.setStudent_name(student_name);
		
//		Storing Teacher details in Student Table
		student.setTeacher(teacher); 

		// Begin transaction
		entityTransaction.begin();
		
//		Saving student and teacher details 
		entityManager.persist(teacher);
		entityManager.persist(student);
		
//		commit transaction
		entityTransaction.commit();
		
	     // Confirmation message
		System.out.println("One To One Unidirectional Mapping Has Been Established .........");
		
	}
}