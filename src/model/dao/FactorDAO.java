package model.dao;

import db.DB;
import model.dao.impl.VendedorDaoJDBC;

public class FactorDao {
	
	
	public static VendedorDao criadorVendedorDAO() {
		return new VendedorDaoJDBC(DB.getConnection());
	}
}
