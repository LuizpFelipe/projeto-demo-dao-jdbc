package aplicacao;

import java.util.Date;
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
		
		System.out.println("___Teste Numero 2: Procurando o Vendedor por Departamento.____");
		Departamento dep = new Departamento(2, null);
		List<Vendedor> list = vendedordao.procurePeloDepartamento(dep);
		for(Vendedor vend: list) {
			System.out.println(vend);
		}
		
		System.out.println("___Teste Numero 3: Procurando todos os vendedores.____");
		list = vendedordao.procureTodos();
		for(Vendedor vend: list) {
			System.out.println(vend);
		}
		
		System.out.println("___Teste Numero 4: Adicionando novo Vendedor.____");
		Vendedor vendedor2 = new Vendedor(null, "Greg", "Greg@gmail.com", new Date(), 2.000, dep);
		vendedordao.insert(vendedor2);
		System.out.println(vendedor2.getId());
		
		System.out.println("___Teste Numero 5: mudandos dados de um Vendedor.____");
		vendedor = vendedordao.procureId(1);
		vendedor.setNome("Luiza Locina");
		vendedordao.update(vendedor);
		System.out.println("Update completo!!");
	}

}
