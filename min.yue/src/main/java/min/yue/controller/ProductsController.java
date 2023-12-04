package min.yue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import min.yue.data.Product;
import min.yue.repository.ProductRepository;

@Controller
@RequestMapping("/product")
public class ProductsController {

	private final ProductRepository productsRepo; // this is for us to retrieve Ingredient from the DB

	@Autowired // inject this dependency into Spring Bean
	public ProductsController(ProductRepository productsRepo) {
		this.productsRepo = productsRepo;
	}

	@GetMapping
	public String showProductsList() {

		return "products_table";
	}

	@ModelAttribute
	public void addProductToModel(Model model) {

		// retrieve all ingredients from DB
		Iterable<Product> products = productsRepo.findAll();

		model.addAttribute("products", products);

	}

}