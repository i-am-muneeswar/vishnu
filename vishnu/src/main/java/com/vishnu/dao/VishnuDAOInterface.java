package com.vishnu.dao;

import java.util.List;

import com.vishnu.entity.VishnuUser;

public interface VishnuDAOInterface {

	int createProfileDAO(VishnuUser vu);

	int deleteProfileDAO(VishnuUser vu);

	VishnuUser viewProfileDAO(VishnuUser vu);

	List<VishnuUser> viewAllProfilesDAO();

	List<VishnuUser> searchProfileDAO(VishnuUser vu);

	int editProfileDAO(VishnuUser vu);

}
