package com.poly.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Entity
@Table(name="chitietdonhangs")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChiTietDonHang implements Serializable {

	@EmbeddedId
	private ChiTietDonHangPK id;
	@Column(name = "SoLuong")
	private int soLuong;
	@Column(name = "DonGia")
	private int donGia;

	//bi-directional many-to-one association to Giay
	@ManyToOne(optional=false)
	@JoinColumn(name="maQua", insertable=false, updatable=false)
	private Qua qua;

	//bi-directional many-to-one association to GioHang
	@ManyToOne(optional=false)
	@JoinColumn(name="maDonHang", insertable=false, updatable=false)
	private DonHang donHang;
}
