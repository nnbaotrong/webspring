package app.admin.webspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.admin.webspring.model.Fruit;

public interface FruitRepository extends JpaRepository<Fruit, Long> {
	// Các phương thức tùy chỉnh nếu cần
}
