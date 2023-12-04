package min.yue.jdbcrepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import min.yue.data.Product;
import min.yue.repository.ProductRepository;

//jdbcTemplate is preferable over jdbcRepository but Spring Data JDBC is better
@Repository // discover by spring component scanning and instantiated as a bean
public class JdbcProductRepository implements ProductRepository {

	private JdbcTemplate jdbcTemplate;

	// Autowired automatically inject a dependency into Spring Bean
	@Autowired // spring will automatically look for bean type JDBCTemplate and inject it into
				// constructor
	public JdbcProductRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Iterable<Product> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select id , code, name,brand, category, type, description from products",
				this::mapRowToProduct);
	}

	// Purpose of RowMapper is to map each row in the Result Set to an object
	private Product mapRowToProduct(ResultSet row, int rowNum) throws SQLException {
		return Product.build(Integer.valueOf(row.getString("id")), row.getString("code"), row.getString("name"),
				row.getString("brand"), row.getString("category"), row.getString("type"), row.getString("description"));

	}

	@Override
	public <S extends Product> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Product> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Product entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Product> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<Product> findById(String id) {

		List<Product> results = jdbcTemplate.query(
				"select id,  code,  name, type, brand, category, description from Products where id=? ",
				this::mapRowToProduct, id);
		return results.size() == 0 ? Optional.empty() : Optional.of(results.get(0));
	}

	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(
				"insert into Products ( code,  name , category , brand ,  type , description) values ( ? , ? , ? , ? , ? , ?)",
				product.getCode(), product.getName(), product.getCategory(), product.getBrand(), product.getType(),
				product.getDescription());
		return product;
	}

	@Override
	public Product update(Product product) {
		String updateSql = "UPDATE Products " +
				" SET   name = ?, " + 
				"category = ?, " + 
				"brand = ?, " + 
				"type = ?, "+ 
				"description = ? " + 
				"WHERE id = ?";

		jdbcTemplate.update(updateSql,

				product.getName(), product.getCategory(), product.getBrand(), product.getType(),
				product.getDescription(), product.getId());

		return product;
	}

}
