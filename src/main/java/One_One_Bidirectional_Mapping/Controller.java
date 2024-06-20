package One_One_Bidirectional_Mapping;

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
		EntityManager entityManager	= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Employee employee = new Employee();
		Employer employer = new Employer();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee Id : ");
		int employee_id = sc.nextInt();
		
		System.out.println("Enter Employee Name : ");
		String employee_name = sc.next();
		
		System.out.println("Enter Employee Contact : ");
		long employee_contact = sc.nextLong();
		
		System.out.println("Enter Employer Id : ");
		int employer_id = sc.nextInt();
		
		System.out.println("Enter Employer Name : ");
		String employer_name = sc.next();
		
		System.out.println("Enter Employer Contact");
		long employer_contact = sc.nextLong();
		
		employee.setEmployer_id(employer_id);
		employee.setEmployee_name(employee_name);
		employee.setEmployee_contact(employee_contact);
		
		employer.setEmployer_id(employer_id);
		employer.setEmployer_name(employer_name);
		employer.setEmployer_contact(employer_contact);
		
//		All Employer Information Has Been Stored inside Employee
		employee.setEmployer(employer);
		
//		All Employee Information Has Been Stored inside Employer		
		employer.setEmployee(employee);
		
		entityTransaction.begin();
		entityManager.persist(employee);
		entityManager.persist(employer);
		entityTransaction.commit();
		
		System.out.println();
		System.out.println("One To One Bidirectional Mapping Has Been Completed Successfully ..........");
		
		
	}
}