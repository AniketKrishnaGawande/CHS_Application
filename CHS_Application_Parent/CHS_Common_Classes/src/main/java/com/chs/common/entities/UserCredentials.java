package com.chs.common.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserCredentials extends BaseEntity {
	
	@Column(name = "email_id", nullable = false, unique = true)
	private String emailId;
	
	@Column(name = "password", nullable = false, unique = true)
	// add @pattern
	private String password;

}
