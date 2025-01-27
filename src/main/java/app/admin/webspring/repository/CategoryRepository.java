package app.admin.webspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.admin.webspring.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
}
