package com.poly.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poly.model.KhachHang;


@Repository
public interface AccountRepo extends JpaRepository<KhachHang, String>  {

}
