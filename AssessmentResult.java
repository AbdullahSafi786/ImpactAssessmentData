package com.agrihub.impact_assessment.model;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentResult {
    private String notes;
    private Double ghgChange;
    private Double energySavings;
    private Double paybackPeriod;
    private Double operationalCostChange;
    private Double yieldOutputEnhancingEffect;
    private Map<String, Object> detailedOutcomes;

    public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Double getGhgChange() {
		return ghgChange;
	}

	public void setGhgChange(Double ghgChange) {
		this.ghgChange = ghgChange;
	}

	public Double getEnergySavings() {
		return energySavings;
	}

	public void setEnergySavings(Double energySavings) {
		this.energySavings = energySavings;
	}

	public Double getPaybackPeriod() {
		return paybackPeriod;
	}

	public void setPaybackPeriod(Double paybackPeriod) {
		this.paybackPeriod = paybackPeriod;
	}

	public Double getOperationalCostChange() {
		return operationalCostChange;
	}

	public void setOperationalCostChange(Double operationalCostChange) {
		this.operationalCostChange = operationalCostChange;
	}

	public Double getYieldOutputEnhancingEffect() {
		return yieldOutputEnhancingEffect;
	}

	public void setYieldOutputEnhancingEffect(Double yieldOutputEnhancingEffect) {
		this.yieldOutputEnhancingEffect = yieldOutputEnhancingEffect;
	}

	public Map<String, Object> getDetailedOutcomes() {
		return detailedOutcomes;
	}

	public void setDetailedOutcomes(Map<String, Object> detailedOutcomes) {
		this.detailedOutcomes = detailedOutcomes;
	}

	@Override
    public String toString() {
        return "AssessmentResult{" +
                "notes='" + notes + '\'' +
                ", ghgChange=" + ghgChange +
                ", energySavings=" + energySavings +
                ", paybackPeriod=" + paybackPeriod +
                ", operationalCostChange=" + operationalCostChange +
                ", yieldOutputEnhancingEffect=" + yieldOutputEnhancingEffect +
                ", detailedOutcomes=" + detailedOutcomes +
                '}';
    }
}
