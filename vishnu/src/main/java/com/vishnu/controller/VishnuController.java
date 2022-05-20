package com.vishnu.controller;

import java.util.*;

import com.vishnu.entity.VishnuUser;
import com.vishnu.service.VishnuServiceInterface;
import com.vishnu.sort.SortByName;
import com.vishnu.utility.ServiceFactory;

public class VishnuController implements VishnuControllerInterface {
	
	VishnuServiceInterface vs = null;
	
	public VishnuController() {
		vs = ServiceFactory.createObject();
	}
	
	public void createProfileController() {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Name: ");
		String name = sc.next();
		
		System.out.println("Enter Password: ");
		String password = sc.next();
		
		System.out.println("Enter Email: ");
		String email = sc.next();
		
		System.out.println("Enter Address: ");
		String address = sc.next();
		
		VishnuUser vu = new VishnuUser();
		vu.setName(name);
		vu.setPassword(password);
		vu.setEmail(email);
		vu.setAddress(address);
		
		int i = vs.createProfileService(vu);
		
		if(i>0) {
			System.out.println("Your Profile is created "+name);
		}
		
		else {
			System.out.println("Sorry..... Your Profile is not created");
		}

	}

	public void deleteProfileController() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Email: ");
		String email = sc.next();
		
		VishnuUser vu = new VishnuUser();
		vu.setEmail(email);
		
		int i = vs.deleteProfileService(vu);
		
		if(i>0) {
			System.out.println("Profile is deleted");
		}
		
		else {
			System.out.println("Profile is not deleted");
		}
		
	}

	public void viewProfileController() {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Email: ");
		String email = sc.next();
		
		VishnuUser vu = new VishnuUser();
		vu.setEmail(email);
		
		VishnuUser i = vs.viewProfileService(vu);
		
		if(i!=null) {
			
			System.out.println("**********");
			System.out.println("Your name is "+i.getName());
			System.out.println("Your Password is "+i.getPassword());
			System.out.println("Your Email is "+i.getEmail());
			System.out.println("Your Address is "+i.getAddress());
			System.out.println("**********");
			
		}
		
		else {
			System.out.println("No Record Found");
		}
		
	}

	public void viewAllProfilesController() {
		
		List<VishnuUser> ll = vs.viewAllProfilesService();
		
		System.out.println(ll.size()+" records found in the database");
		
		/*for(VishnuUser l:ll) {
			
			System.out.println("**********");
			System.out.println("Name is "+l.getName());
			System.out.println("Password is "+l.getPassword());
			System.out.println("Email is "+l.getEmail());
			System.out.println("Address is "+l.getAddress());
			System.out.println("**********");
			
		}*/
		
		ll.forEach(p->{
			
			System.out.println("**********");
			System.out.println("Name is "+p.getName());
			System.out.println("Password is "+p.getPassword());
			System.out.println("Email is "+p.getEmail());
			System.out.println("Address is "+p.getAddress());
			System.out.println("**********");
			
		});
		
		Collections.sort(ll,new SortByName());
		System.out.println("After Sorting");
		
		ll.forEach(p->{
			
			System.out.println("**********");
			System.out.println("Name is "+p.getName());
			System.out.println("Password is "+p.getPassword());
			System.out.println("Email is "+p.getEmail());
			System.out.println("Address is "+p.getAddress());
			System.out.println("**********");
			
		});
		
	}

	
	public void searchProfileController() {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Name :");
		String name = sc.next();
		
		VishnuUser vu = new VishnuUser();
		vu.setName(name);
		
		List<VishnuUser> i = vs.searchProfileService(vu);
		
		System.out.println(i.size()+" records found in the database");
		
		//if(i!=null) {
			
			i.forEach(p->{
				
				System.out.println("**********");
				System.out.println("Name is "+p.getName());
				System.out.println("Password is "+p.getPassword());
				System.out.println("Email is "+p.getEmail());
				System.out.println("Address is "+p.getAddress());
				System.out.println("**********");
				
			});
			
		//}
		
		/*else {
			System.out.println("Cannot search Profile");
		}*/
		
	}

	public void editProfileController() {

		System.out.println("Your Older Data");
		viewProfileController();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter new Name: ");
		String name = sc.next();
		
		System.out.println("Enter new Password: ");
		String password = sc.next();
		
		System.out.println("Enter old Email: ");
		String email = sc.next();
		
		System.out.println("Enter new Address: ");
		String address = sc.next();
		
		VishnuUser vu = new VishnuUser();
		vu.setName(name);
		vu.setPassword(password);
		vu.setEmail(email);
		vu.setAddress(address);
		
		int i = vs.editProfileService(vu);
		
		if(i>0) {
			System.out.println("Your Profile is edited "+name);
		}
		
		else {
			System.out.println("Sorry..... Your Profile is not edited");
		}
		
		
		
	}

}
