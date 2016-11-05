package com.fdmgroup.market.dao;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.market.entity.Address;
import com.fdmgroup.market.entity.Fighter;
import com.fdmgroup.market.entity.Member;
import com.fdmgroup.market.enums.City;

public class MemberDAOTest {
	private EntityManager enMg;
	MemberDAO daoM;

	private Fighter fighter; 
	private Member member;

	@Before
	public void init() {
		enMg = mock(EntityManager.class);
		daoM = new MemberDAO(enMg);
	}

	@Test
	public void testAddNewMemberCallsPersist() {
		// Arrange
		member = mock(Member.class);
		// Act
		daoM.addNewMember(member);
		// Assert
		verify(enMg, times(1)).persist(member);
	}

	@Test
	public void testGetMemberByIdCallsFind() {
		// Act
		int id = 0;
		daoM.getMemberById(id);
		// Assert
		verify(enMg, times(1)).find(Member.class, id);

	}

	@Test
	public void testAddFighterToNewMemberCalls2Methods() {
		// Arrange
		fighter = mock(Fighter.class);
		member = mock(Member.class);
		// Act
		daoM.addFighterToNewMember(fighter, member);
		// Assert
		verify(member, times(1)).addFighter(fighter);
		verify(enMg, times(1)).merge(member);

	}

	@Test
	public void testShowListOfFighters() {
		// Arrange
		List<Fighter> mockFighterList = mock(List.class);
		member = mock(Member.class);
		when(enMg.find(Member.class, eq(anyInt()))).thenReturn(member);
		when(member.getFighterList()).thenReturn(mockFighterList);
		// Act
		daoM.showListOfFighters(eq(anyInt()));

		// Assert
		verify(enMg, times(1)).find(Member.class, eq(anyInt()));

	}

	@Test
	public void testChangeBalanceAfterFighterCallsChangeMemberBalance() {
		// Arrange
		Member mockMember1 = mock(Member.class);
		Member mockMember2 = mock(Member.class);
		// Act
		daoM.changeBalanceAfterFight(mockMember1, mockMember2, true);

		// Assert
		verify(enMg).merge(mockMember1);
		verify(enMg).merge(mockMember2);
	}

	@Test
	public void testChangeMemberBalanceCallsMerge() {
		member = mock(Member.class);
		double gain = 100;

		daoM.changeMemberBalance(member, 200);

		verify(enMg).merge(member);

	}

	@Test
	public void testListMembersInOneCity() {
		String city = "NY";
		Query query = mock(Query.class);
		when(enMg.createNativeQuery(anyString())).thenReturn(query);

		daoM.listMembersInOneCity(city);

		verify(enMg).createNativeQuery(anyString());

	}

	@Test
	public void testListFightersInOneCity() {
		String city = "NY";
		TypedQuery<Fighter> query = mock(TypedQuery.class);
		List<Fighter> fightersInOneCity = mock(List.class);

		when(enMg.createQuery(anyString(), eq(Fighter.class)))
				.thenReturn(query);
		when(query.getResultList()).thenReturn(fightersInOneCity);

		daoM.FightersInOneCity(city);

		verify(enMg).createQuery(anyString(), eq(Fighter.class));

	}

	@Test
	public void testFightersInYourCity() {
		// A
		TypedQuery<Fighter> query = mock(TypedQuery.class);
		List<Fighter> fighersInYourCity = mock(List.class);
		when(enMg.createQuery(anyString(), eq(Fighter.class)))
				.thenReturn(query);
		when(query.getResultList()).thenReturn(fighersInYourCity);
		// A
		daoM.FightersInYourCity(any(City.class), anyInt());
		// A
		verify(enMg).createQuery(anyString(), eq(Fighter.class));

	}

	@Test
	public void testShowAllMembers() {
		//
		TypedQuery<Member> query = mock(TypedQuery.class);
		List<Member> memberList = mock(List.class);
		when(enMg.createQuery(anyString(), eq(Member.class))).thenReturn(query);
		//
		daoM.showAllMembers();
		//
		verify(enMg).createQuery(anyString(), eq(Member.class));

	}

	@Test
	public void testListAllFIghters() {
		//
		TypedQuery<Fighter> query = mock(TypedQuery.class);
		List<Fighter> fighterList = mock(List.class);
		when(enMg.createQuery(anyString(), eq(Fighter.class)))
				.thenReturn(query);
		when(query.getResultList()).thenReturn(fighterList);
		//
		daoM.listAllFighters();
		//
		verify(enMg).createQuery(anyString(), eq(Fighter.class));

	}

	// //////////////////////////////////////
	// ////////////////////////////////////////
	// @Test
	// public void testListAllFightersofOneMember(){
	// //
	// member=mock(Member.class);
	// List<Fighter> fighterList =mock(List.class);
	// TypedQuery<Fighter> query = mock(TypedQuery.class);
	// when(query.getResultList()).thenReturn(fighterList);
	// when(daoM.getMemberById(eq(anyInt())).t
	// when(enMg.createQuery(anyString(),eq(Fighter.class))).thenReturn(query);
	// //
	// daoM.listAllFightersofOneMember(anyString());
	// //
	// verify(enMg).createQuery(anyString(),eq(Fighter.class));
	//
	// }

	@Test
	public void testAddAddressToMember() {

		Address address = mock(Address.class);
		member = mock(Member.class);
		//
		daoM.addAddressToMember(address, member);
		//
		verify(enMg).merge(member);

	}
	
	@Test
	public void testGetMemberByName (){
		member=mock(Member.class);
		TypedQuery<Member> query=mock(TypedQuery.class);
		when(enMg.createQuery(anyString(),eq(Member.class))).thenReturn(query);
		when(query.getSingleResult()).thenReturn(member);
		
		daoM.getMemberByName(eq(anyString()));
		
		verify(enMg).createQuery(anyString(),eq(Member.class));
		
	}
	
	@Test
	public void testBuyFighter(){
		double balanceBeforeFight=3;
		when(member.getBalance()).thenReturn(balanceBeforeFight);
		Fighter mockFighterToBuy=mock(Fighter.class);
		daoM.buyFighter(mockFighterToBuy, member);
		verify(enMg).merge(member);
		
		
	}
	
	
	@Test
	public void testShowAllMembersID(){
		TypedQuery<Member> query=mock(TypedQuery.class);
		when(enMg.createQuery(anyString(),eq(Member.class))).thenReturn(query);
		List<Member> memberList=mock(List.class);
		List<Integer> memberListNum = mock(List.class);
		
		//
		daoM.showAllMembersID(); 
		//
		verify(enMg).createQuery(anyString(),eq(Member.class));
	}		
		////////////////////////
	///////////////////////////////
		@Test
		public void testShowALlMembersID(){
			
			TypedQuery<Member> query=mock(TypedQuery.class);
			when(enMg.createQuery(anyString(),eq(Member.class))).thenReturn(query);
			List<Member> memberList= new ArrayList<Member>();
			
			when(query.getResultList()).thenReturn(memberList);
			List<Integer> memberListNum =mock(List.class);
			memberListNum=daoM.showAllMembersID();
			//
			verify(enMg).createQuery(anyString(),eq(Member.class));
			
		
	}

}
