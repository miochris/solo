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

public class AdminControllerTest {
	private EntityManager enMg;
	private MemberDAO daoM;
	private AddressDAO daoA;
	private AdminController aC;
	private Model mockModel;
	private Member mockMember;
	private Address mockAddress;

	@Before
	public void init() {
		enMg = mock(EntityManager.class);
		daoM = mock(MemberDAO.class);
		daoA = mock(AddressDAO.class);
		aC = new AdminController(daoM, daoA);
		mockModel = mock(Model.class);
		mockMember = mock(Member.class);
		mockAddress = mock(Address.class);
	}

	// /////////////////////////////
	// //////////////////////////
	@Test
	public void testGrepLoginName() { 
		HttpServletRequest request = mock(HttpServletRequest.class);
		String userName="dao";
		when(request.getUserPrincipal().getName()).thenReturn(userName);
		//
HttpSession mockSession=mock(HttpSession.class);
when(request.getSession()).thenReturn(mockSession);
		aC.grepLoginName(request);
		//
		verify(mockSession).setAttribute("userName", userName);
	}
///////////////////////
	
	@Test
	public void testGoToAdminHome(){
		
		String result=	aC.goToAdminHome();
		assertEquals("admin/AdminHome", result);
		
		
		
	}
	
	@Test
	public void testGoToRegistrationPage() {
		aC.goToRegistrationPage(mockModel, mockMember, mockAddress);
		
		verify(mockModel).addAttribute("member", new Member());

	}

	@Test
	public void testAdminAddMember() {
		aC.adminAddMember(mockModel, mockMember);
		
		verify(daoM).addNewMember(mockMember);
	}
	@Test
	public void testShowAllMemmbers(){
		HttpServletRequest request = mock(HttpServletRequest.class);
		List<Member> memberList=mock(List.class);
		when(daoM.showAllMembers()).thenReturn(memberList);
		//
		String result=aC.showAllMemmbers(request);
		//
		assertEquals("admin/memberList", result);
	}
	
	
	
	
	@Test
	public void testShowAllFighters(){
		HttpServletRequest request = mock(HttpServletRequest.class);
		List<Fighter> AllFighterList=mock(List.class);
		when(daoM.listAllFighters()).thenReturn(AllFighterList);
		HttpSession mockSession = mock(HttpSession.class);
		when(request.getSession()).thenReturn(mockSession);
		String result=aC.showAllFighters(request);
		verify(mockSession).setAttribute("fighterList", AllFighterList);
		
		
	}
	
	
	@Test
	public void testShowAllFightersInLondon(){
		List<Fighter> AllfighersInOneCity =mock(List.class);
		when(daoM.FightersInOneCity("London")).thenReturn(AllfighersInOneCity);
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpSession mockSession = mock(HttpSession.class);
		when(request.getSession()).thenReturn(mockSession);
		
		String result=aC.showAllFightersInLondon(request);
		
		verify(mockSession).setAttribute("AllfighersInOneCity",
				AllfighersInOneCity);
		assertEquals(result,"admin/fightersInOneCity");
		
	}
	
	@Test
	public void testShowAllFightersInNY(){
		List<Fighter> AllfighersInOneCity =mock(List.class);
		when(daoM.FightersInOneCity("NY")).thenReturn(AllfighersInOneCity);
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpSession mockSession = mock(HttpSession.class);
		when(request.getSession()).thenReturn(mockSession);
		
		String result=aC.showAllFightersInNY(request);
		
		verify(mockSession).setAttribute("AllfighersInOneCity",
				AllfighersInOneCity);
		assertEquals(result,"admin/fightersInOneCity");
		
	}
	
	@Test
	public void testShowAllFightersInTOKYO(){
		List<Fighter> AllfighersInOneCity =mock(List.class);
		when(daoM.FightersInOneCity("TOKYO")).thenReturn(AllfighersInOneCity);
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpSession mockSession = mock(HttpSession.class);
		when(request.getSession()).thenReturn(mockSession);
		
		String result=aC.showAllFightersInTOKYO(request);
		
		verify(mockSession).setAttribute("AllfighersInOneCity",
				AllfighersInOneCity);
		assertEquals(result,"admin/fightersInOneCity");
		
	}
	
	
	@Test
	public void tstChooseMemberId(){
		HttpServletRequest request = mock(HttpServletRequest.class);
		List<Integer> memberListNum =mock(List.class);
		HttpSession mockSession = mock(HttpSession.class);
		when(daoM.showAllMembersID()).thenReturn(memberListNum);
		when(request.getSession()).thenReturn(mockSession);
		String result=aC.chooseMemberId(request,mockModel,mockMember);
		verify(mockSession).setAttribute("memberListNum", memberListNum);
		assertEquals(result,"admin/memberId");
		
	}
	
	@Test
	public void testShowOneMembersFighters(){
		HttpServletRequest request = mock(HttpServletRequest.class);
		when(daoM.getMemberById(anyInt())).thenReturn(mockMember);
		List<Fighter> OneMembersFighterList =mock(List.class);
		when(daoM.listAllFightersofOneMember(anyString())).thenReturn(OneMembersFighterList);
		HttpSession mockSession = mock(HttpSession.class);
		when(request.getSession()).thenReturn(mockSession);
		String result=aC.showOneMembersFighters(request, mockModel, mockMember, Integer.toString(anyInt()));
		
		verify(mockSession).setAttribute("OneMembersFighterList",
				OneMembersFighterList);
		assertEquals("admin/OneMembersFighterList", result);
		
		
		
	}
	
	
	@Test
	public void testLogOut(){
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpSession mockSession = mock(HttpSession.class);
		when(request.getSession()).thenReturn(mockSession);
		String result=aC.logout(request);
		verify(mockSession).invalidate();
		assertEquals("index",result);
		
	}

}
