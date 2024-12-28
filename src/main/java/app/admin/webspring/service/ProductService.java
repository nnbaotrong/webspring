package app.admin.webspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.admin.webspring.model.Fertilizer;
import app.admin.webspring.model.Fruit;
import app.admin.webspring.model.Pesticide;
import app.admin.webspring.model.Product;
import app.admin.webspring.repository.ProductRepository;
import jakarta.transaction.Transactional;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository; // Repository để tương tác với cơ sở dữ liệu

	// Lấy tất cả sản phẩm (có thể lọc thêm theo loại sản phẩm nếu cần)
	public List<Product> getAllProducts() {
		return productRepository.findAll(); // Lấy tất cả sản phẩm từ database
	}

	// Lấy sản phẩm theo id
	public Optional<Product> getProductById(Long id) {
		return productRepository.findById(id); // Trả về Optional để xử lý trường hợp không tìm thấy sản phẩm
	}

	// Thêm sản phẩm mới (bao gồm Pesticide, Fertilizer, Fruit)
	@Transactional
	public Product addProduct(Product product) {
		return productRepository.save(product); // Lưu sản phẩm vào cơ sở dữ liệu
	}

	// Cập nhật thông tin sản phẩm
	@Transactional
	public Product updateProduct(Long id, Product updatedProduct) {
		// Kiểm tra xem sản phẩm có tồn tại trong database không
		Optional<Product> existingProduct = productRepository.findById(id);
		if (existingProduct.isPresent()) {
			Product product = existingProduct.get();
			// Cập nhật các trường thông tin của sản phẩm
			product.setName(updatedProduct.getName());
			product.setCategory(updatedProduct.getCategory());
			product.setQuantity(updatedProduct.getQuantity());
			product.setUnit(updatedProduct.getUnit());
			product.setPrice(updatedProduct.getPrice());
			product.setSupplier(updatedProduct.getSupplier());
			product.setDescription(updatedProduct.getDescription());
			product.setExpiryDate(updatedProduct.getExpiryDate());
			product.setManufacturer(updatedProduct.getManufacturer());
			product.setManufacturingDate(updatedProduct.getManufacturingDate());
			product.setStorageConditions(updatedProduct.getStorageConditions());

			// Đảm bảo trường riêng biệt của mỗi loại sản phẩm (Pesticide, Fertilizer,
			// Fruit) được cập nhật
			if (product instanceof Pesticide) {
				Pesticide pesticide = (Pesticide) product;
				pesticide.setActiveIngredient(((Pesticide) updatedProduct).getActiveIngredient());
				pesticide.setToxicityLevel(((Pesticide) updatedProduct).getToxicityLevel());
				pesticide.setUsageInstruction(((Pesticide) updatedProduct).getUsageInstruction());
				pesticide.setTargetPests(((Pesticide) updatedProduct).getTargetPests());
			} else if (product instanceof Fertilizer) {
				Fertilizer fertilizer = (Fertilizer) product;
				fertilizer.setNutrientContent(((Fertilizer) updatedProduct).getNutrientContent());
				fertilizer.setApplicationMethod(((Fertilizer) updatedProduct).getApplicationMethod());
				fertilizer.setRecommendedCrops(((Fertilizer) updatedProduct).getRecommendedCrops());
				fertilizer.setWeight(((Fertilizer) updatedProduct).getWeight());
			} else if (product instanceof Fruit) {
				Fruit fruit = (Fruit) product;
				fruit.setOrigin(((Fruit) updatedProduct).getOrigin());
				fruit.setQuality(((Fruit) updatedProduct).getQuality());
				fruit.setHarvestDate(((Fruit) updatedProduct).getHarvestDate());
				fruit.setType(((Fruit) updatedProduct).getType());
				fruit.setWeight(((Fruit) updatedProduct).getWeight());
			}

			return productRepository.save(product); // Lưu lại sản phẩm đã cập nhật
		} else {
			throw new RuntimeException("Product not found with id: " + id); // Nếu không tìm thấy sản phẩm
		}
	}

	// Xóa sản phẩm theo id
	@Transactional
	public void deleteProduct(Long id) {
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent()) {
			productRepository.deleteById(id); // Xóa sản phẩm khỏi cơ sở dữ liệu
		} else {
			throw new RuntimeException("Product not found with id: " + id); // Nếu không tìm thấy sản phẩm
		}
	}
}