package com.rgiovann.modelmapper.usecase.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rgiovann.modelmapper.usecase.dto.EmployeeDTO;
import com.rgiovann.modelmapper.usecase.entities.Employee;
import com.rgiovann.modelmapper.usecase.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
 
	
	@Autowired 
	private ModelMapper employeeModelMapper;
	


	
	@Transactional(readOnly = true)
	public 	Page<EmployeeDTO> findAllPaged(Pageable pageRequest) {
	    	
			TypeMap<Employee, EmployeeDTO> propertyMapper = employeeModelMapper.createTypeMap(Employee.class, EmployeeDTO.class);
	    	
			propertyMapper.addMappings(
	    		      mapper -> mapper.map(src -> src.getDepartment().getName(), EmployeeDTO::setDepartmentName)
	    		    );
 			
			Page<Employee> page = employeeRepository.findAll(pageRequest);
			return page.map(p -> {EmployeeDTO employeeDTO = employeeModelMapper.map(p, EmployeeDTO.class); 
 										  	  return employeeDTO;
							 }
		                );

	}
	
	
	@Transactional
	public EmployeeDTO update(Long id, EmployeeDTO employeeDTO) {

			Optional<Employee> obj = employeeRepository.findById(id);
			Employee entity = obj.orElseThrow(() -> new NoSuchElementException("Error. Id not found: " + id));
			
			employeeModelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
			employeeModelMapper.map(employeeDTO, entity);
			employeeModelMapper.map(entity, employeeDTO);
			return employeeDTO;
 
	}	
	
	
 
}
