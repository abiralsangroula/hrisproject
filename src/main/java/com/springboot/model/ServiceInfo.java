package com.springboot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "service_info")
public class ServiceInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "service_date")
	@Temporal(TemporalType.DATE)
	private Date serviceDate;
	
	@Column(name = "working_status")
	private String workingStatus; // working, resigned,...
	
	@JoinColumn(name = "personal_info_id", referencedColumnName = "id")
	@ManyToOne
	private PersonalInfo personalInfoId;
	
	@Column(name = "appointment_type")
	private String appointmentType; // let's make it an enum afterwards... regular, parttime, visitor
	
	@Column(name = "on_probation")
	private Boolean onProbation;
	
	@Column(name = "probation_date")
	@Temporal(TemporalType.DATE)
	private Date probationDate;
	
	@Column(name = "permanent_date")
	@Temporal(TemporalType.DATE)
	private Date permanentDate;
	
	@JoinColumn(name = "supervisor_name", referencedColumnName="id")
	@ManyToOne
	private PersonalInfo supervisorName;
	
	@JoinColumn(name = "supervisor_name2", referencedColumnName = "id")
	@ManyToOne
	private PersonalInfo supervisor_name2;
	
	@Column(name = "mark_as_supervisor")
	private Boolean markAsSupervisor;
	
	@Column(name = "service_department")
	private String serviceDepartment; // Development, Research, others please specify;

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
		ServiceInfo other = (ServiceInfo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

	@Override
	public String toString() {
		return "ServiceInfo [id=" + id + "]";
	}

}
