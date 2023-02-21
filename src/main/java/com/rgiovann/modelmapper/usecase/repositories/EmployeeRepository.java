package com.rgiovann.modelmapper.usecase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rgiovann.modelmapper.usecase.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
