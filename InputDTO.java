package com.agrihub.impact_assessment.dto;

import lombok.Data;

@Data
public class InputDTO {

    private String technologyName;
    private String functionPerformed;
    private String targetCrop;

    private Integer yearFrom;
    private Integer yearTo;
    private Double pricePerKg;
    private Double baseOutputKg;

    private String yieldEnhancing; // Yes/No
    private Boolean operationalCostReducing;

    private Double totalAreaHa;
    private Double totalOutputKg;

    private Double equipmentCapacityHaPerDay;
    private Integer operationalDays;

    private String changeInOperationalCost; // Reducing/Increasing/No change
    private String landHoldingType;

    private Double costChangeFraction;
    private Double yieldIncreaseFraction;

    private Double priceElasticityDemand;
    private Double priceElasticitySupply;

    private String equipmentCapacityUnit;
    private String macroRegion;
    private Double farmSize;
    private Integer equipmentCapacity;

    private Double probabilityOfSuccess; // Default: 1.0
    private Double techObsolescenceRate; // Default: 1.0
    private Double adoptionStartRate;
    private Double adoptionIncrementPerYear;
    private Double grossInputCostReduction;

    private Double discountRate; // Default: 0.10 (10%)

    // Constructor with default values
    public InputDTO() {
        this.discountRate = 0.10; // Default discount rate (10%)
        this.probabilityOfSuccess = 1.0; // Default probability of success
        this.techObsolescenceRate = 1.0; // Default obsolescence rate
    }

    // Getters and Setters
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

    public Integer getYearFrom() {
        return yearFrom;
    }

    public void setYearFrom(Integer yearFrom) {
        this.yearFrom = yearFrom;
    }

    public Integer getYearTo() {
        return yearTo;
    }

    public void setYearTo(Integer yearTo) {
        this.yearTo = yearTo;
    }

    public Double getPricePerKg() {
        return pricePerKg;
    }

    public void setPricePerKg(Double pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    public Double getBaseOutputKg() {
        return baseOutputKg;
    }

    public void setBaseOutputKg(Double baseOutputKg) {
        this.baseOutputKg = baseOutputKg;
    }

    public String getYieldEnhancing() {
        return yieldEnhancing;
    }

    public void setYieldEnhancing(String yieldEnhancing) {
        this.yieldEnhancing = yieldEnhancing;
    }

    public Boolean getOperationalCostReducing() {
        return operationalCostReducing;
    }

    public void setOperationalCostReducing(Boolean operationalCostReducing) {
        this.operationalCostReducing = operationalCostReducing;
    }

    public Double getTotalAreaHa() {
        return totalAreaHa;
    }

    public void setTotalAreaHa(Double totalAreaHa) {
        this.totalAreaHa = totalAreaHa;
    }

    public Double getTotalOutputKg() {
        return totalOutputKg;
    }

    public void setTotalOutputKg(Double totalOutputKg) {
        this.totalOutputKg = totalOutputKg;
    }

    public Double getEquipmentCapacityHaPerDay() {
        return equipmentCapacityHaPerDay;
    }

    public void setEquipmentCapacityHaPerDay(Double equipmentCapacityHaPerDay) {
        this.equipmentCapacityHaPerDay = equipmentCapacityHaPerDay;
    }

    public Integer getOperationalDays() {
        return operationalDays;
    }

    public void setOperationalDays(Integer operationalDays) {
        this.operationalDays = operationalDays;
    }

    public String getChangeInOperationalCost() {
        return changeInOperationalCost;
    }

    public void setChangeInOperationalCost(String changeInOperationalCost) {
        this.changeInOperationalCost = changeInOperationalCost;
    }

    public String getLandHoldingType() {
        return landHoldingType;
    }

    public void setLandHoldingType(String landHoldingType) {
        this.landHoldingType = landHoldingType;
    }

    public Double getCostChangeFraction() {
        return costChangeFraction;
    }

    public void setCostChangeFraction(Double costChangeFraction) {
        this.costChangeFraction = costChangeFraction;
    }

    public Double getYieldIncreaseFraction() {
        return yieldIncreaseFraction;
    }

    public void setYieldIncreaseFraction(Double yieldIncreaseFraction) {
        this.yieldIncreaseFraction = yieldIncreaseFraction;
    }

    public Double getPriceElasticityDemand() {
        return priceElasticityDemand;
    }

    public void setPriceElasticityDemand(Double priceElasticityDemand) {
        this.priceElasticityDemand = priceElasticityDemand;
    }

    public Double getPriceElasticitySupply() {
        return priceElasticitySupply;
    }

    public void setPriceElasticitySupply(Double priceElasticitySupply) {
        this.priceElasticitySupply = priceElasticitySupply;
    }

    public String getEquipmentCapacityUnit() {
        return equipmentCapacityUnit;
    }

    public void setEquipmentCapacityUnit(String equipmentCapacityUnit) {
        this.equipmentCapacityUnit = equipmentCapacityUnit;
    }

    public String getMacroRegion() {
        return macroRegion;
    }

    public void setMacroRegion(String macroRegion) {
        this.macroRegion = macroRegion;
    }

    public Double getFarmSize() {
        return farmSize;
    }

    public void setFarmSize(Double farmSize) {
        this.farmSize = farmSize;
    }

    public Integer getEquipmentCapacity() {
        return equipmentCapacity;
    }

    public void setEquipmentCapacity(Integer equipmentCapacity) {
        this.equipmentCapacity = equipmentCapacity;
    }

    public Double getProbabilityOfSuccess() {
        return probabilityOfSuccess;
    }

    public void setProbabilityOfSuccess(Double probabilityOfSuccess) {
        this.probabilityOfSuccess = probabilityOfSuccess;
    }

    public Double getTechObsolescenceRate() {
        return techObsolescenceRate;
    }

    public void setTechObsolescenceRate(Double techObsolescenceRate) {
        this.techObsolescenceRate = techObsolescenceRate;
    }

    public Double getAdoptionStartRate() {
        return adoptionStartRate;
    }

    public void setAdoptionStartRate(Double adoptionStartRate) {
        this.adoptionStartRate = adoptionStartRate;
    }

    public Double getAdoptionIncrementPerYear() {
        return adoptionIncrementPerYear;
    }

    public void setAdoptionIncrementPerYear(Double adoptionIncrementPerYear) {
        this.adoptionIncrementPerYear = adoptionIncrementPerYear;
    }

    public Double getGrossInputCostReduction() {
        return grossInputCostReduction;
    }

    public void setGrossInputCostReduction(Double grossInputCostReduction) {
        this.grossInputCostReduction = grossInputCostReduction;
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }
}