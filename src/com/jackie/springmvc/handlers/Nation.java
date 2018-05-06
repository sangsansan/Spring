package com.jackie.springmvc.handlers;

import java.util.ArrayList;
import java.util.List;

public class Nation {
	String country;
	String city;
	List<Province> prvince;
	
	
	public List<Province> getPrvince() {
		return prvince;
	}
	public void setPrvince(List<Province> prvince) {
		this.prvince = prvince;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String toString() {
		return "country"+country+"city"+city;
	}

}
