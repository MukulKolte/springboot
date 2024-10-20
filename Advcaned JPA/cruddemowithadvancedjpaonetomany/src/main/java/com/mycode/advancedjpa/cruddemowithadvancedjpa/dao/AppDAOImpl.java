package com.mycode.advancedjpa.cruddemowithadvancedjpa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycode.advancedjpa.cruddemowithadvancedjpa.entity.Course;
import com.mycode.advancedjpa.cruddemowithadvancedjpa.entity.Instructor;
import com.mycode.advancedjpa.cruddemowithadvancedjpa.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class AppDAOImpl implements AppDAO {

	//define field for entity manager
	
	private EntityManager entityManager;
	
	//inject EntityManager using constructor injection

	@Autowired
	public AppDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public void save(Instructor theInstructor) {
		entityManager.persist(theInstructor);
	}

	@Override
	public Instructor findById(int id) {
		
		return entityManager.find(Instructor.class, id);
	}

	@Override
	@Transactional
	public void deleteInstructor(int theId) {
		
		//retrieve instructor
		Instructor tempInstructor = entityManager.find(Instructor.class, theId);
		
		//get the courses
		List<Course> courses = tempInstructor.getCourses();
		
		//break the association with all the courses for the instructor
		for(Course tempCourse : courses) {
			tempCourse.setInstructor(null);
		}
		
		//delete the instructor
		entityManager.remove(tempInstructor);
		
	}

	@Override
	public InstructorDetail findInstructorDetailById(int id) {
		
		return entityManager.find(InstructorDetail.class, id);
	}

	@Override
	@Transactional
	public void deleteInstructorDetailById(int id) {
		
		//get instructor detail by id
		InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, id);
		
		//remove the associated object reference
		//break the bi-directional link
		tempInstructorDetail.getInstructor().setInstructorDetail(null);
		
		//remove the entry which will cascade the removal to Instructor class as well.
		entityManager.remove(tempInstructorDetail);
		
	}

	@Override
	public List<Course> findCoursesByInstructorId(int theId) {
		
		//create the query
		TypedQuery<Course> query = entityManager.createQuery("from Course WHERE instructor.id = :data", Course.class);
		
		query.setParameter("data", theId);
		
		List<Course> courses = query.getResultList();
		
		return courses;
	}

	@Override
	public Instructor findInstructorByIdJoinFetch(int theId) {
		//create query
		TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i JOIN FETCH i.courses JOIN FETCH i.instructorDetail WHERE i.id = :data", Instructor.class);
		
		query.setParameter("data", theId);
		
		//execute the query
		
		Instructor tempInstructor = query.getSingleResult();		
		
		return tempInstructor;
	}

	@Override
	@Transactional
	public void update(Instructor theInstructor) {
		
		entityManager.merge(theInstructor);
	}

	@Override
	@Transactional
	public void update(Course theCourse) {
		
		entityManager.merge(theCourse);
	}

	@Override
	public Course findCourseById(int theId) {
		
		Course theCourse = entityManager.find(Course.class, theId);
		
		return theCourse;
	}

	@Override
	@Transactional
	public void deleteCourseById(int theId) {
		
		//retrieve the course
		Course tempCourse = entityManager.find(Course.class, theId);
		
		//delete the course
		entityManager.remove(tempCourse);
	}
	
}
