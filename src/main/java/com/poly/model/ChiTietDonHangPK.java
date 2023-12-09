package com.poly.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class ChiTietDonHangPK implements Serializable {
	@Column(name="MaDonHang", insertable=false, updatable=false)
	private int maDonHang;

	@Column(name="MaQua", insertable=false, updatable=false)
	private int maQua;
}
