package com.example.sp_three.employees;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class EmployeeConfig {
    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
        return (args) -> {
             var employeeList = List.of(
                new Employee(
                        1L,
                        "Vasya",
                        "vasya@gmail.com",
                        LocalDate.of(2000, 1, 10),
                        10000
                ),
                new Employee(
                        2L,
                        "Pasha",
                        "pasha@gmail.com",
                        LocalDate.of(2002, 3, 10),
                        20000
                )
             );
             employeeRepository.saveAll(employeeList);
        };
    }
}
