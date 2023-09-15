package com.pktech.cruddemo;

import com.pktech.cruddemo.dao.StudentDAO;
import com.pktech.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner -> {
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			queryForStudents(studentDAO);
		};
	}

	private void queryForStudents(StudentDAO studentDAO) {

		List<Student> students = studentDAO.findAll();
		for(Student student : students){
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		System.out.println("Creating student object......");
		Student student = new Student("Atul", "Anand", "atulanand@gmail.com");
		System.out.println("Saving the student object......");
		studentDAO.save(student);
		int id = student.getId();
		System.out.println("Saved student Generated ID : " + id);
		//retreive the saved student

		System.out.println("Retrieving the student by id....:");
		Student myStudent = studentDAO.findById(id);

		System.out.println("Retrieved Student : " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		Student student1 = new Student("Rahul", "Singh", "rahulsingh@gmail.com");
		Student student2 = new Student("Piyush", "Mehra", "piyushmehra@gmail.com");
		Student student3 = new Student("Aman", "Raj", "amanraj@gmail.com");

		System.out.println("Saving student objects......");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);

	}

	private void createStudent(StudentDAO studentDAO) {

		//create student object
		Student student = new Student("Punit", "Pandey", "pandeypunit897@gmail.com");
		//save the student
		System.out.println("Saving the student.....");
		studentDAO.save(student);
		//display id of saved student
		System.out.println("Saved student Generated ID : " + student.getId());
	}
}
