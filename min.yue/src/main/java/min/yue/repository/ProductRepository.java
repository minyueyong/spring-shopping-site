package min.yue.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import min.yue.data.Product;

@Repository									//use them with Spring Data JDBC
public interface ProductRepository  extends CrudRepository<Product, String>{    //fetches and save product data ,<entity , data type of the @Id >
	
	//Spring Data JDBC automatically generate implementations for you
	List<Product> findAll();
	

}
