package com.fdmgroup.market.listeners;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

import com.fdmgroup.market.entity.Member;

public class AgeCalculatorListener {
	@PostLoad
	@PostPersist
	@PostUpdate
	public void calculateAge(Member member) {
		if(member.getDateOfBirth()==null){
			member.setAge(null);
			return;
		}
		Calendar birth = new GregorianCalendar();
		birth.setTime(member.getDateOfBirth());
		Calendar now = new GregorianCalendar();
		now.setTime(new Date());
		int adjust = 0;
		if (now.get(Calendar.DAY_OF_YEAR) - birth.get(Calendar.DAY_OF_YEAR) < 0) {
			adjust = -1;
		}
		member.setAge(now.get(Calendar.YEAR) - birth.get(Calendar.YEAR) + adjust);
				
	}

}
