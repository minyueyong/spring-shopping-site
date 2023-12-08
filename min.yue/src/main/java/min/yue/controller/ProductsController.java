package min.yue.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import min.yue.data.Product;
import min.yue.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductsController {

	private final ProductService productService;
	
	public ProductsController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	public String showProductsList() {

		return "products_table";
	}

	@ModelAttribute
	public void addProductToModel(Model model) {

		// retrieve all ingredients from DB
		List<Product> products = productService.getProductList();
		System.out.println ("total product retrieved" + products.size());
		model.addAttribute("products", products);

	}

}