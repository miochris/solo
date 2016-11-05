package com.fdmgroup.market.dao;

import static org.mockito.Matchers.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.market.entity.Address;
import com.fdmgroup.market.entity.Member;

public class AddressDaoTest {
	private EntityManager enMg;
	AddressDAO daoA;

	private Address address;
	private Member member;

	@Before
	public void init() {
		enMg = mock(EntityManager.class);
		daoA = new AddressDAO(enMg);
		address = mock(Address.class);
	}

	@Test
	public void testAddAddress() {
		//
		//
		daoA.addAddress(address);
		//
		verify(enMg).persist(address);

	}

	@Test
	public void testGetAddressById() {
		//
		when(enMg.find(Address.class, eq(anyInt()))).thenReturn(address);
		//
		daoA.getAddressById(eq(anyInt()));
		//
		verify(enMg).find(Address.class, eq(anyInt()));

	}

	@Test
	public void testUpdateAddress() {

		daoA.updateAddress(address);
		//
		verify(enMg).merge(address);
	}

	@Test
	public void testAddAddressToMember() {

		member = mock(Member.class);
		//
		daoA.addAddressToMember(address, member);
		//
		verify(enMg).merge(address);

	}
}
