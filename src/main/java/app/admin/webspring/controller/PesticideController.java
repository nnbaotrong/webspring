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

import app.admin.webspring.model.Pesticide;
import app.admin.webspring.model.Product;
import app.admin.webspring.service.ProductService;

@RestController
@RequestMapping("/api/pesticides")
public class PesticideController {

	@Autowired
	private ProductService productService;

	// Lấy tất cả các loại thuốc trừ sâu
	@GetMapping
	public List<Product> getAllPesticides() {
		return productService.getAllProducts(); // Bạn có thể lọc thêm theo loại sản phẩm là Pesticide nếu cần
	}

	// Lấy thuốc trừ sâu theo id
	@GetMapping("/{id}")
	public Optional<Product> getPesticideById(@PathVariable Long id) {
		return productService.getProductById(id);
	}

	// Thêm thuốc trừ sâu mới
	@PostMapping
	public Product addPesticide(@RequestBody Pesticide pesticide) {
		return productService.addProduct(pesticide);
	}

	// Cập nhật thông tin thuốc trừ sâu
	@PutMapping("/{id}")
	public Product updatePesticide(@PathVariable Long id, @RequestBody Pesticide pesticide) {
		return productService.updateProduct(id, pesticide);
	}

	// Xóa thuốc trừ sâu
	@DeleteMapping("/{id}")
	public void deletePesticide(@PathVariable Long id) {
		productService.deleteProduct(id);
	}
}
