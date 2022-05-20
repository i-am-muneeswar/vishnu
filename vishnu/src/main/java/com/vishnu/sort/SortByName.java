package com.vishnu.sort;

import java.util.Comparator;

import com.vishnu.entity.VishnuUser;

public class SortByName implements Comparator<VishnuUser> {

	@Override
	public int compare(VishnuUser n1, VishnuUser n2) {

		
		return n1.getName().compareTo(n2.getName());
		
	}
	
	

}
