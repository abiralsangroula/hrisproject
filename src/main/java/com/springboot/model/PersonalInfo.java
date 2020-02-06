package com.springboot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "personal_info")
public class PersonalInfo {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	@Column(name = "emp_id")
	private String empId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;
	
	@Column(name="address")
	private String address;

	@Column(name = "salutation")
	private String salutation;

	@Column(name = "gender")
	private String gender;

	@Column(name = "marital_status")
	private String maritalStatus;

	@Column(name = "mobile_no")
	private Long mobileNo;

	@Column(name = "telephone")
	private Long telephone;

	@Column(name = "email")
	private String email;

	@Column(name = "blood_group")
	private String bloodGroup;

	@Column(name = "email_alt")
	private String emailAlt;

	@Column(name = "pan_no")
	private Long panNo;

	@Column(name = "dob")
	@Temporal(TemporalType.DATE)
	private Date dob;

	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "del_date")
	private Date delDate;

	@Column(name = "del_flg")
	private Boolean delFlg;

	@Column(name = "is_Admin")
	private Boolean isAdmin;
	
	@Column(name="bank_detail_no")
	private String bankDetailNo;
	
	@Column(name="middle_name")
	private String middleName;
	
	@JoinColumn(name="created_by", referencedColumnName="id")
	@ManyToOne
	private User createdBy;

	@Override
	public String toString() {
		return "PersonalInfo [id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonalInfo other = (PersonalInfo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
