package com.collegeDetails.CollegeConnect.Service;

import java.util.List;
import com.collegeDetails.CollegeConnect.Dto.CollegeDto;

public interface CollegeConnectorService {
	
	public List<CollegeDto> getAllCollegeDetails();
	
	public CollegeDto getCollegeDetailsByCollegeId(String collegeId);
	
	public void createCollegeDetails(CollegeDto collegeDetails);
	
	public CollegeDto updateCollegeDetails(String collegeName,CollegeDto collegeDetails);

}
