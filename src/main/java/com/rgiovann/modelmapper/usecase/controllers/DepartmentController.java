package com.rgiovann.modelmapper.usecase.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rgiovann.modelmapper.usecase.dto.DepartmentDTO;
import com.rgiovann.modelmapper.usecase.services.DepartmentService;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping
	public ResponseEntity<List<DepartmentDTO>> findAll() {
		List<DepartmentDTO> list = departmentService.findAll();		
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<DepartmentDTO> insert(@RequestBody DepartmentDTO departmentDTO){
		departmentDTO = departmentService.insert(departmentDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(departmentDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(departmentDTO);
		
	}
}
