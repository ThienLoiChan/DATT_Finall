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
@Table(name="hangquas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HangQua  implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maHang;
	private String tenHang;

	//bi-directional many-to-one association to Giay
	@JsonIgnore
	@OneToMany(mappedBy="hangQua")
	private List<Qua> quas;
	
}
