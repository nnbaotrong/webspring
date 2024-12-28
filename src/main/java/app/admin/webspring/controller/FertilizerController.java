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

import app.admin.webspring.model.Fertilizer;
import app.admin.webspring.model.Product;
import app.admin.webspring.service.ProductService;

@RestController
@RequestMapping("/api/fertilizers")
public class FertilizerController {

	@Autowired
	private ProductService productService;

	// Lấy tất cả phân bón
	@GetMapping
	public List<Product> getAllFertilizers() {
		return productService.getAllProducts(); // Bạn có thể lọc thêm theo loại sản phẩm là Fertilizer nếu cần
	}

	// Lấy phân bón theo id
	@GetMapping("/{id}")
	public Optional<Product> getFertilizerById(@PathVariable Long id) {
		return productService.getProductById(id);
	}

	// Thêm phân bón mới
	@PostMapping
	public Product addFertilizer(@RequestBody Fertilizer fertilizer) {
		return productService.addProduct(fertilizer);
	}

	// Cập nhật thông tin phân bón
	@PutMapping("/{id}")
	public Product updateFertilizer(@PathVariable Long id, @RequestBody Fertilizer fertilizer) {
		return productService.updateProduct(id, fertilizer);
	}

	// Xóa phân bón
	@DeleteMapping("/{id}")
	public void deleteFertilizer(@PathVariable Long id) {
		productService.deleteProduct(id);
	}
}
