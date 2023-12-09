package com.poly.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.poly.model.Report;


@Repository
public interface ReportRepo extends JpaRepository<Report, Integer>{
	@Procedure(procedureName = "DOANH_THU_NAM" )	
	Report getReport(@Param("year") int year);
}
