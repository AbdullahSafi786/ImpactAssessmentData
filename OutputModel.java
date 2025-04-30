package com.agrihub.impact_assessment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "output_data")
@Data
public class OutputModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int year;
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getNumInOperation() {
		return numInOperation;
	}

	public void setNumInOperation(int numInOperation) {
		this.numInOperation = numInOperation;
	}

	public double getCostChangeYieldGrowth() {
		return costChangeYieldGrowth;
	}

	public void setCostChangeYieldGrowth(double costChangeYieldGrowth) {
		this.costChangeYieldGrowth = costChangeYieldGrowth;
	}

	public double getGrossInputCostReduction() {
		return grossInputCostReduction;
	}

	public void setGrossInputCostReduction(double grossInputCostReduction) {
		this.grossInputCostReduction = grossInputCostReduction;
	}

	public double getNetCostChangePerUnit() {
		return netCostChangePerUnit;
	}

	public void setNetCostChangePerUnit(double netCostChangePerUnit) {
		this.netCostChangePerUnit = netCostChangePerUnit;
	}

	public double getProbabilityOfSuccess() {
		return probabilityOfSuccess;
	}

	public void setProbabilityOfSuccess(double probabilityOfSuccess) {
		this.probabilityOfSuccess = probabilityOfSuccess;
	}

	public double getTechObsolescenceRate() {
		return techObsolescenceRate;
	}

	public void setTechObsolescenceRate(double techObsolescenceRate) {
		this.techObsolescenceRate = techObsolescenceRate;
	}

	public double getYearwiseAdoptionRate() {
		return yearwiseAdoptionRate;
	}

	public void setYearwiseAdoptionRate(double yearwiseAdoptionRate) {
		this.yearwiseAdoptionRate = yearwiseAdoptionRate;
	}

	public double getTechShiftSupplyCurve() {
		return techShiftSupplyCurve;
	}

	public void setTechShiftSupplyCurve(double techShiftSupplyCurve) {
		this.techShiftSupplyCurve = techShiftSupplyCurve;
	}

	public double getProportionPriceReduction() {
		return proportionPriceReduction;
	}

	public void setProportionPriceReduction(double proportionPriceReduction) {
		this.proportionPriceReduction = proportionPriceReduction;
	}

	public long getProductionBeforeAdoption() {
		return productionBeforeAdoption;
	}

	public void setProductionBeforeAdoption(long productionBeforeAdoption) {
		this.productionBeforeAdoption = productionBeforeAdoption;
	}

	public double getPriceBeforeAdoption() {
		return priceBeforeAdoption;
	}

	public void setPriceBeforeAdoption(double priceBeforeAdoption) {
		this.priceBeforeAdoption = priceBeforeAdoption;
	}

	public double getProducerSurplus() {
		return producerSurplus;
	}

	public void setProducerSurplus(double producerSurplus) {
		this.producerSurplus = producerSurplus;
	}

	public double getConsumerSurplus() {
		return consumerSurplus;
	}

	public void setConsumerSurplus(double consumerSurplus) {
		this.consumerSurplus = consumerSurplus;
	}

	public double getTotalSurplus() {
		return totalSurplus;
	}

	public void setTotalSurplus(double totalSurplus) {
		this.totalSurplus = totalSurplus;
	}

	public InputModel getInputModel() {
		return inputModel;
	}

	public void setInputModel(InputModel inputModel) {
		this.inputModel = inputModel;
	}

//	public InputDTO getInputDTO() {
//		return inputDTO;
//	}
//
//	public void setInputDTO(InputDTO inputDTO) {
//		this.inputDTO = inputDTO;
//	}

	private int numInOperation;

    private double costChangeYieldGrowth;
    private double grossInputCostReduction;
    private double netCostChangePerUnit;

    private double probabilityOfSuccess;
    private double techObsolescenceRate;

    private double yearwiseAdoptionRate;
    private double techShiftSupplyCurve;
    private double proportionPriceReduction;

    private long productionBeforeAdoption;
    private double priceBeforeAdoption;
   // private InputDTO inputDTO; // in OutputDTO


    private double producerSurplus;
    private double consumerSurplus;
    private double totalSurplus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "input_id", nullable = false)
    private InputModel inputModel;
}
