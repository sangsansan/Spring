package com.jackie.springmvc.handlers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Country {
	public ArrayList<Nation> GetCountry() {
	 	File filename = new File("Webcontent/country.txt");
	 	InputStreamReader reader =null;
		String line = null;
		
		ArrayList<Nation> list = new ArrayList<Nation>();
		String [] arr = null;
		Nation nation =new Nation();
		try{
	 		reader = new InputStreamReader(new FileInputStream(filename));
	 		BufferedReader brBufferedReader = new BufferedReader(reader);
	 		while((line=brBufferedReader.readLine())!=null){
	 			nation =new Nation();
	 		   	arr = line.split(" ");		   
	 		  	nation.setCountry(arr[3]);
	 		   	nation.setCity(arr[5]);
	 		   	list.add(nation);
	 		    
	 	
	 		}
	 		brBufferedReader.close();
	 	}catch(Exception e){
	 		e.printStackTrace();
	 	}
	 	return list;
	 	
	}
	public static void main(String []args)  {
		String country= "USA";
		Nation nation = new Nation();
		ArrayList<Nation> list = new ArrayList<Nation>();
		Country getcountry =new Country ();
		list = getcountry.GetCountry();
		for (int i =0;i<list.size();i++) {
			if (list.get(i).getCountry().equals(country)) {
				System.out.println("success"+list.get(i));
				nation = list.get(i);
			}
		}
		System.out.println(nation.toString());
	    
		System.out.println("11");
	}

}
