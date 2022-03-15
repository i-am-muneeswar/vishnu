package com.vishnu.utility;

import com.vishnu.service.VishnuService;
import com.vishnu.service.VishnuServiceInterface;

public class ServiceFactory {

	public static VishnuServiceInterface createObject() {
		
		return new VishnuService();
	}

}
