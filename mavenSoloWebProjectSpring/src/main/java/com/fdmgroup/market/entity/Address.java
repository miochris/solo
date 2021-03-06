package com.fdmgroup.market.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fdmgroup.market.enums.City;

@Entity
@Table(name = "address")
public class Address implements Serializable {
	private static final long serialVersionUID = 9237548239473264L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@OrderBy("id asc")
	@Column
	private int id;
	@Column
	@Enumerated(EnumType.STRING)
	private City city;
	@Column
	private String street;
	@Column
	private String postcode;
	
//	@OneToOne(mappedBy = "address", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OneToOne
	@JoinColumn
	private Member member;

	public Address() {

	}

	public Address(String street, String postcode, City city) {
		this.street = street;
		this.postcode = postcode;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	public void setCity(String city){
		setCity(City.valueOf(city));
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
//		member.setAddress(this);

	}
}
