package com.example.employee;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	Optional<Employee> findByFirstNameAndLastName(String firstName, String lastName);

	Optional<Employee> findByFirstName(String firstName);
}
