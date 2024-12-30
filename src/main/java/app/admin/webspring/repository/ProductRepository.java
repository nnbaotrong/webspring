package app.admin.webspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.admin.webspring.model.Category;
import app.admin.webspring.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByCategoryName(String categoryName); // Tìm sản phẩm theo tên Category

	List<Product> findByCategory(Category category); // Tìm sản phẩm theo Category
}
