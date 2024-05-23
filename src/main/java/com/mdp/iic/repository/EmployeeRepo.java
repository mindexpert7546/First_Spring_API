package com.mdp.iic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mdp.iic.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
