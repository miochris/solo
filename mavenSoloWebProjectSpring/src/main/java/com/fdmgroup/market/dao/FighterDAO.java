package com.fdmgroup.market.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fdmgroup.market.entity.Cat;
import com.fdmgroup.market.entity.Dog;
import com.fdmgroup.market.entity.Fighter;

@Component
public class FighterDAO {
	public static final Logger LOG = Logger.getLogger(FighterDAO.class);

	@PersistenceContext
	private EntityManager enMg;

	public FighterDAO() {
	}

	public FighterDAO(EntityManager enMg) {
		this.enMg = enMg;
	}

	@Transactional
	public void addCat(Cat cat) {
		enMg.persist(cat);
		LOG.info(cat);

	}

	@Transactional
	public void addDog(Dog dog) {
		enMg.persist(dog);
		LOG.info(dog);

	}

	@Transactional
	public void deleteFighter(int fId) {

		Fighter fighter = getFighter(fId);
		if (fighter != null) {
			enMg.remove(fighter);
			LOG.info("fighter removed");
		}

	}

	@Transactional
	public Fighter getFighter(int id) {
		Fighter fighter = null;
		Fighter cat = enMg.find(Cat.class, id);
		Fighter dog = enMg.find(Dog.class, id);
		if (cat != null) {
			fighter = cat;

		} else if (dog != null) {
			fighter = dog;
		}
		return fighter;

	}

	@Transactional
	public void updateFighterPrice(Fighter fighter, double price) {
		fighter.setPrice(price);
		enMg.merge(fighter);
		LOG.info("fighter   's new price is: " + price);
	}

	@Transactional
	public List<Fighter> getAllItems() {
		List<Fighter> allItems = null;
		TypedQuery<Fighter> query = enMg.createQuery("select i from Item i",
				Fighter.class);
		allItems = query.getResultList();
		// for (Fighter i : allItems) {
		// System.out.println(i);
		// }
		return allItems;
	}

	@Transactional
	protected void setNumOfWin(Fighter fighter, int record) {
		fighter.setnOfW(record);
		enMg.merge(fighter);
	}

	@Transactional
	protected void setNumOfLost(Fighter fighter, int record) {
		fighter.setnOfL(record);
		enMg.merge(fighter);
	}

	@Transactional
	public void fight(Fighter myFighter, Fighter fighterToFight) {
		boolean result = randomWithProbability(((Integer)myFighter.getStrength()).doubleValue()/((Integer)fighterToFight.getStrength()).doubleValue());
		changeFighterPrice(myFighter, fighterToFight, result);
		updateRecord(myFighter, fighterToFight, result);

	}
	private boolean randomWithProbability(double probabilityTrue) {
		return Math.random() >= 1.0 - probabilityTrue;
	}

	@Transactional
	public void changeFighterPrice(Fighter myFighter, Fighter fighterToFight,
			boolean result) {
		if (result) {
			updateFighterPrice(myFighter, myFighter.getPrice() * 1.1);
			updateFighterPrice(fighterToFight, fighterToFight.getPrice() * 0.9);

		} else {
			updateFighterPrice(myFighter, myFighter.getPrice() * 0.9);
			updateFighterPrice(fighterToFight, fighterToFight.getPrice() * 1.1);
		}
	}

	@Transactional
	protected void updateRecord(Fighter myFighter, Fighter fighterToFight,
			Boolean result) {
		if (result) {
			setNumOfWin(myFighter, myFighter.getnOfW() + 1);
			setNumOfLost(fighterToFight, fighterToFight.getnOfL() + 1);
		} else {
			setNumOfWin(myFighter, myFighter.getnOfL() + 1);
			setNumOfLost(fighterToFight, fighterToFight.getnOfW() + 1);
		}
	}
}
