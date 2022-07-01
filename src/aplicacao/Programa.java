package aplicacao;

import java.util.List;

import model.dao.FactorDao;
import model.dao.VendedorDao;
import model.entidades.Departamento;
import model.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) {
		VendedorDao vendedordao = FactorDao.criadorVendedorDAO();
		System.out.println("___Teste Numero 1: Procurando o Vendedor por Id.____");
		Vendedor vendedor = vendedordao.procureId(3);
		System.out.println(vendedor);
		
		System.out.println("___Teste Numero 2: Procurando o Vendedor por Id.____");
		Departamento dep = new Departamento(2, null);
		List<Vendedor> list = vendedordao.procurePeloDepartamento(dep);
		for(Vendedor vend: list) {
			System.out.println(vend);
		}
		
		System.out.println("___Teste Numero 3: Procurando o Vendedor por Id.____");
		list = vendedordao.procureTodos();
		for(Vendedor vend: list) {
			System.out.println(vend);
		}
	}

}
