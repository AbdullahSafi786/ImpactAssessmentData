package com.agrihub.impact_assessment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.agrihub.impact_assessment.dto.InputDTO;
import com.agrihub.impact_assessment.dto.OutputDTO;

@Service
public class CalculationService {

    /**
     * Performs the impact calculation based on the input parameters submitted via the form.
     *
     * @param input InputDTO object containing all the input values from the form.
     * @return A list of OutputDTO objects representing the yearly impact assessment results.
     */
    public List<OutputDTO> calculateImpact(InputDTO input) {
        List<OutputDTO> resultList = new ArrayList<>();

        // Extract and validate input values
        int startYear = input.getYearFrom() != null ? input.getYearFrom() : 0;
        int endYear = input.getYearTo() != null ? input.getYearTo() : 0;

        double proportionateIncreaseInYield = input.getYieldIncreaseFraction() != null ? input.getYieldIncreaseFraction() : 0.0;
        double proportionateChangeInCost = input.getCostChangeFraction() != null ? input.getCostChangeFraction() : 0.0;
        double elasticitySupply = input.getPriceElasticitySupply() != null ? input.getPriceElasticitySupply() : 1.0; // Default elasticity
        double elasticityDemand = input.getPriceElasticityDemand() != null ? input.getPriceElasticityDemand() : 1.0; // Default elasticity
        double capacityOfEquipment = input.getEquipmentCapacity() != null ? input.getEquipmentCapacity() : 0.0;
        int operationalDays = input.getOperationalDays() != null ? input.getOperationalDays() : 0;
        double totalAreaUnderCrop = input.getTotalAreaHa() != null ? input.getTotalAreaHa() : 1.0; // Prevent division by zero

        // Constants
        double probabilityOfSuccess = 1.0; // Adopted = 1
        double techObsolescenceRate = 1.0; // Dev last 15 years = 1
        double productionBeforeAdoption = input.getBaseOutputKg() != null ? input.getBaseOutputKg() : 6960000000.0; // Qo
        double priceBeforeAdoption = input.getPricePerKg() != null ? input.getPricePerKg() : 27.0; // Po

        // Summation variables
        double sumTotalSurplus = 0.0;
        int yearCount = 0;

        // Iterate over each year and calculate metrics
        for (int year = startYear, i = 0; year <= endYear; year++, i++) {
            OutputDTO model = new OutputDTO();
            model.setYear(year);

            // Yearwise number of machines in operation
            int numInOperation = 385 + (i * 14); // Example dynamic value
            model.setNumInOperation(numInOperation);

            // 1. Cost Change Due to Yield/Output Growth
            double costChangeYieldGrowth = proportionateIncreaseInYield / elasticitySupply;
            model.setCostChangeYieldGrowth(costChangeYieldGrowth);

            // 2. Gross Input Cost Reduction
            double grossInputCostReduction = proportionateChangeInCost / (1 + proportionateIncreaseInYield);
            model.setGrossInputCostReduction(grossInputCostReduction);

            // 3. Change in Net Cost per Unit of Final Output
            double netCostChangePerUnit = costChangeYieldGrowth - grossInputCostReduction;
            model.setNetCostChangePerUnit(netCostChangePerUnit);

            // 4. Probability of Success
            model.setProbabilityOfSuccess(probabilityOfSuccess);

            // 5. Rate of Technology Obsolescence
            model.setTechObsolescenceRate(techObsolescenceRate);

            // 6. Yearwise Adoption Rate
            double adoptionRate = (numInOperation * capacityOfEquipment * operationalDays) / totalAreaUnderCrop;
            model.setYearwiseAdoptionRate(adoptionRate);

            // 7. Tech-Induced Shift of Supply Curve
            double techShiftSupplyCurve = netCostChangePerUnit * probabilityOfSuccess * techObsolescenceRate * adoptionRate;
            model.setTechShiftSupplyCurve(techShiftSupplyCurve);

            // 8. Proportion Reduction in Price (Z-Factor Matrix)
            double proportionPriceReduction = (techShiftSupplyCurve * elasticitySupply) / (elasticityDemand + elasticitySupply);
            model.setProportionPriceReduction(proportionPriceReduction);

            // 9. Production Before Adoption (Qo)
            model.setProductionBeforeAdoption(productionBeforeAdoption);

            // 10. Price Before Adoption (Po)
            model.setPriceBeforeAdoption(priceBeforeAdoption);

            // 11. Producers Surplus Matrix
            double producerSurplus = (techShiftSupplyCurve - proportionPriceReduction)
                    * (productionBeforeAdoption * priceBeforeAdoption)
                    * (1 + 0.5 * proportionPriceReduction * elasticityDemand);
            model.setProducerSurplus(producerSurplus);

            // 12. Consumer Surplus Matrix
            double consumerSurplus = proportionPriceReduction
                    * (productionBeforeAdoption * priceBeforeAdoption)
                    * (1 + 0.5 * proportionPriceReduction * elasticityDemand);
            model.setConsumerSurplus(consumerSurplus);

            // 13. Total Surplus Matrix
            double totalSurplus = techShiftSupplyCurve
                    * (productionBeforeAdoption * priceBeforeAdoption)
                    * (1 + 0.5 * proportionPriceReduction * elasticityDemand);
            model.setTotalSurplus(totalSurplus);

            // Add to summation variables
            sumTotalSurplus += totalSurplus;
            yearCount++;

            // Add the result to the list
            resultList.add(model);
        }

        // 14. Average Total Surplus per Annum
        double avgTotalSurplus = sumTotalSurplus / yearCount;

        // Assign averages to the first OutputDTO for display in the "Average" column
        if (!resultList.isEmpty()) {
            OutputDTO firstEntry = resultList.get(0);
            firstEntry.setAverageTotalSurplus(avgTotalSurplus);
        }

        return resultList;
    }
}