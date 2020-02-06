package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "office")
public class Office  {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="office_name")
	@Size(max = 255)
	private String officeName;
	
	private String address;
	private Integer panNo;
	@Column(name = "short_name")
	private String shortName;
	@Column(name = "del_flg")
	private boolean delFlg;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOfficeName() {
		return officeName;
	}
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getPanNo() {
		return panNo;
	}
	public void setPanNo(Integer panNo) {
		this.panNo = panNo;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public boolean isDelFlg() {
		return delFlg;
	}
	public void setDelFlg(boolean delFlg) {
		this.delFlg = delFlg;
	}

}
