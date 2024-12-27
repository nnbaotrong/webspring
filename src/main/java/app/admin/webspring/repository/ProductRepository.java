package app.admin.webspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.admin.webspring.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	// Có thể thêm các phương thức tìm kiếm đặc biệt nếu cần
}
