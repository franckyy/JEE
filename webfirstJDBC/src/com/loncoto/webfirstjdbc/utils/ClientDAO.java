package com.loncoto.webfirstjdbc.utils;

import java.sql.*;
import com.loncoto.webfirstjdbc.beans.*;

public class ClientDAO {
	private Connection base;
	
	public ClientDAO(Connection base) {
		this.base = base;
	}
}