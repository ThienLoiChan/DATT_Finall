package com.poly.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="quyens")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Quyen implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaQuyen")
	private int maQuyen;
	@Column(name = "TenQuyen")
	private String tenQuyen;
	
	@JsonIgnore
	@OneToMany(mappedBy = "quyen")
	private List<KhachHang> khachHangs;
}
