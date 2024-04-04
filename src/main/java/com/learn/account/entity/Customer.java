package com.learn.account.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer extends BaseEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "customer_id")
	private Long customerId;
	private String name;
	private String email;
	@Column(name = "mobile_number")
	private String mobileNumber;

}
