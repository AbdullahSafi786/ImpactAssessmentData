package com.agrihub.impact_assessment.model;

import java.util.Map;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public class TechnologyInput {
    private String technologyName;
    private String functionPerformed;
    private String targetCrop;
    private Map<String, Object> parameters; // "Capacity of equipment": 10, etc.
    private Double quantum;
    @Schema(example = "Solar Pump", description = "Name of the equipment")
    private String equipmentName;

    @Schema(example = "1200.0", description = "Energy used by old equipment in kWh")
    private double oldEnergyConsumption;

    @Schema(example = "800.0", description = "Energy used by new equipment in kWh")
    private double newEnergyConsumption;


    public void setOldEnergyConsumption(double oldEnergyConsumption) {
		this.oldEnergyConsumption = oldEnergyConsumption;
	}
	public void setNewEnergyConsumption(double newEnergyConsumption) {
		this.newEnergyConsumption = newEnergyConsumption;
	}
//	@NotNull(message = "Equipment name is required")
//    private String equipmentName;
//
//    @NotNull(message = "Old energy consumption is required")
//    private Double oldEnergyConsumption;
//
//    @NotNull(message = "New energy consumption is required")
//    private Double newEnergyConsumption;

    @NotNull(message = "Investment cost is required")
    private Double investmentCost;
    public TechnologyInput(String technologyName, String functionPerformed, String targetCrop,
			Map<String, Object> parameters, Double quantum, String equipmentName, double oldEnergyConsumption,
			double newEnergyConsumption, @NotNull(message = "Investment cost is required") Double investmentCost) {
		super();
		this.technologyName = technologyName;
		this.functionPerformed = functionPerformed;
		this.targetCrop = targetCrop;
		this.parameters = parameters;
		this.quantum = quantum;
		this.equipmentName = equipmentName;
		this.oldEnergyConsumption = oldEnergyConsumption;
		this.newEnergyConsumption = newEnergyConsumption;
		this.investmentCost = investmentCost;
	}
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	public Double getOldEnergyConsumption() {
		return oldEnergyConsumption;
	}
	public void setOldEnergyConsumption(Double oldEnergyConsumption) {
		this.oldEnergyConsumption = oldEnergyConsumption;
	}
	public Double getNewEnergyConsumption() {
		return newEnergyConsumption;
	}
	public void setNewEnergyConsumption(Double newEnergyConsumption) {
		this.newEnergyConsumption = newEnergyConsumption;
	}
	public Double getInvestmentCost() {
		return investmentCost;
	}
	public void setInvestmentCost(Double investmentCost) {
		this.investmentCost = investmentCost;
	}
	// getters, setters, constructor
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
	public Map<String, Object> getParameters() {
		return parameters;
	}
	public void setParameters(Map<String, Object> parameters) {
		this.parameters = parameters;
	}
	public Double getQuantum() {
		return quantum;
	}
	public void setQuantum(Double quantum) {
		this.quantum = quantum;
	}
	public TechnologyInput(String technologyName, String functionPerformed, String targetCrop,
			Map<String, Object> parameters, Double quantum) {
		super();
		this.technologyName = technologyName;
		this.functionPerformed = functionPerformed;
		this.targetCrop = targetCrop;
		this.parameters = parameters;
		this.quantum = quantum;
	}
	public TechnologyInput() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
