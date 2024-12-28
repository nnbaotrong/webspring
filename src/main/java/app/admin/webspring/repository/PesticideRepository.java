package app.admin.webspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.admin.webspring.model.Pesticide;

public interface PesticideRepository extends JpaRepository<Pesticide, Long> {
	// Các phương thức tùy chỉnh nếu cần
}
