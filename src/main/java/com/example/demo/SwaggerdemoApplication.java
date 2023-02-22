package com.example.demo;

import com.example.demo.data.StudentRepository;
import com.example.demo.domain.Student;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.*")
@OpenAPIDefinition(info = @Info(title = "Students API", version = "2.0", description = "Students Information"))
public class SwaggerdemoApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(SwaggerdemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student s1 = new Student();
		//s1.setId(100);
		s1.setGender("M");
		s1.setName("Emmanuel");

		Student s2 = new Student();
		//s2.setId(200);
		s2.setGender("F");
		s2.setName("Ashok");

		studentRepository.save(s1);
		studentRepository.save(s2);
		System.out.println("SIZE::: " + studentRepository.findAll().size());
	}
}
