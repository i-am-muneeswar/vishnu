package com.vishnu.utility;

import com.vishnu.controller.VishnuController;
import com.vishnu.controller.VishnuControllerInterface;

public class ControllerFactorty {

	public static VishnuControllerInterface createObject() {
		
		return new VishnuController();
		
	}

}
