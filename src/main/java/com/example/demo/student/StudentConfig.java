package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repo){
        return args ->{
            Student maryem = new Student(
                    "Maryem",
                    LocalDate.of(2000, Month.JANUARY,1),
                    "maryemtarek@gmail.com"

            );
            Student ahmed = new Student(
                    "Ahmed",
                    LocalDate.of(1997, Month.AUGUST,7),
                    "ahmedtarek@gmail.com"

            );

            repo.saveAll(
                    List.of(maryem,ahmed)
            );
        };
    }
}
