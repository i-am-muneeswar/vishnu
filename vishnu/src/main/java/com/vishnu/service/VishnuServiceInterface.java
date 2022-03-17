package com.vishnu.service;

import java.util.List;

import com.vishnu.entity.VishnuUser;

public interface VishnuServiceInterface {

	int createProfileService(VishnuUser vu);

	int deleteProfileService(VishnuUser vu);

	VishnuUser viewProfileService(VishnuUser vu);

	List<VishnuUser> viewAllProfilesService();

	List<VishnuUser> searchProfileService(VishnuUser vu);

	int editProfileService(VishnuUser vu);

}
