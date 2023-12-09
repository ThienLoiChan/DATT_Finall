package com.poly.repo;


import com.poly.model.Quyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuyenRepo extends JpaRepository<Quyen, Integer> {
	
}
