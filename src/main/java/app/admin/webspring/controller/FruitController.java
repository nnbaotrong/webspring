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

import app.admin.webspring.model.Fruit;
import app.admin.webspring.model.Product;
import app.admin.webspring.service.ProductService;

@RestController
@RequestMapping("/api/fruits")
public class FruitController {

	@Autowired
	private ProductService productService;

	// Lấy tất cả trái cây
	@GetMapping
	public List<Product> getAllFruits() {
		return productService.getAllProducts(); // Bạn có thể lọc thêm theo loại sản phẩm là Fruit nếu cần
	}

	// Lấy trái cây theo id
	@GetMapping("/{id}")
	public Optional<Product> getFruitById(@PathVariable Long id) {
		return productService.getProductById(id);
	}

	// Thêm trái cây mới
	@PostMapping
	public Product addFruit(@RequestBody Fruit fruit) {
		return productService.addProduct(fruit);
	}

	// Cập nhật thông tin trái cây
	@PutMapping("/{id}")
	public Product updateFruit(@PathVariable Long id, @RequestBody Fruit fruit) {
		return productService.updateProduct(id, fruit);
	}

	// Xóa trái cây
	@DeleteMapping("/{id}")
	public void deleteFruit(@PathVariable Long id) {
		productService.deleteProduct(id);
	}
}