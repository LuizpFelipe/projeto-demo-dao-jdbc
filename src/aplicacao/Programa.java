package aplicacao;

import model.dao.FactorDAO;
import model.dao.VendedorDao;

public class Programa {

	public static void main(String[] args) {
		VendedorDao vendedordao = FactorDAO.criadorVendedorDAO();
	}

}
