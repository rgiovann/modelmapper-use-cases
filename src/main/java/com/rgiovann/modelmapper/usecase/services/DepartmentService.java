package com.rgiovann.modelmapper.usecase.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rgiovann.modelmapper.usecase.dto.DepartmentDTO;
import com.rgiovann.modelmapper.usecase.entities.Department;
import com.rgiovann.modelmapper.usecase.repositories.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository repository;
	
	@Autowired 
	private ModelMapper departmentModelMapper;
	
	public List<DepartmentDTO> findAll() {
		List<Department> list = repository.findAll(Sort.by("name"));
		return list.stream().map(department -> departmentModelMapper.map(department, DepartmentDTO.class)).collect(Collectors.toList());
	}
	
	@Transactional
	public DepartmentDTO insert(DepartmentDTO departmentDTO) {
		Department department = new Department();
		departmentModelMapper.map(departmentDTO,department );
		department = repository.save(department); 
		departmentModelMapper.map(department, departmentDTO);
		return departmentDTO;
	}
}
