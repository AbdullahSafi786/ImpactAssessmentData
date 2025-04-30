package com.agrihub.impact_assessment.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.agrihub.impact_assessment.model.AssessmentResult;
import com.agrihub.impact_assessment.model.EquipmentParameter;
import com.agrihub.impact_assessment.model.TechnologyInput;

class AssessmentServiceTest {

    private AssessmentService assessmentService;

    /**
     * Mock ValuesService with controlled test data for predictable results.
     */
    static class MockValuesService extends ValuesService {
        private final List<EquipmentParameter> mockParams;

        public MockValuesService(List<EquipmentParameter> mockParams) {
            super(null); // No DataLoader needed for unit test
            this.mockParams = mockParams;
        }

        @Override
        public List<EquipmentParameter> getParameters() {
            return mockParams;
        }

        @Override
        public List<com.agrihub.impact_assessment.model.Crop> getCrops() {
            return Collections.emptyList();
        }
    }

    @BeforeEach
    void setUp() {
        EquipmentParameter param = new EquipmentParameter();
        param.setName("Solar Pump");
        param.setEmissionFactor(0.7);
        param.setUnitCost(10.0);

        assessmentService = new AssessmentService(new MockValuesService(Collections.singletonList(param)));
    }

    @Test
    void testAssessment_withValidInput_shouldCalculateCorrectly() {
        TechnologyInput input = new TechnologyInput();
        input.setEquipmentName("Solar Pump");
        input.setOldEnergyConsumption(1000);
        input.setNewEnergyConsumption(400);
        input.setInvestmentCost((double) 12000);

        AssessmentResult result = assessmentService.assess(input);

        assertNotNull(result);
        assertEquals(420.0, result.getGhgChange(), 0.01);            // (1000 - 400) * 0.7
        assertEquals(600.0, result.getEnergySavings(), 0.01);        // 1000 - 400
        assertEquals(6000.0, result.getOperationalCostChange(), 0.01); // 600 * 10
        assertEquals(2.0, result.getPaybackPeriod(), 0.01);          // 12000 / 6000
        assertTrue(result.getNotes().toLowerCase().contains("complete"));
    }

    @Test
    void testAssessment_withMissingParameter_shouldReturnErrorNote() {
        TechnologyInput input = new TechnologyInput();
        input.setEquipmentName("Unknown Equipment");
        input.setOldEnergyConsumption(1000);
        input.setNewEnergyConsumption(800);

        AssessmentResult result = assessmentService.assess(input);

        assertNotNull(result);
        assertNull(result.getGhgChange());
        assertTrue(result.getNotes().toLowerCase().contains("not found"));
    }

    @Test
    void testAssessment_withNoEnergySavings_shouldHaveZeroCostAndPayback() {
        TechnologyInput input = new TechnologyInput();
        input.setEquipmentName("Solar Pump");
        input.setOldEnergyConsumption(500);
        input.setNewEnergyConsumption(500);  // no change
        input.setInvestmentCost((double) 10000);

        AssessmentResult result = assessmentService.assess(input);

        assertEquals(0.0, result.getEnergySavings(), 0.01);
        assertEquals(0.0, result.getOperationalCostChange(), 0.01);
        assertEquals(0.0, result.getPaybackPeriod(), 0.01);
    }

    @Test
    void testAssessment_withNullInput_shouldReturnErrorNote() {
        AssessmentResult result = assessmentService.assess(null);
        assertNotNull(result);
        assertTrue(result.getNotes().toLowerCase().contains("invalid input"));
    }
}
