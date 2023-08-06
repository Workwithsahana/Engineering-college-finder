package com.collegeDetails.CollegeConnect.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegeDetails.CollegeConnect.Dto.CollegeDto;
import com.collegeDetails.CollegeConnect.Entity.CollegeDetailsRepository;

@Service
public class CollegeConnectorServiceImpl implements CollegeConnectorService {

	@Autowired
	CollegeDetailsRepository collegeDetailsRepository;

	public List<CollegeDto> getAllCollegeDetails() { //retrieves a list of all college detailsfrom data base

		return collegeDetailsRepository.findAll();
	}

	public CollegeDto getCollegeDetailsByCollegeId(String collegeId) {
		List<CollegeDto> existingCollegeDetails = collegeDetailsRepository.findAll();

		for (CollegeDto collegeDto : existingCollegeDetails) {
			if (collegeDto.getCollegeId().equalsIgnoreCase(collegeId)) {
				return collegeDto;
			}
		}
		return null;
	}

	public void createCollegeDetails(CollegeDto collegeDetails) {

		try {
			collegeDetailsRepository.postCollegeDetails(collegeDetails.getCollegeId(),
					collegeDetails.getCollegeName(), collegeDetails.getCetRankRange(),collegeDetails.getComedkRankRange(), collegeDetails.getCetFees(),
					collegeDetails.getComedkFees(), collegeDetails.getDistaceFromMejestic(),
					collegeDetails.getBranches(), collegeDetails.getPlacementIn2020(),
					collegeDetails.getPlacementIn2021(), collegeDetails.getPlacementIn2022(),
					collegeDetails.getHigestPackageOffered());
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
	}

	public CollegeDto updateCollegeDetails(String collegeId, CollegeDto collegeDetails) {
		List<CollegeDto> existingCollegeDetails = collegeDetailsRepository.findAll();

		for (CollegeDto collegeDto : existingCollegeDetails) {
			if (collegeDto.getCollegeId().equalsIgnoreCase(collegeId)) {
				collegeDto.setBranches(collegeDetails.getBranches());
				collegeDto.setCetFees(collegeDetails.getCetFees());
				collegeDto.setComedkFees(collegeDetails.getComedkFees());
				collegeDto.setCetRankRange(collegeDetails.getCetRankRange());
				collegeDto.setComedkRankRange(collegeDetails.getComedkRankRange());
				return collegeDetailsRepository.save(collegeDto);
			}
			
		}
		return null;
	}

}
