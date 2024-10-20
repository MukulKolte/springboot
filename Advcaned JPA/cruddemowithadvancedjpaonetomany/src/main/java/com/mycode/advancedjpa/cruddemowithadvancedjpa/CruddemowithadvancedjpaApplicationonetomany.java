package com.mycode.advancedjpa.cruddemowithadvancedjpa;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mycode.advancedjpa.cruddemowithadvancedjpa.dao.AppDAO;
import com.mycode.advancedjpa.cruddemowithadvancedjpa.entity.Course;
import com.mycode.advancedjpa.cruddemowithadvancedjpa.entity.Instructor;
import com.mycode.advancedjpa.cruddemowithadvancedjpa.entity.InstructorDetail;

@SpringBootApplication
public class CruddemowithadvancedjpaApplicationonetomany {

	public static void main(String[] args) {
		SpringApplication.run(CruddemowithadvancedjpaApplicationonetomany.class, args);
	}

	
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		
		return runner -> {
//			createInstructor(appDAO);
			
//			findInstructorById(appDAO);
			
//			deleteInstructorById(appDAO);
			
//			findInstructorDetailById(appDAO);
			
//			deleteInstructorDetailById(appDAO);
			
//			createInstructorWithCourses(appDAO);
			
//			findInstructorWithCourses(appDAO);
			
//			findCoursesForInstructor(appDAO);
			
//			findInstructorWithCoursesJoinFetch(appDAO);
			
//			updateInstructor(appDAO);
			
//			updateCourse(appDAO);
			
//			deleteInstructor(appDAO);
			
			deleteCourse(appDAO);
		};
	}


	private void deleteCourse(AppDAO appDAO) {
		
		int theId = 10;
		
		System.out.println("Deleting the course: " + theId);
		
		appDAO.deleteCourseById(theId);
		
		System.out.println("Done...");
	}

	private void deleteInstructor(AppDAO appDAO) {
		
		int theId=1;
		
		System.out.println("Deleting the instructor id: " + theId);
		
		appDAO.deleteInstructor(theId);
		
		System.out.println("Done..");
	}

	private void updateCourse(AppDAO appDAO) {
		
		int theId = 10;
		
		//find the Course
		System.out.println("Finding the course: " + theId);
		Course theCourse = appDAO.findCourseById(theId);
		
		//update the course
		System.out.println("Updating the course: "+ theId);
		theCourse.setTitle("Testing if title changes");
		
		appDAO.update(theCourse);
		System.out.println("Done...");
	}

	private void updateInstructor(AppDAO appDAO) {
		
		int theId = 1;
		
		//find the instructor
		System.out.println("Finding the instructor: " + theId);
		Instructor tempInstructor = appDAO.findById(theId);
		
		//updatte the instructor
		System.out.println("Updating the instructor: " + theId);
		tempInstructor.setLastName("TESTER");
		
		appDAO.update(tempInstructor);
		
		System.out.println("Done...");
		
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		
		int theId=1;
		
		//find the instructor 
		System.out.println("Finding instructor id: " + theId);
		
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);
		
		System.out.println("tempInstructor: " + tempInstructor);
		
		System.out.println("Associated courses for the instructor: " + tempInstructor.getCourses());
		
		System.out.println("Associated Instructor detail for the instructor: " + tempInstructor.getInstructorDetail());
		
		System.out.println("Done...");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		
		
		int theId = 1;
		System.out.println("Finding Instructor Id: " + theId);
		
		Instructor tempInstructor = appDAO.findById(theId);
		
		System.out.println("tempInstructor: " + tempInstructor);
		
		//find courses for instructor
		
		System.out.println("Finding courses for Instructor id: " + theId);
		
		List<Course> resultCourses = appDAO.findCoursesByInstructorId(theId);
		
		//associate the objects
		
		tempInstructor.setCourses(resultCourses);
		
		System.out.println("The associated courses: " + tempInstructor.getCourses());
		
		System.out.println("Done...");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		
		int theId = 1;
		System.out.println("Finding Instructor Id: " + theId);
		
		Instructor tempInstructor = appDAO.findById(theId);
		
		System.out.println("tempInstructor: " + tempInstructor);
		
		System.out.println("Associated Courses: " + tempInstructor.getCourses());
		
		System.out.println("Done...");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		
		//create the Instructor
		Instructor tempInstructor = new Instructor("Pranil", "Shete", "pranil@gmail.com");
		
		//create Instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("PranilYT", "Watching Youtube");
		
		//associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		
		//create some courses
		Course tempCourse1 = new Course("Watch Mr. Beast's youtube videos");
		Course tempCourse2 = new Course("Watch Samay Raina's youtube videos");
		
		//add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);
		
		//save the instructor
		//This will also save the courses because of Cascadetype.PERSIST
		System.out.println("Saving the instructor: " + tempInstructor);
		System.out.println("the Courses: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);
		
		System.out.println("Done...");
	}

	private void deleteInstructorDetailById(AppDAO appDAO) {
		
		int theId=5;
		appDAO.deleteInstructorDetailById(theId);
		
		System.out.println("Deleted entry for id: "+ theId);
	}

	private void findInstructorDetailById(AppDAO appDAO) {
		
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(1);
		
		System.out.println(tempInstructorDetail);
		System.out.println(tempInstructorDetail.getInstructor());
	}

	private void deleteInstructorById(AppDAO appDAO) {
		
		//call method from DAO to delete the entry
		appDAO.deleteInstructor(2);
		
//		System.out.println("Deleted: " + tempInstructor);
	}

	private void findInstructorById(AppDAO appDAO) {
		
		Instructor tempInstructor = appDAO.findById(2);

		System.out.println(tempInstructor);
	}

	private void createInstructor(AppDAO appDAO) {
		
		/*
		//create the Instructor
		Instructor tempInstructor = new Instructor("Mukul", "Kolte", "mukul@gmail.com");
		
		//create Instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("mukulYT", "Gaming");
		*/
		
		//create the Instructor
		Instructor tempInstructor = new Instructor("Chirag", "Kolte", "chirag@gmail.com");
		
		//create Instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("ChiragYT", "Streaming");
		
		//associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		
		System.out.println("Saving the instructor: " + tempInstructor + "...");
		
		//save the instructor
		//this will also save the detail object due to CascadeType.ALL
		appDAO.save(tempInstructor);
		
		System.out.println("Done...");
	}
}
