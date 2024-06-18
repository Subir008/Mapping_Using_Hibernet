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
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Teacher teacher = new Teacher();
		Student student = new Student();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Teacher Id : ");
		int teacher_id = sc.nextInt();
		
		System.out.println("Enter The Teacher Name : ");
		String teacher_name = sc.next();
		
		teacher.setTeacher_id(teacher_id);
		teacher.setTeacher_name(teacher_name);
		
		System.out.println("Enter The Student Id : ");
		int student_id = sc.nextInt();
		
		System.out.println("Enter The Student Name : ");
		String student_name = sc.next();
		
		student.setStudent_id(student_id);
		student.setStudent_name(student_name);
		
//		Storing Teacher details in Student Table
		student.setTeacher(teacher); 

		entityTransaction.begin();
		entityManager.persist(teacher);
		entityManager.persist(student);
		entityTransaction.commit();
		
		System.out.println("One To One Unidirectional Mapping Has Been Established .........");
		
	}
}