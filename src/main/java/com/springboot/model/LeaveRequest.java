package com.springboot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.springboot.utils.HrisEnums;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table(name="leaves")
public class LeaveRequest {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="created_date")
	private Date createdDate;
	@JoinColumn(name="created_by", referencedColumnName="id")
	@ManyToOne
	private User createdBy;
	@Column(name="del_flg")
	private Boolean delFlg;
	@Column(name="del_date")
	private Date delDate;
	@Column(name="req_date_from")
	private Date reqDateFrom;
	@Column(name="req_date_to")
	private Date reqDateTo;
	
	// private String empName; // Employee name who is asking for request (The Logged In User), if needed use it afterwards, 
	@Column(name="req_description")
	private String reqDescription;

	@Column(name="advanced_amount")
	private Long advAmount;
	
	@JoinColumn(name="alt_employee", referencedColumnName="id")
	@ManyToOne
	private User altEmployee;

	@Column(name="msg_toAlt_emp")
	private String msgAltEmp; //Send msg on google to alternative employee
	
//	private int notificationmailTo // Sending notification mail to Supervisors and alternative employee 
	
	@Column(name="leave_statu")
	@Enumerated(EnumType.STRING)
	private HrisEnums leaveStatus; 
}
