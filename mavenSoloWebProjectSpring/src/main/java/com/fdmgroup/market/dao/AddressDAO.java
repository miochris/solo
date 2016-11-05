package com.fdmgroup.market.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fdmgroup.market.entity.Address;
import com.fdmgroup.market.entity.Member;
import com.fdmgroup.market.enums.City;

public class AddressDAO {

	@PersistenceContext
	private EntityManager enMg;

	public AddressDAO() {
	}

	public AddressDAO(EntityManager enMg) {
		this.enMg = enMg;
	}

	@Transactional
	public void addAddress(Address address) {
		enMg.persist(address);
	}

	@Transactional
	public Address getAddressById(int aId) {
		Address address = enMg.find(Address.class, aId);
		return address;
	}

	@Transactional
	public void updateAddress(Address address) {
		enMg.merge(address);
	}

	@Transactional
	public void addAddressToMember(Address address, Member member) {
		address.setMember(member);
		enMg.merge(address);
	}

}
