package com.fdmgroup.market.dao;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.mockito.InOrder;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.market.entity.Cat;
import com.fdmgroup.market.entity.Dog;
import com.fdmgroup.market.entity.Fighter;

public class FighterDAOTest {
	private EntityManager enMg;
	private FighterDAO daoF;
	private Fighter fighter;
	private Cat cat;
	private Dog dog;

	@Before
	public void init() {
		enMg = mock(EntityManager.class);
		daoF = new FighterDAO(enMg);
		fighter = mock(Fighter.class);
	}

	@Test
	public void testAddCat(){
		
		cat=mock(Cat.class);
		
		//
		daoF.addCat(cat);
		//
		verify(enMg).persist(cat);
		
		
	}
	
	@Test
	public void testAddDog(){
		dog=mock(Dog.class);
		//
		daoF.addDog(dog);
		//
		verify(enMg).persist(dog);
	}
	

	
	
	
	
	////////////////////////
	@Test
	public void testDeleteFighter() {
		FighterDAO daoFSpy = spy(daoF);

		doReturn(fighter).when(daoFSpy).getFighter(anyInt());
		daoFSpy.deleteFighter(eq(anyInt()));
		//
		if(fighter != null){
		verify(enMg).remove(fighter);
		}
	}
	
	@Test 
	public void testGetFighter(){
		cat=mock(Cat.class);
		dog=mock(Dog.class);
		when(enMg.find(Cat.class, eq(anyInt()))).thenReturn(cat);
		when(enMg.find(Dog.class, eq(anyInt()))).thenReturn(dog);
		//
		daoF.getFighter(eq(anyInt()));
		verify(enMg).find(Cat.class, eq(anyInt()));
		verify(enMg).find(Dog.class, eq(anyInt()));
		
	}
	
	
	
	@Test
	public void testUpdateFighterPrice(){
		daoF.updateFighterPrice(fighter, anyDouble());
		//
		verify(enMg).merge(fighter);
	}
	
	@Test
	public void testGetAllItems(){
		List<Fighter> allItems=mock(List.class);
		TypedQuery<Fighter> query=mock(TypedQuery.class);
		when(enMg.createQuery(anyString(),eq(Fighter.class))).thenReturn(query);
		when(query.getResultList()).thenReturn(allItems);
		//
		daoF.getAllItems();
		//
		verify(enMg).createQuery(anyString(),eq(Fighter.class));
	}
	
	@Test
	public void testSetNumOfWin(){
		
	daoF.setNumOfWin(fighter, anyInt());
	//
	verify(enMg).merge(anyInt());
	}
	
	@Test
	public void testSetNumOfLost(){
		
	daoF.setNumOfLost(fighter, anyInt());
	//
	verify(enMg).merge(anyInt());
	}
	
	@Test
	public void testFightWin(){
		Fighter mockMyFighter=mock(Fighter.class);
		Fighter mockFighterToFight=mock(Fighter.class);
		boolean result=true;
//		when(randomWithProbability(((Integer)mockMyFighter.getStrehgth()).doubleValue()/((Integer)mockFighterToFight.getStrehgth()).doubleValue()).thenReturn(true);
		
		//
		daoF.fight(mockMyFighter, mockFighterToFight);
		verify(enMg,times(2)).merge(mockMyFighter);
		
	}
	
	


	@Test
	public void testChangeFighterPriceWin(){
		Fighter mockMyFighter=mock(Fighter.class);
		Fighter mockFighterToFight=mock(Fighter.class);
		boolean result=true;
		//
		daoF.changeFighterPrice(mockMyFighter, mockFighterToFight, result);
		//
		verify(enMg).merge(mockMyFighter);
		verify(enMg).merge(mockFighterToFight);
	}
	
	@Test
	public void testChangeFighterPriceLose(){
		Fighter mockMyFighter=mock(Fighter.class);
		Fighter mockFighterToFight=mock(Fighter.class);
		boolean result=false;
		//
		daoF.changeFighterPrice(mockMyFighter, mockFighterToFight, result);
		//
		verify(enMg).merge(mockMyFighter);
		verify(enMg).merge(mockFighterToFight);
	}
	
	@Test
	public void testUpdateRecordWin(){
		Fighter mockMyFighter=mock(Fighter.class);
		Fighter mockFighterToFight=mock(Fighter.class);
		Boolean result=true;
		
		daoF.updateRecord(mockMyFighter, mockFighterToFight, result);
		
		verify(mockMyFighter).getnOfW();
		verify(mockFighterToFight).getnOfL();
		verify(enMg).merge(mockMyFighter);
		verify(enMg).merge(mockFighterToFight);
		
		
	}
	
	@Test
	public void testUpdateRecordLost(){
		Fighter mockMyFighter=mock(Fighter.class);
		Fighter mockFighterToFight=mock(Fighter.class);
		Boolean result=false;
		
		daoF.updateRecord(mockMyFighter, mockFighterToFight, result);
		
		verify(mockMyFighter).getnOfL();
		verify(mockFighterToFight).getnOfW();
		verify(enMg).merge(mockMyFighter);
		verify(enMg).merge(mockFighterToFight);
		
		
	}
	
}
