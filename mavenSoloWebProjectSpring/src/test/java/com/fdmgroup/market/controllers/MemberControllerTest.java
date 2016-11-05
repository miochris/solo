package com.fdmgroup.market.controllers;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.Model;

import com.fdmgroup.market.dao.AddressDAO;
import com.fdmgroup.market.dao.MemberDAO;
import com.fdmgroup.market.entity.Address;
import com.fdmgroup.market.entity.Fighter;
import com.fdmgroup.market.entity.Member;

public class MemberControllerTest {
	private EntityManager enMg;
	private MemberDAO daoM;
	private AddressDAO daoA;
	private MemberController mC;
	private Model mockModel;
	private Member mockMember;
	private Address mockAddress;
	@Before
	public void init(){
		enMg = mock(EntityManager.class);
		daoM = mock(MemberDAO.class);
		daoA = mock(AddressDAO.class);
		mC = new MemberController(daoM, daoA);
		mockModel = mock(Model.class);
		mockMember = mock(Member.class);
		mockAddress = mock(Address.class);
		
		
	}
	
	@Test
	public void testAddFighterDog(){
		
		
		
	}
	
	
	@Test
	public void testLogOut(){
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpSession mockSession = mock(HttpSession.class);
		when(request.getSession()).thenReturn(mockSession);
		String result=mC.logout(request);
		verify(mockSession).invalidate();
		assertEquals(result,"index");
		
	}

}
