package aplicacao;

import java.util.List;
import java.util.Scanner;

import model.dao.DepartamentoDao;
import model.dao.FactorDao;
import model.entidades.Departamento;

public class Programa2 {

	public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		
		DepartamentoDao DepartamentoDao = FactorDao.criadorDepartamentoDAO();

		System.out.println("=== TEST 1: findById =======");
		Departamento dep = DepartamentoDao.procureId(1);
		System.out.println(dep);
		
		System.out.println("\n=== TEST 2: findAll =======");
		List<Departamento> list = DepartamentoDao.procureTodos();
		for (Departamento d : list) {
			System.out.println(d);
		}

		System.out.println("\n=== TEST 3: insert =======");
		Departamento newDepartamento = new Departamento(null, "Music");
		DepartamentoDao.insert(newDepartamento);
		System.out.println("Inserted! New id: " + newDepartamento.getId());

		System.out.println("\n=== TEST 4: update =======");
		Departamento dep2 = DepartamentoDao.procureId(1);
		dep2.setNome("Food");
		DepartamentoDao.update(dep2);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 5: delete =======");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		DepartamentoDao.deleteId(id);
		System.out.println("Delete completed");

		sc.close();

	}

}
