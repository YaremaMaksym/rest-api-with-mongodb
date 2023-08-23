package com.xsakon.demo;

import com.xsakon.demo.student.StudentRepository;
import com.xsakon.demo.student.models.Address;
import com.xsakon.demo.student.models.Gender;
import com.xsakon.demo.student.models.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository studentRepository, MongoTemplate mongoTemplate) {
		return args -> {
			String email = "heisenberg@gmail.com";
			Student student = new Student(
					"Walter",
					"White",
					Gender.MALE,
					email,
					new Address("USA", "Albuquerque", "87101"),
					LocalDateTime.now(),
					List.of("Chemistry", "Physics"),
					BigDecimal.TEN
			);

//			checkIfStudentWithEmailExistsUsingMongoTemplateAndQuery(studentRepository, mongoTemplate, email, student);

			studentRepository.findStudentByEmail(email)
					.ifPresentOrElse( s -> {
						System.out.println(s + " already exists");
						}, () -> {
						System.out.println("Inserting student " + student);
						studentRepository.insert(student);
					});
		};
	}

	private static void checkIfStudentWithEmailExistsUsingMongoTemplateAndQuery(StudentRepository studentRepository, MongoTemplate mongoTemplate, String email, Student student) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));

		List<Student> students = mongoTemplate.find(query, Student.class);

		if (students.size() > 1) {
			throw new IllegalStateException("found more than one student with that email " + email);
		}

		if (students.isEmpty()) {
			System.out.println("Inserting student " + student);
			studentRepository.insert(student);
		} else {
			System.out.println(student + " already exists");
		}
	}
}
