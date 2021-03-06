package com.fdmgroup.market;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import com.fdmgroup.market.dao.AddressDAO;
import com.fdmgroup.market.dao.FighterDAO;
import com.fdmgroup.market.dao.MemberDAO;
import com.fdmgroup.market.entity.Address;
import com.fdmgroup.market.entity.Cat;
import com.fdmgroup.market.entity.Dog;
import com.fdmgroup.market.entity.Fighter;
import com.fdmgroup.market.entity.Member;
import com.fdmgroup.market.enums.City;
import com.fdmgroup.market.enums.Role;

public class DAOController {
	public static final Logger LOG = Logger.getLogger(DAOController.class);

	static EntityManagerFactory enMgFac = Persistence
			.createEntityManagerFactory("JPADemoPersistence");

	public DAOController() {

	}

	FighterDAO daoF = new FighterDAO();
	MemberDAO daoM = new MemberDAO();
	AddressDAO daoA = new AddressDAO();
	
	
//	FighterDAO daoF = new FighterDAO(enMgFac);
//	MemberDAO daoM = new MemberDAO(enMgFac);
//	AddressDAO daoA = new AddressDAO(enMgFac);

	// public Fighter findFighter(int fId) {
	// tx.begin();
	// Fighter fighter = daoF.getFighter(fId);
	//
	// tx.commit();
	// enMg.close();
	// enMgFac.close();
	// LOG.info("fighter found " + fighter.toString());
	// return fighter;
	// }

	// public void addMember(Member member) {
	// // tx.begin();
	// // Member member = new Member(name, balance);
	// System.out.println("**************************1");
	// System.out.println(member);
	// System.out.println(enMg);
	// daoM.addNewMember(member);
	// // tx.commit();
	// // enMg.close();
	// // enMgFac.close();
	// System.out.println("**************************2");
	// LOG.info(member.toString() + " added");
	// }

	public void addCat(Cat cat) {
		// String name, int nOfW, int nOfL, int speed, double price
		// Cat cat = new Cat(name, nOfW, nOfL, speed, price);
		daoF.addCat(cat);
		LOG.info(cat.toString() + " added");
	}

	//
	public void addDog(Dog dog) {
		// String name, int nOfW, int nOfL, int speed, double price
		// Dog dog = new Dog(name, nOfW, nOfL, speed, price);
		daoF.addDog(dog);
		LOG.info(dog.toString() + " added");
	}

	//
	//
	// public void setBalance(int mId, int newBalance){
	// Member member=daoM.getMemberById(mId);
	// daoM.setBalance(member, newBalance);
	//
	// }
	// public void addBalance(int mId, int deposit){
	// Member member=daoM.getMemberById(mId);
	// daoM.setBalance(member, daoM.getMemberById(mId).getBalance()+deposit);
	//
	// }
	//
	//
	//
	//
	// //
	// // public static List<Item> listAllItem() {
	// //
	// // ItemDAO daoI = new ItemDAO(factory);
	// // List<Item> allItems = new ArrayList<Item>();
	// // return allItems = daoI.getAllItems();
	// // }
	// //
	// // public static List<Item> listAllAvailableItem() {
	// //
	// // ItemDAO daoI = new ItemDAO(factory);
	// // List<Item> allAvailableItems = daoI.getAllAvailableItems();
	// // return allAvailableItems;
	// //
	// // }
	// //
	public void sendFighterToMember(int fId, int mId) {
		// Fighter fighter = daoF.getFighter(fId);
		// Member member = daoM.getMemberById(mId);
		//
		// daoM.addFighterToNewMember(fighter, member);

		daoM.addFighterToNewMember(daoF.getFighter(fId),
				daoM.getMemberById(mId));

	}

	public void buyFighter(Fighter fighterToBuy, Member member) {
		LOG.info("fighter's price is **********  " + fighterToBuy.getPrice());
		daoM.addFighterToNewMember(fighterToBuy, member);
		daoM.changeMemberBalance(member, -fighterToBuy.getPrice());
		daoM.changeMemberBalance(fighterToBuy.getMember(),
				fighterToBuy.getPrice());

	}

	//
	// //
	// public Member findMember(int mId) {
	// Member member = daoM.getMemberById(mId);
	// LOG.info(member.toString());
	// return member;
	// }
	//
	//
	//
	// public void fight(int f1Id, int f2Id) {
	// boolean
	// result=calculateFightResult(daoF.getFighter(f1Id),daoF.getFighter(f2Id));
	// daoM.changeBalanceAfterFight(daoF.getFighter(f1Id).getMember(),daoF.getFighter(f2Id).getMember(),result);
	// daoF.changeFighterRecord(daoF.getFighter(f1Id),daoF.getFighter(f2Id),result);
	// daoF.changeFighterPrice(daoF.getFighter(f1Id),daoF.getFighter(f2Id),result);
	// }
	// // TODO
	// private boolean calculateFightResult(Fighter fighter, Fighter fighter2) {
	//
	// return true;
	// }
	//
	// public List<Fighter> listMemberFighter(int mId) {
	// List<Fighter> fighterList=daoM.getMemberById(mId).getFighterList();
	//
	//
	// return fighterList;
	//
	//
	// }
	//
	// public List<Fighter> listFightersOfCity(String city) {
	// City city2=City.findCity(city);
	// List<Fighter> fightersInSameCity=null;
	//
	//
	//
	//
	//
	// return fightersInSameCity;
	//
	// }
//	public void addMemberWithAddressDoB(String name, double balance,
//			String street, String postcode, City city, String yyyyMMdd,
//			String password, Role role) {
//		Member member = new Member(name, balance);
//		Address address = new Address(street, postcode, city);
//
//		Date date = parseDate(yyyyMMdd);
//		member.setDateOfBirth(date);
//		member.setRole(role);
//		member.setPassword(password);
//		daoM.addNewMember(member);
//		// member.setAddress(address);
//		// daoA.addAddressToMember(address, member);
//		daoM.addAddressToMember(address, member);
//
//	}

	private Date parseDate(String yyyyMMdd) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		java.util.Date parsed = null;
		try {
			parsed = format.parse(yyyyMMdd);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date sql = new java.sql.Date(parsed.getTime());
		return sql;
	}

	public void listMembersInOneCity(String city) {
		daoM.listMembersInOneCity(city);

	}

	public void listFightersInOneCity(String city) {
		daoM.FightersInOneCity(city);

	}

}
