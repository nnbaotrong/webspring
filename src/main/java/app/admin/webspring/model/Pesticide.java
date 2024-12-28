package app.admin.webspring.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Pesticide")
public class Pesticide extends Product {
	private String activeIngredient; // Hoạt chất
	private String toxicityLevel; // Mức độ độc hại
	private String usageInstruction; // Hướng dẫn sử dụng
	private String targetPests; // Loài sâu bệnh mục tiêu

	public String getActiveIngredient() {
		return activeIngredient;
	}

	public void setActiveIngredient(String activeIngredient) {
		this.activeIngredient = activeIngredient;
	}

	public String getToxicityLevel() {
		return toxicityLevel;
	}

	public void setToxicityLevel(String toxicityLevel) {
		this.toxicityLevel = toxicityLevel;
	}

	public String getUsageInstruction() {
		return usageInstruction;
	}

	public void setUsageInstruction(String usageInstruction) {
		this.usageInstruction = usageInstruction;
	}

	public String getTargetPests() {
		return targetPests;
	}

	public void setTargetPests(String targetPests) {
		this.targetPests = targetPests;
	}

}
