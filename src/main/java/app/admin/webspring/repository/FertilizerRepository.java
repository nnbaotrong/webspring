package app.admin.webspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.admin.webspring.model.Fertilizer;

public interface FertilizerRepository extends JpaRepository<Fertilizer, Long> {
	// Các phương thức tùy chỉnh nếu cần
}