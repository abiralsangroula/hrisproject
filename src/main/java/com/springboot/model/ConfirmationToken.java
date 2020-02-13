package com.springboot.model;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "confirmationToken")
public class ConfirmationToken {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "token_id")
	private long tokenid;

	@Column(name = "confirmation_token")
	private String confirmationToken;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "user_id")
	private User user;
	
	@Column(name="del_flg")
	private Boolean delFlg;
	
	@Column(name="expiry_date")
	private Date expiryDate;
	
	private Date calculateExpiryDate(int hours) {
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(new Date());
	        cal.add(Calendar.SECOND, hours);
	        return cal.getTime() ;
	    }
	     

	public ConfirmationToken(User user) {
		this.user = user;
		delFlg=false;
		createdDate = new Date();
		expiryDate= calculateExpiryDate(24);
		confirmationToken = UUID.randomUUID().toString();
	}
}
