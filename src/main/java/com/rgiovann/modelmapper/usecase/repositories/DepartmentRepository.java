package com.rgiovann.modelmapper.usecase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rgiovann.modelmapper.usecase.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
