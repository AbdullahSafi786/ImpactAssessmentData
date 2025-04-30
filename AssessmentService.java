package com.agrihub.impact_assessment.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.agrihub.impact_assessment.model.AssessmentResult;
import com.agrihub.impact_assessment.model.EquipmentParameter;
import com.agrihub.impact_assessment.model.TechnologyInput;

@Service
public class AssessmentService {

    private final ValuesService valuesService;

    public AssessmentService(ValuesService valuesService) {
        this.valuesService = valuesService;
    }

    public AssessmentResult assess(TechnologyInput input) {
        AssessmentResult result = new AssessmentResult();

        if (input == null || input.getEquipmentName() == null) {
            result.setNotes("Invalid input: Equipment name is required.");
            return result;
        }

        Optional<EquipmentParameter> paramOpt = valuesService.getParameters().stream()
                .filter(p -> input.getEquipmentName().equalsIgnoreCase(p.getName()))
                .findFirst();

        if (paramOpt.isEmpty()) {
            result.setNotes("No parameters found for equipment: " + input.getEquipmentName());
            return result;
        }

        EquipmentParameter param = paramOpt.get();

        Double oldEnergy = input.getOldEnergyConsumption();
        Double newEnergy = input.getNewEnergyConsumption();
        Double emissionFactor = param.getEmissionFactor();
        Double unitCost = param.getUnitCost();
        Double investmentCost = input.getInvestmentCost();

        if (oldEnergy == null || newEnergy == null || emissionFactor == null || unitCost == null || investmentCost == null) {
            result.setNotes("Missing one or more required parameters.");
            result.setGhgChange(null);
            result.setEnergySavings(null);
            result.setOperationalCostChange(null);
            result.setPaybackPeriod(null);
            return result;
        }

        // Proceed with calculations
        double ghgChange = (oldEnergy - newEnergy) * emissionFactor;
        result.setGhgChange(ghgChange);

        double energySavings = oldEnergy - newEnergy;
        result.setEnergySavings(energySavings);

        double operationalCostChange = energySavings * unitCost;
        result.setOperationalCostChange(operationalCostChange);

        double paybackPeriod = (operationalCostChange != 0)
                ? investmentCost / Math.abs(operationalCostChange)
                : null;
        result.setPaybackPeriod(paybackPeriod);

        result.setNotes("Assessment completed successfully.");
        return result;
    }

    public ValuesService getValuesService() {
        return valuesService;
    }
}
