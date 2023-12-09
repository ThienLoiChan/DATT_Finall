package com.poly.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name="danhgias")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DanhGia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maDanhGia;
	private String email;
	private String hoVaTen;
	private String hinh;
	private String ngayDanhGia;
	private String nhanXet;
	private int soSao;
	
	@ManyToOne
	@JoinColumn(name = "maQua",nullable = false)
	private Qua qua;
}
