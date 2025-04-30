package com.agrihub.impact_assessment.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.agrihub.impact_assessment.dto.InputDTO;
import com.agrihub.impact_assessment.dto.OutputDTO;
import com.agrihub.impact_assessment.service.CalculationService;
import com.agrihub.impact_assessment.service.ValuesService;

@Controller
@RequestMapping("/impact")
public class ImpactController {

    private static final Object inputDTO = null;
	private static final Object outputList = null;
	private final ValuesService valuesService;
    private final CalculationService calculationService;

    // Constructor-based dependency injection
    public ImpactController(ValuesService valuesService, CalculationService calculationService) {
        this.valuesService = valuesService;
        this.calculationService = calculationService;
    }

    // Show input form
    @GetMapping
    public String showForm(Model model) {
    	model.addAttribute("inputDTO", inputDTO);
    	model.addAttribute("outputList", outputList);

        model.addAttribute("inputDTO", new InputDTO()); // Consistent naming for model attribute

        // Populate dropdowns dynamically from ValuesService (e.g., from Excel)
        model.addAttribute("technologies", valuesService.getEquipmentNames());
        model.addAttribute("functions", valuesService.getFunctions());
        model.addAttribute("crops", valuesService.getCropNames());
        

        return "impact-form"; // Thymeleaf page for the input form
    }

    // Handle form submission and compute impact
    @PostMapping("/compute")
    public String computeImpact(@ModelAttribute InputDTO inputDTO, Model model) {
        // Compute impact based on the submitted input data
        List<OutputDTO> outputList = calculationService.calculateImpact(inputDTO); 

        // Add computed results and input data to the model
        model.addAttribute("outputList", outputList);
        model.addAttribute("techName", inputDTO.getTechnologyName());  // Technology Name (from form)
        model.addAttribute("cropName", inputDTO.getTargetCrop());     // Crop Name (from form)

        return "impact-result"; // Thymeleaf page for displaying results
    }
}
