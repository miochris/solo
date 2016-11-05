package com.fdmgroup.market.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class Dog extends Fighter implements Serializable{
	@Column
	private int dBOfBarking;
public Dog(){
	
}
	
public Dog(String name, int nOfW, int nOfL, int speed, double price){
	
	this.setName(name);
	this.setnOfW(nOfW);
	this.setnOfL(nOfL);
	this.setSpeed(speed);
	this.setPrice(price);
	
}


public String getType() {
	return "dog";
}


	@Override
	public String toString() {
		return "Dog [dBOfBarking=" + dBOfBarking + ", getMember()="
				+ getMember() + "]";
	}
	
	


}
