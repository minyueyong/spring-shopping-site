package min.yue.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import min.yue.data.Product;
import min.yue.service.ProductService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequestMapping("/product")
public class ProductsController {

	private final ProductService productService;
	
	public ProductsController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	public String showProductsList(@RequestParam(defaultValue = "0") Integer pageNumber,
								   @RequestParam(defaultValue = "5") Integer pageSize,
								   @RequestParam(defaultValue = "id") String sortBy,
								   Model model) {
		log.info("showProductsList ->" + " pageNumber : " + pageNumber +" pageSize : " + pageSize + " sortBy: " + sortBy);
		// retrieve products based on pagination parameters
		Page<Product> products = productService.getProductList(pageNumber, pageSize, sortBy);
		System.out.println("Total products retrieved: " + products.getTotalElements());
		model.addAttribute("products", products);

//log.info("is there value later" + products.hasNext());





		return "products_table";
	}




}