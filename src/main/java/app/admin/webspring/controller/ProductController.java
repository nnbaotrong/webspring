package app.admin.webspring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.admin.webspring.model.Product;
import app.admin.webspring.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	// Lấy tất cả sản phẩm
	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	// Lấy sản phẩm theo id
	@GetMapping("/{id}")
	public Optional<Product> getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}

	// Thêm mới sản phẩm
	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}

	// Cập nhật sản phẩm
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
		return productService.updateProduct(id, product);
	}

	// Xóa sản phẩm
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}

	// Lấy tất cả sản phẩm theo Loại
	@GetMapping("/category/{categoryName}")
	public List<Product> getProductsByCategory(@PathVariable String categoryName) {
		return productService.getProductsByCategory(categoryName);
	}
}