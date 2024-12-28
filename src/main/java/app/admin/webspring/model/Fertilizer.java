package app.admin.webspring.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Fertilizer")
public class Fertilizer extends Product {
	private String nutrientContent; // Thành phần dinh dưỡng
	private String applicationMethod; // Cách bón
	private String recommendedCrops; // Cây trồng phù hợp
	private Double weight; // Khối lượng sản phẩm (kg)

	public String getNutrientContent() {
		return nutrientContent;
	}

	public void setNutrientContent(String nutrientContent) {
		this.nutrientContent = nutrientContent;
	}

	public String getApplicationMethod() {
		return applicationMethod;
	}

	public void setApplicationMethod(String applicationMethod) {
		this.applicationMethod = applicationMethod;
	}

	public String getRecommendedCrops() {
		return recommendedCrops;
	}

	public void setRecommendedCrops(String recommendedCrops) {
		this.recommendedCrops = recommendedCrops;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

}
