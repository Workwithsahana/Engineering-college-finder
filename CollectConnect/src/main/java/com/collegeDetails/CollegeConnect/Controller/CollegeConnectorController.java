package com.collegeDetails.CollegeConnect.Controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.collegeDetails.CollegeConnect.Dto.CollegeDto;
import com.collegeDetails.CollegeConnect.Service.CollegeConnectorServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController // incoming request
@Validated // validate the incoming request
@Slf4j
public class CollegeConnectorController {

	@Autowired // mapping
	ModelMapper modelMapper;

	@Autowired // related to college details
	CollegeConnectorServiceImpl collegeConnectorServiceImpl;

	@GetMapping(value = "/college-connector") // calling all detials
	public ResponseEntity getAllCollegeDetails() {

		List<CollegeDto> collegeDtos = collegeConnectorServiceImpl.getAllCollegeDetails();
		return new ResponseEntity<List<CollegeDto>>(collegeDtos, HttpStatus.OK);

	}

	@GetMapping(value = "/college-connector/{collegeId}")
	public ResponseEntity getCollegeDetailsByName(@PathVariable(name = "collegeId") String collegeId) {

		CollegeDto collegeDto = collegeConnectorServiceImpl.getCollegeDetailsByCollegeId(collegeId);
		return new ResponseEntity(collegeDto, HttpStatus.OK);
	}

	@PostMapping(value = "/college-connector")
	public ResponseEntity createNewCollegeDetails(@RequestBody CollegeDto collegeDetails) {

		collegeConnectorServiceImpl.createCollegeDetails(collegeDetails);
		return new ResponseEntity("Successfully added College details", HttpStatus.CREATED);

	}

	@PutMapping(value = "/college-connector/{collegeId}")
	public ResponseEntity updateCollegeDetails(@PathVariable(name = "collegeId") String collegeId,
			@RequestBody CollegeDto collegeDetails) {

		collegeConnectorServiceImpl.updateCollegeDetails(collegeId, collegeDetails);
		return new ResponseEntity("Successfully updated the College details", HttpStatus.OK);

	}

}
