package com.collegeDetails.CollegeConnect.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="college_details")
public class CollegeDto {

	@Id
	@GeneratedValue
	@Column(name = "college_id")
	private String collegeId;

	@Column(name = "college_name")
	private String collegeName;

	@Column(name = "cet_rank_range")
	private String cetRankRange;
	
	@Column(name = "comedk_rank_range")
	private String comedkRankRange;

	@Column(name = "cet_fees")
	private String cetFees;

	@Column(name = "comedk_fees")
	private String comedkFees;

	@Column(name = "distance_from_mejestic")
	private String distaceFromMejestic;

	@Column(name = "branches")
	private String[] branches;

	@Column(name = "placement_2020")
	private String placementIn2020;

	@Column(name = "placement_2021")
	private String placementIn2021;

	@Column(name = "placement_2022")
	private String placementIn2022;

	@Column(name = "highest_package")
	private String higestPackageOffered;
	
	

}
