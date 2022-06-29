package model.dao;

import model.dao.impl.VendedorDaoJDBC;

public class FactorDAO {
	
	
	public static VendedorDao criadorVendedorDAO() {
		return new VendedorDaoJDBC();
	}
}
