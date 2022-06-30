package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.VendedorDao;
import model.entidades.Departamento;
import model.entidades.Vendedor;

public class VendedorDaoJDBC implements VendedorDao{

	private Connection conn;
	
	public VendedorDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	@Override
	public void insert(Vendedor obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Vendedor obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteId(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vendedor procureId(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT seller.*,department.Name as DepName\r\n"
					+ "FROM seller INNER JOIN department\r\n"
					+ "ON seller.DepartmentId = department.Id\r\n"
					+ "WHERE seller.Id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				Departamento dep = intenciandoDepartamento(rs);
				Vendedor vendedor = intanciandoVendedor(rs, dep);
				return vendedor;
			}
			
			return null;
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private Vendedor intanciandoVendedor(ResultSet rs, Departamento dep) throws SQLException {
		Vendedor vendedor =new Vendedor();
		vendedor.setId(rs.getInt("Id"));
		vendedor.setNome(rs.getString("Name"));
		vendedor.setEmail(rs.getString("Email"));
		vendedor.setBaseSalario(rs.getDouble("BaseSalary"));
		vendedor.setDataAniversario(rs.getDate("BirthDate"));
		vendedor.setDepartamento(dep);
		return vendedor;
	}
	private Departamento intenciandoDepartamento(ResultSet rs) throws SQLException {
		Departamento dep =new Departamento();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setNome(rs.getString("DepName"));
		return dep;
	}
	@Override
	public List<Vendedor> procureTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
