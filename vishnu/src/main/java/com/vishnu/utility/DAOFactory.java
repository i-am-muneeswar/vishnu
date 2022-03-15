package com.vishnu.utility;

import com.vishnu.dao.VishnuDAO;
import com.vishnu.dao.VishnuDAOInterface;

public class DAOFactory {

	public static VishnuDAOInterface createObject() {

		return new VishnuDAO();
		
	}

}
