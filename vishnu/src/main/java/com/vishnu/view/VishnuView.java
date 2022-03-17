package com.vishnu.view;

import java.util.Scanner;

import com.vishnu.controller.VishnuControllerInterface;
import com.vishnu.utility.ControllerFactorty;

public class VishnuView {

	public static void main(String[] args) {
		
		String s = "y";
		
		Scanner sc = new Scanner(System.in);
		
		while(s.equals("y")) {
			
			System.out.println("********************");
			System.out.println("Main Menu");
			System.out.println("********************");
			System.out.println("Press 1 to Create Profile");
			System.out.println("Press 2 to Delete Profile");
			System.out.println("Press 3 to View Profile");
			System.out.println("Press 4 to View All Profiles");
			System.out.println("Press 5 to Search Profiles");
			System.out.println("Press 6 to Edit Profile");
			
			System.out.println("Enter your choice: ");
			int ch = sc.nextInt();
			
			VishnuControllerInterface vc = ControllerFactorty.createObject();
			
			switch(ch) {
				case 1:
					vc.createProfileController();
					break;
				
				case 2:
					vc.deleteProfileController();
					break;
				
				case 3:
					vc.viewProfileController();
					break;
					
				case 4:
					vc.viewAllProfilesController();
					break;
				
				case 5:
					vc.searchProfileController();
					break;
				
				case 6:
					vc.editProfileController();
					break;
				
				default:
					System.out.println("Wrong Choice");
			}
			
			System.out.println("Press y to continue");
			s = sc.next();
			
		}

	}

}
