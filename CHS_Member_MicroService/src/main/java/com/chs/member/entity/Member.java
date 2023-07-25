package com.chs.member.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.chs.member.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "user_credentials")
public class Member extends UserCredentials {

	@Column(nullable = false)
	private String name;

	@Embedded
	private Address address;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@ManyToMany
	private List<Society> society;

	@Column(name = "creation_date")
	@CreationTimestamp
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private LocalDate creationDate;

	@Column(name = "updated_date")
	@CreationTimestamp
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private LocalDate updatedDate;

	@Enumerated(EnumType.STRING)
	private Role role;

	@Column(name = "password_flag")
	private boolean passwordFlag;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Embeddable
	private class Address {
		private String flatNo;
		private String wing;
	}

}
