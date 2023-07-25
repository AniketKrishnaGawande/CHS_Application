package com.chs.member.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Society extends BaseEntity {

	@Column(name = "societ_name", unique = true, nullable = false)
	private String societyName;

	@Embedded
	@Column(nullable = false)
	private Address address;

	@Column(name = "total_members")
	private int totalMembers;

	@Column(name = "registration_number", nullable = false)
	private String socRegNumber;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "chirman_id")
	private Member chairman;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cashier_id")
	private Member cashier;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "board_member_id")
	private Member boardMember;

	@Column(name = "maintanance_amount")
	private double maintananceAmount;

	@Column(name = "verification_status")
	private boolean verificationStatus;

	@Column(name = "active_status")
	private boolean activeStatus;

	@CreationTimestamp
	@Column(name = "registration_date")
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private LocalDate registrationDate;

	@UpdateTimestamp
	@Column(name = "updation_date")
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private LocalDate updationDate;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "society_members_relation")
	private List<Member> members;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Embeddable
	private class Address {
		private String addressLine1;
		private String area;
		private String city;
		private String state;
		private String country;
		private String pinCode;
	}

}
