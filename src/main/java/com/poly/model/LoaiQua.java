package com.poly.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="loaiquas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoaiQua implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maLoaiQua;
	private int gioiTinh;
	private String tenLoai;

	//bi-directional many-to-one association to Qua
	@JsonIgnore
	@OneToMany(mappedBy="loaiQua")
	private List<Qua> quas;
}
