package com.mycode.cruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.mycode.cruddemo.dao.StudentDAO;
import com.mycode.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		
		return runner -> {
//			createStudent(studentDAO);
			
			createMultipleStudents(studentDAO);
			
//			readStudent(studentDAO);
			
//			queryForStudents(studentDAO);
			
//			queryForStudentByLastName(studentDAO);
			
//			updateStudent(studentDAO);
			
//			updateStudentWithQuery(studentDAO);
			
//			deleteStudent(studentDAO);
			
//			deleteAllStudents(studentDAO);
		};
	}

	
	private void deleteAllStudents(StudentDAO studentDAO) {
		
		System.out.println("Deleting all the students now... Remember - This was your choice.");
		
		studentDAO.deleteAll();
		
		System.out.println("Deleted.. Happy coding!!🎉");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		
		int Id = 3;
		
		Student getStudent =  studentDAO.findById(Id);
		
		System.out.println(getStudent);
		
		studentDAO.deleteStudent(Id);
	}

	private void updateStudentWithQuery(StudentDAO studentDAO) {

		//Updating student
		studentDAO.updateWithQuery();
		
		//Getting student by lastname 'Test'
		List<Student> studentList = studentDAO.findByLastname("Test");
		
//		Displaying the student that we have updated ;
		System.out.println(studentList);
	}

	private void updateStudent(StudentDAO studentDAO) {
	
		//retrieve the student to be updated
		List<Student> key = studentDAO.findByLastname("Doe");
		
		
		//set last name to "Tester
		for(Student oneStudent: key) {
			oneStudent.setLastName("Test");
		}
		
		
		//update the student
		for(Student oneStudent: key) {
			studentDAO.updateStudent(oneStudent);
		}
		
		
		//display the updated student
		System.out.println(key);
		
		
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		
		List<Student> resultList = studentDAO.findByLastname("Kolte");
		
		for(Student tempStudent: resultList) {
			System.out.println(tempStudent);
		}
		
	}

	private void queryForStudents(StudentDAO studentDAO) {
		
		List<Student> result = studentDAO.findAll();
		
		for(Student tempStudent: result) {
			System.out.println(tempStudent);
		}
		
	}

	private void readStudent(StudentDAO studentDAO) {
		
		//create a student object
		
		System.out.println("Creating student...");
		Student tempStudent = new Student("John", "Doe", "john@gmail.com");
		
		//save the student
		
		System.out.println("Saving student...");
		studentDAO.save(tempStudent);
		
		//display id of the saved student
		
		int theId = tempStudent.getId();
		System.out.println("Generated Id: "+ theId);
		
		//retrieve student based on the id: primary key
		
		System.out.println("Retrieving student with id: "+ theId);
		Student theStudent = studentDAO.findById(theId);
		
		//display student
		
		System.out.println("Form the student: " + theStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		
		//create multiple students
		
		System.out.println("Creating 3 objects...");
		Student tempstudent1 = new Student("Mukul", "Kolte", "mukul@gmail.com");
		Student tempstudent2 = new Student("koi", "toh", "koi@gmail.com");
		Student tempstudent3 = new Student("hoga", "ye", "hoga@gmail.com");
		
		//save student objects
		
		System.out.println("Saving the students...");
		studentDAO.save(tempstudent1);
		studentDAO.save(tempstudent2);
		studentDAO.save(tempstudent3);
	}
	
	private void createStudent(StudentDAO studentDAO) {
		
		//create Student object
		System.out.println("Creating Student object...");
		Student tempstudent = new Student("Chirag", "Kolte", "chirag@gmail.com");
		
		//save Student object
		System.out.println("Saving the student");
		studentDAO.save(tempstudent);
		
		//display Student object
		System.out.println(tempstudent.toString());
		
	}

}
