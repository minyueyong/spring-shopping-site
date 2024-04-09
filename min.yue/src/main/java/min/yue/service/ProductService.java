package min.yue.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import min.yue.data.Product;
import min.yue.repository.ProductRepository;


@Service // discover by spring component scanning and instantiated as a bean
public class ProductService  {

	
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public List<Product> getProductList (Integer pageNo, Integer pageSize, String sortBy){

		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));


		Page<Product> pagedResult = productRepository.findAll(paging);

		if(pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Product>();
		}
	}
	
	



}
