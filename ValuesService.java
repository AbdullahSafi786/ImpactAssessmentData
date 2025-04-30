package com.agrihub.impact_assessment.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.agrihub.impact_assessment.model.Crop;
import com.agrihub.impact_assessment.model.EquipmentParameter;

@Service
public class ValuesService {

    private static final Logger logger = LoggerFactory.getLogger(ValuesService.class);

    private final List<EquipmentParameter> parameters;
    private final List<Crop> crops;
    

    public ValuesService(DataLoader dataLoader) {
        List<EquipmentParameter> loadedParams;
        List<Crop> loadedCrops;

        try {
            loadedParams = dataLoader.readEquipmentParameters();
        } catch (Exception e) {
            logger.error("Failed to load equipment parameters from Excel", e);
            loadedParams = Collections.emptyList();
        }

        try {
            loadedCrops = dataLoader.readCrops();
        } catch (Exception e) {
            logger.error("Failed to load crop data from Excel", e);
            loadedCrops = Collections.emptyList();
        }

        this.parameters = loadedParams;
        this.crops = loadedCrops;
    }

    public List<EquipmentParameter> getParameters() {
        return parameters;
    }

    public List<Crop> getCrops() {
        return crops;
    }

    public List<String> getEquipmentNames() {
        return parameters.stream()
                .map(EquipmentParameter::getName)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<String> getCropNames() {
        return crops.stream()
                .map(Crop::getName)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<String> getFunctions() {
        // Static values — customize if needed based on Excel later
        return List.of("Ploughing", "Digging", "Sowing", "Harvesting", "Irrigation");
    }
}
