package com.xsakon.demo;

import com.xsakon.demo.student.StudentRepository;
import com.xsakon.demo.student.models.Address;
import com.xsakon.demo.student.models.Gender;
import com.xsakon.demo.student.models.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository studentRepository) {
		return args -> {
			Student student = new Student(
					"Walter",
					"White",
					Gender.MALE,
					"heisenberg@gmail.com",
					new Address("USA", "Albuquerque", "87101"),
					LocalDateTime.now(),
					List.of("Chemistry", "Physics"),
					BigDecimal.TEN
			);

			studentRepository.insert(student);
		};
	}
}
