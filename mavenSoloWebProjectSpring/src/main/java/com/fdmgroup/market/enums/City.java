package com.fdmgroup.market.enums;

public  enum City {
	London, NY,TOKYO;
	
	public static City findCity(String city){
	    for(City v : values()){
	        if( v.equals(city)){
	            return v;
	        }
	    }
	    return null;
	}

}
