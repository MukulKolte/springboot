package com.mycode.advancedjpa.cruddemowithadvancedjpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mycode.advancedjpa.cruddemowithadvancedjpa.dao.AppDAO;
import com.mycode.advancedjpa.cruddemowithadvancedjpa.entity.Instructor;
import com.mycode.advancedjpa.cruddemowithadvancedjpa.entity.InstructorDetail;

@SpringBootApplication
public class CruddemowithadvancedjpaApplicationuni {

	public static void main(String[] args) {
		SpringApplication.run(CruddemowithadvancedjpaApplicationuni.class, args);
	}

	
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		
		return runner -> {
//			createInstructor(appDAO);
			
//			findInstructorById(appDAO);
			
			deleteInstructorById(appDAO);
		};
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
