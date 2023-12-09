package com.poly.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Entity
@Table(name="khachhangs")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class KhachHang implements Serializable {
	@Id
	@Column(name="TaiKhoan")
	private String taiKhoan;

	@Column(name="MatKhau")
	private String matKhau;
	
	@Column(name="TenKhachHang")
	private String tenKhachHang;

	@Column(name="SoDienThoai")
	private String soDienThoai;
	
	@Column(name="DiaChi")
	private String diaChi;
	
	@ManyToOne
	@JoinColumn(name = "maQuyen")
	private Quyen quyen;	
}
