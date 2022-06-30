package aplicacao;

import model.dao.FactorDao;
import model.dao.VendedorDao;
import model.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) {
		VendedorDao vendedordao = FactorDao.criadorVendedorDAO();
		System.out.println("___Teste Numero 1: Procurando o Vendedor por Id.____");
		Vendedor vendedor = vendedordao.procureId(3);
		System.out.println(vendedor);

	}

}
