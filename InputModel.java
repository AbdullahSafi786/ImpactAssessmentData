package com.agrihub.impact_assessment.model;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "input_data")
@Data
public class InputModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String technologyName;
    private String functionPerformed;
    private String targetCrop;

    private int yearFrom;
    private int yearTo;

    private double totalAreaHa;
    private double totalOutputKg;
    private double equipmentCapacityHaPerDay;
    private int operationalDays;

    private boolean operationalCostReducing;
    private boolean yieldEnhancing;

    private double costChangeFraction;
    private double yieldIncreaseFraction;

    private double priceElasticityDemand;
    private double priceElasticitySupply;

    // Bi-directional mapping to outputs if needed
    @OneToMany(mappedBy = "inputModel", cascade = CascadeType.ALL)
    private List<OutputModel> outputs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTechnologyName() {
		return technologyName;
	}

	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}

	public String getFunctionPerformed() {
		return functionPerformed;
	}

	public void setFunctionPerformed(String functionPerformed) {
		this.functionPerformed = functionPerformed;
	}

	public String getTargetCrop() {
		return targetCrop;
	}

	public void setTargetCrop(String targetCrop) {
		this.targetCrop = targetCrop;
	}

	public int getYearFrom() {
		return yearFrom;
	}

	public void setYearFrom(int yearFrom) {
		this.yearFrom = yearFrom;
	}

	public int getYearTo() {
		return yearTo;
	}

	public void setYearTo(int yearTo) {
		this.yearTo = yearTo;
	}

	public double getTotalAreaHa() {
		return totalAreaHa;
	}

	public void setTotalAreaHa(double totalAreaHa) {
		this.totalAreaHa = totalAreaHa;
	}

	public double getTotalOutputKg() {
		return totalOutputKg;
	}

	public void setTotalOutputKg(double totalOutputKg) {
		this.totalOutputKg = totalOutputKg;
	}

	public double getEquipmentCapacityHaPerDay() {
		return equipmentCapacityHaPerDay;
	}

	public void setEquipmentCapacityHaPerDay(double equipmentCapacityHaPerDay) {
		this.equipmentCapacityHaPerDay = equipmentCapacityHaPerDay;
	}

	public int getOperationalDays() {
		return operationalDays;
	}

	public void setOperationalDays(int operationalDays) {
		this.operationalDays = operationalDays;
	}

	public boolean isOperationalCostReducing() {
		return operationalCostReducing;
	}

	public void setOperationalCostReducing(boolean operationalCostReducing) {
		this.operationalCostReducing = operationalCostReducing;
	}

	public boolean isYieldEnhancing() {
		return yieldEnhancing;
	}

	public void setYieldEnhancing(boolean yieldEnhancing) {
		this.yieldEnhancing = yieldEnhancing;
	}

	public double getCostChangeFraction() {
		return costChangeFraction;
	}

	public void setCostChangeFraction(double costChangeFraction) {
		this.costChangeFraction = costChangeFraction;
	}

	public double getYieldIncreaseFraction() {
		return yieldIncreaseFraction;
	}

	public void setYieldIncreaseFraction(double yieldIncreaseFraction) {
		this.yieldIncreaseFraction = yieldIncreaseFraction;
	}

	public double getPriceElasticityDemand() {
		return priceElasticityDemand;
	}

	public void setPriceElasticityDemand(double priceElasticityDemand) {
		this.priceElasticityDemand = priceElasticityDemand;
	}

	public double getPriceElasticitySupply() {
		return priceElasticitySupply;
	}

	public void setPriceElasticitySupply(double priceElasticitySupply) {
		this.priceElasticitySupply = priceElasticitySupply;
	}

	public List<OutputModel> getOutputs() {
		return outputs;
	}

	public void setOutputs(List<OutputModel> outputs) {
		this.outputs = outputs;
	}
}
