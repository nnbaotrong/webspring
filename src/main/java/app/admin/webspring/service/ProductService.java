package app.admin.webspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.admin.webspring.model.Product;
import app.admin.webspring.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	// Lấy tất cả sản phẩm
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	// Lấy sản phẩm theo id
	public Optional<Product> getProductById(Long id) {
		return productRepository.findById(id);
	}

	// Thêm mới sản phẩm
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	// Cập nhật sản phẩm
	public Product updateProduct(Long id, Product productDetails) {
		Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
		product.setName(productDetails.getName());
		product.setDescription(productDetails.getDescription());
		product.setQuantity(productDetails.getQuantity());
		product.setPrice(productDetails.getPrice());
		return productRepository.save(product);
	}

	// Xóa sản phẩm
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}