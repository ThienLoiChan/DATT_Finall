package com.poly.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.poly.model.Qua;

@Repository
public interface QuaRepo extends JpaRepository<Qua, Integer> {
	@Query("SELECT g FROM Qua g WHERE g.tenQua like %?1%")
    List<Qua> findByName(String tenQua);
}
