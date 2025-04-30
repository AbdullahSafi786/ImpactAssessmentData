package com.agrihub.impact_assessment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OutputDTO {

    private int year;                             
    private int numInOperation;                   

    private double costChangeYieldGrowth;         
    private double grossInputCostReduction;       
    private double netCostChangePerUnit;           

    private double probabilityOfSuccess;          
    private double techObsolescenceRate;           

    private double yearwiseAdoptionRate;           
    private double techShiftSupplyCurve;           
    private double proportionPriceReduction;      

    private double productionBeforeAdoption;       
    private double priceBeforeAdoption;            

    private double producerSurplus;               
    private double consumerSurplus;               
    private double totalSurplus;                  

    private InputDTO inputDTO;                     

    // Averages
    private double averageAdoptionRate;
    private double averageProducerSurplus;
    private double averageConsumerSurplus;
    private double averageTotalSurplus;
    
    // 🆕 New Fields Added
    private double netBenefit;                    // Net Benefit (Producer Surplus + Consumer Surplus)
    private double adjustedNetBenefit;            // Net Benefit after applying Obsolescence
    private double discountedNetBenefit;          // Discounted Net Benefit (for NPV calculation)
    private double cumulativeAdoption;            // Cumulative Adoption till current year
    private double netPresentValue;               // NPV (set same for all years at end)
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
	public double getProductionBeforeAdoption() {
		return productionBeforeAdoption;
	}
	public void setProductionBeforeAdoption(double productionBeforeAdoption) {
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
	public InputDTO getInputDTO() {
		return inputDTO;
	}
	public void setInputDTO(InputDTO inputDTO) {
		this.inputDTO = inputDTO;
	}
	public double getAverageAdoptionRate() {
		return averageAdoptionRate;
	}
	public void setAverageAdoptionRate(double averageAdoptionRate) {
		this.averageAdoptionRate = averageAdoptionRate;
	}
	public double getAverageProducerSurplus() {
		return averageProducerSurplus;
	}
	public void setAverageProducerSurplus(double averageProducerSurplus) {
		this.averageProducerSurplus = averageProducerSurplus;
	}
	public double getAverageConsumerSurplus() {
		return averageConsumerSurplus;
	}
	public void setAverageConsumerSurplus(double averageConsumerSurplus) {
		this.averageConsumerSurplus = averageConsumerSurplus;
	}
	public double getAverageTotalSurplus() {
		return averageTotalSurplus;
	}
	public void setAverageTotalSurplus(double averageTotalSurplus) {
		this.averageTotalSurplus = averageTotalSurplus;
	}
	public double getNetBenefit() {
		return netBenefit;
	}
	public void setNetBenefit(double netBenefit) {
		this.netBenefit = netBenefit;
	}
	public double getAdjustedNetBenefit() {
		return adjustedNetBenefit;
	}
	public void setAdjustedNetBenefit(double adjustedNetBenefit) {
		this.adjustedNetBenefit = adjustedNetBenefit;
	}
	public double getDiscountedNetBenefit() {
		return discountedNetBenefit;
	}
	public void setDiscountedNetBenefit(double discountedNetBenefit) {
		this.discountedNetBenefit = discountedNetBenefit;
	}
	public double getCumulativeAdoption() {
		return cumulativeAdoption;
	}
	public void setCumulativeAdoption(double cumulativeAdoption) {
		this.cumulativeAdoption = cumulativeAdoption;
	}
	public double getNetPresentValue() {
		return netPresentValue;
	}
	public void setNetPresentValue(double netPresentValue) {
		this.netPresentValue = netPresentValue;
	}

}
