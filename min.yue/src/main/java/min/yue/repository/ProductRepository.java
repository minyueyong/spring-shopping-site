package min.yue.repository;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import min.yue.data.Product;

											//use them with Spring Data JDBC
public interface ProductRepository  extends CrudRepository <Product, String>{    //fetches and save product data ,<entity , data type of the @Id >
	
	//Spring Data JDBC automatically generate implementations for you
	
	Iterable <Product> findAll();
	Optional <Product> findById ( String id ); 
	Product save (Product product);
	Product update (Product product );

}
