package min.yue.service;


import lombok.extern.slf4j.Slf4j;
import min.yue.data.Product;
import min.yue.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service // discover by spring component scanning and instantiated as a bean
@Slf4j
public class ProductService  {

	
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<String> getCategoryDropdown() {
		return productRepository.findDistinctCategory();
	}

	public Page<Product> getProductList (Integer pageNo, Integer pageSize, String sortBy){
		log.info("getProductList ->" + " pageNo : " + pageNo +" pageSize : " + pageSize + " sortBy: " + sortBy);
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));


		Page<Product> pagedResult = productRepository.findAll(paging);


		if(pagedResult.hasContent()) {
			log.info("successfully return page result");
			return pagedResult;
		} else {
			log.info("returning empty page");
			return Page.empty();
		}
	}
	
	



}
