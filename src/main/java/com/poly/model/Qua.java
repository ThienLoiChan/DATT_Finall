package com.poly.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name="quas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Qua implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maQua;
	private String tenQua;
	private int donGia;
	private double giamGia;
	private String moTa;
	private String hinhAnh;
	
	@JsonIgnore
	@OneToMany(mappedBy = "qua")
	private List<DanhGia> danhGias;

	@JsonIgnore
	@OneToMany(mappedBy = "qua")
	private List<ChiTietDonHang> chiTietDonHangs;
	// bi-directional many-to-one association to HangQua
	
	@ManyToOne
	@JoinColumn(name = "maHang")
	private HangQua hangQua;

	// bi-directional many-to-one association to LoaiQua
	
	@ManyToOne
	@JoinColumn(name = "maLoaiQua")
	private LoaiQua loaiQua;	
    
	
}
