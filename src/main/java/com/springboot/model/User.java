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

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "is_Admin")
	private Boolean isAdmin;
	@JoinColumn(name = "created_by")
	@ManyToOne
	private User createdBy;
	@Column(name = "created_date")
	private Date createdDate;
	@Column(name = "del_flg")
	private Boolean delFlg;
	@Column(name = "del_reason")
	private String delReason;
	@Column(name="del_date")
	private Date delDate;
	@Column(name="enabled")
	private Boolean enabled;

}
