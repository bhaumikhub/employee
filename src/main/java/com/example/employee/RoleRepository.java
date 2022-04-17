package com.example.employee;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface RoleRepository extends CrudRepository<Role, Long> {

	Optional<Role> findByName(String name);

}
