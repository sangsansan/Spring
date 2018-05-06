package com.jackie.springmvc.handlers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class GetCountry {
	
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
	 		   	//System.out.println(line);
	 		   	System.out.println(arr[3]+":"+arr[5]);
	 		   	nation.setCountry(arr[3]);
	 		   	nation.setCity(arr[5]);
	 		   	
	 		   System.out.println(nation.toString());
//	 		   for (int index=0;index<line.length();index++) {
//	 			  list.add(index, nation);
//	 		   }
	 		    list.add(nation);
	 		    
	 	
	 		}
	 		
	 	System.out.println("11"+list.get(0).getCountry());	
	 	System.out.println("22"+list.get(1).getCountry());	
	 	
	 		
	 		
	 		brBufferedReader.close();
	 	}catch(Exception e){
	 		e.printStackTrace();
	 	}
	 	return list;
	 	
	}
	public static void main(String []args)  {
		String country= "USA";
		ArrayList<Nation> list = new ArrayList<Nation>();
		GetCountry getcountry =new GetCountry ();
		list = getcountry.GetCountry();
		for (int i =0;i<list.size();i++) {
			if (list.get(i).getCountry().equals(country)) {
				System.out.println("success"+list.get(i));
			}
		}
	    
		System.out.println("11");
		
		
//		System.out.println("11"+hashMap.keySet());
//		if (hashMap.keySet().contains(country)){
//			System.out.println("11");
//		}
		//System.out.println(hashMap);
	}

}
