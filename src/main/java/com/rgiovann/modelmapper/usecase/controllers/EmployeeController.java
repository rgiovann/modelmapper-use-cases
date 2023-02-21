package com.rgiovann.modelmapper.usecase.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgiovann.modelmapper.usecase.dto.EmployeeDTO;
import com.rgiovann.modelmapper.usecase.services.EmployeeService;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public ResponseEntity<Page<EmployeeDTO>> findAll(Pageable pageable) {
		Page<EmployeeDTO> list = employeeService.findAllPaged(pageable);
		return ResponseEntity.ok().body(list);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<EmployeeDTO> update( @PathVariable Long id, @RequestBody EmployeeDTO productDTO){
		productDTO = employeeService.update(id, productDTO);
		return ResponseEntity.ok().body(productDTO);
		
	}
}
