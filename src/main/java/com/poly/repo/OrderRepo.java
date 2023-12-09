package com.poly.repo;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.poly.model.DonHang;


@Repository
public interface OrderRepo extends JpaRepository<DonHang, Integer> {
	@Query("SELECT o FROM DonHang o WHERE o.trangThai like %?1%")
    List<DonHang> findByStatus(String trangThai);

    @Query(value = "select * from donhangs order by ma_don_hang DESC",nativeQuery = true)
    List<DonHang> findOrderDESC();

    @Query(value = "select * from donhangs order by ma_don_hang DESC",nativeQuery = true)
    Page<DonHang> findOrderDESC(Pageable pageable);
}
