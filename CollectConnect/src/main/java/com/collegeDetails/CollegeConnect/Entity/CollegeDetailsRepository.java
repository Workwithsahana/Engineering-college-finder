package com.collegeDetails.CollegeConnect.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.collegeDetails.CollegeConnect.Dto.CollegeDto;

public interface CollegeDetailsRepository extends JpaRepository<CollegeDto, String> {

	@Query(value = "INSERT INTO public.college_details(\n"
			+ "	college_id, college_name, cet_rank_range, comedk_rank_range, cet_fees, comedk_fees, distance_from_mejestic, branches, placement_2020, placement_2021, placement_2022, highest_package)\n"
			+ "VALUES (:college_id, :college_name, :cet_rank_range, :comedk_rank_range, :cet_fees, :comedk_fees, :distance_from_mejestic, :branches, :placement_2020, :placement_2021, :placement_2022, :highest_package);", nativeQuery = true)
	void postCollegeDetails(@Param("college_id") String college_id, @Param("college_name") String college_name,
			@Param("cet_rank_range") String cet_rank_range, @Param("comedk_rank_range") String comedk_rank_range,
			@Param("cet_fees") String cet_fees, @Param("comedk_fees") String comedk_fees,
			@Param("distance_from_mejestic") String distance_from_mejestic, @Param("branches") String[] branches,
			@Param("placement_2020") String placement_2020, @Param("placement_2021") String placement_2021,
			@Param("placement_2022") String placement_2022, @Param("highest_package") String highest_package);

	CollegeDto findByCollegeId(String collegeId);

	CollegeDto findByCollegeName(String collegeName);

}
