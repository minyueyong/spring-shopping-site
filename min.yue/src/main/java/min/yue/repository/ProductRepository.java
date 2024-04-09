package min.yue.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import min.yue.data.Product;

@Repository									//use them with Spring Data JDBC
public interface ProductRepository  extends PagingAndSortingRepository<Product, String> {    //fetches and save product data ,<entity , data type of the @Id >
	
	//Spring Data JDBC automatically generate implementations for you
	Page<Product> findAll(Pageable paging);

	Optional<Product> findById(String id);

	void save ( Product product);
	

}
