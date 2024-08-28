package com.gaby.crud;

import com.gaby.crud.dao.InstructorDAO;
import com.gaby.crud.entity.Course;
import com.gaby.crud.entity.Instructor;
import com.gaby.crud.entity.InstructorDetail;
import com.gaby.crud.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(InstructorDAO instructorDAO) {
		return runner -> {
			// createInstructor(instructorDAO);
			// findInstructor(instructorDAO);
			// deleteInstructor(instructorDAO);
			// findInstructorDetail(instructorDAO);
			// deleteInstructorDetail(instructorDAO);
			// createInstructorWithCourses(instructorDAO);
			// findInstructorWithCourses(instructorDAO);
			// findInstructorWithCoursesJoinFetch(instructorDAO);
			// updateInstructor(instructorDAO);
			// updateCourse(instructorDAO);
			// deleteCourse(instructorDAO);
			// createCourseAndReviews(instructorDAO);
			// findCourseAndReview(instructorDAO);
			deleteCourseAndReview(instructorDAO);
		};
	}

	private void deleteCourseAndReview(InstructorDAO instructorDAO) {
		int courseId = 1;

		instructorDAO.deleteCourseById(courseId);

		System.out.println("Done!!");
	}

	private void findCourseAndReview(InstructorDAO instructorDAO) {
		int courseId = 1;

		Course course = instructorDAO.findCourseAndReviewsByCourseId(courseId);
		System.out.println(course);
		System.out.println(course.getReviews());
		System.out.println("Done!!");
	}

	private void createCourseAndReviews(InstructorDAO instructorDAO) {
		Course course = new Course("Mathematics");

		course.addReview(new Review("Great Course"));
		course.addReview(new Review("Cool Course"));
		course.addReview(new Review("Bad Course"));

		instructorDAO.save(course);

		System.out.println(course);
		System.out.println(course.getReviews());
		System.out.println("Done!!");

	}

	private void deleteCourse(InstructorDAO instructorDAO) {
		int theId = 10;
		instructorDAO.deleteCourseById(theId);
		System.out.println("Done!!");
	}

	private void updateCourse(InstructorDAO instructorDAO) {
		int id = 10;

		System.out.println("finding course id: " + id);

		Course course = instructorDAO.findCourseById(id);

		// update the course
		System.out.println("Updating course id: " + course.getId());
		course.setTitle("TESTER");

		instructorDAO.update(course);

		System.out.println("Done!");
	}

	private void updateInstructor(InstructorDAO instructorDAO) {
		int id = 1;

		System.out.println("finding instructor id: " + id);

		Instructor instructor = instructorDAO.findInstructorByIdJoinFetch(id);

		// update the instructor
		System.out.println("Updating instructor id: " + instructor.getId());
		instructor.setLastName("TESTER");

		instructorDAO.update(instructor);

		System.out.println("Done!");
	}

	private void findInstructorWithCoursesJoinFetch(InstructorDAO instructorDAO) {
		int id = 1;

		System.out.println("finding instructor id: " + id);

		Instructor instructor = instructorDAO.findInstructorByIdJoinFetch(id);

		System.out.println("instructor: " + instructor);
		System.out.println("The courses: " + instructor.getCourses());

		System.out.println("Done!");
	}

	private void findInstructorWithCourses(InstructorDAO instructorDAO) {

		int id = 1;

		System.out.println("finding instructor id: " + id);

		Instructor instructor = instructorDAO.findInstructorById(id);

		System.out.println("instructor: " + instructor);

		List<Course> courseList = instructorDAO.findCoursesByInstructorId(id);
		instructor.setCourses(courseList);

		System.out.println("The courses: " + instructor.getCourses());

		System.out.println("Done!");
	}

	private void createInstructorWithCourses(InstructorDAO instructorDAO) {

		// Create instructor
		Instructor instructor = new Instructor("Mauri","Allegretti", "mallegretti@gmail.com");

		InstructorDetail instructorDetail =
				new InstructorDetail("http://www.luv2code.com/youtube",
						"Running!!");

		instructor.setInstructorDetail(instructorDetail);

		Course course = new Course("Mathematics");
		Course course2 = new Course("Air Guitar");
		Course course3 = new Course("Economics");
		Course course4 = new Course("Literature");

		instructor.add(course);
		instructor.add(course2);
		instructor.add(course3);
		instructor.add(course4);

		// save instructor
		System.out.println("Saving instructor: " + instructor);
		System.out.println("The courses: " + instructor.getCourses());
		instructorDAO.save(instructor);
	}

	private void deleteInstructorDetail(InstructorDAO instructorDAO) {
		int theId = 5;
		instructorDAO.deleteInstructorDetailById(theId);
		System.out.println("Done!!");
	}

	private void findInstructorDetail(InstructorDAO instructorDAO) {

		int theId = 3;
		InstructorDetail instructorDetail = instructorDAO.findInstructorDetailById(theId);

		System.out.println("Instructor Detail " + instructorDetail);

		System.out.println("Instructor " + instructorDetail.getInstructor());

		System.out.println("Done!!");
	}

	private void deleteInstructor(InstructorDAO instructorDAO) {
		int id = 1;
		instructorDAO.deleteInstructorById(id);

		System.out.println("Instructor deleted");
	}

	private void findInstructor(InstructorDAO instructorDAO) {
		int id = 1;

		Instructor instructor = instructorDAO.findInstructorById(id);

		System.out.println("Instructor: " + instructor);
		System.out.println("Detail: " + instructor.getInstructorDetail());

	}

	private void createInstructor(InstructorDAO instructorDAO) {

		// Create instructor
		Instructor instructor = new Instructor("Mauri","Allegretti", "mallegretti@gmail.com");

		InstructorDetail instructorDetail =
				new InstructorDetail("http://www.luv2code.com/youtube",
				"Running!!");

		instructor.setInstructorDetail(instructorDetail);

		// Save the new instructor
		System.out.println("Save Instructor: "+ instructor);
		instructorDAO.save(instructor);


		System.out.println("Done!!");
	}

}
