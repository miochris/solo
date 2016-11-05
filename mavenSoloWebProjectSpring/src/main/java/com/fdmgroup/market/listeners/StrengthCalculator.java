package com.fdmgroup.market.listeners;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.apache.log4j.Logger;

import com.fdmgroup.market.entity.Fighter;

public class StrengthCalculator {
	public static final Logger LOG = Logger
			.getLogger(StrengthCalculator.class);
	
	@PrePersist
	@PreUpdate
	private void calculator(Fighter fighter){
		
		
		int strength= (10*fighter.getnOfW()+3*fighter.getnOfL())*fighter.getSpeed()*5;
		
		
		fighter.setStrength(strength);
		
		
	}

}
