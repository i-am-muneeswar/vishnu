package com.vishnu.service;

import java.util.List;

import com.vishnu.dao.VishnuDAOInterface;
import com.vishnu.entity.VishnuUser;
import com.vishnu.utility.DAOFactory;

public class VishnuService implements VishnuServiceInterface {
	
	VishnuDAOInterface vd = null;
	
	public VishnuService() {
		vd = DAOFactory.createObject();
	}

	public int createProfileService(VishnuUser vu) {
		 
		int i = vd.createProfileDAO(vu);
		return i;
	}

	public int deleteProfileService(VishnuUser vu) {
		
		int i = vd.deleteProfileDAO(vu);
		return i;
	}

	public VishnuUser viewProfileService(VishnuUser vu) {

		VishnuUser i = vd.viewProfileDAO(vu);
		return i;
	}

	public List<VishnuUser> viewAllProfilesService() {

		List<VishnuUser> i = vd.viewAllProfilesDAO();
		return i;
	}

	
	public List<VishnuUser> searchProfileService(VishnuUser vu) {

		List<VishnuUser> i = vd.searchProfileDAO(vu);
		return i;
	}

	
	public int editProfileService(VishnuUser vu) {
		
		int i = vd.editProfileDAO(vu);
		return i;
		
	}

}
