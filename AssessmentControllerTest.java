//package com.agrihub.impact_assessment.controller;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.agrihub.impact_assessment.model.AssessmentResult;
//import com.agrihub.impact_assessment.model.TechnologyInput;
//import com.agrihub.impact_assessment.service.AssessmentService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@WebMvcTest(AssessmentController.class)
//class AssessmentControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private AssessmentService assessmentService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    @DisplayName("POST /api/assess - Should return AssessmentResult with ghgChange")
//    void shouldReturnAssessmentResultWhenValidInputIsPosted() throws Exception {
//        // Arrange
//        TechnologyInput input = new TechnologyInput();
//        input.setEquipmentName("Solar Pump");
//        input.setOldEnergyConsumption(1000.0);
//        input.setNewEnergyConsumption(400.0);
//
//        AssessmentResult mockResult = new AssessmentResult();
//        mockResult.setGhgChange(420.0);
//        mockResult.setEnergySavings(600.0);
//        mockResult.setPaybackPeriod(2.5);
//        mockResult.setNotes("Assessment successful");
//
//        when(assessmentService.assess(any(TechnologyInput.class))).thenReturn(mockResult);
//
//        // Act & Assert
//        mockMvc.perform(post("/api/assess")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(input)))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.ghgChange").value(420.0))
//                .andExpect(jsonPath("$.energySavings").value(600.0))
//                .andExpect(jsonPath("$.paybackPeriod").value(2.5))
//                .andExpect(jsonPath("$.notes").value("Assessment successful"));
//    }
//
//    @Test
//    @DisplayName("POST /api/assess - Should return error note for missing input")
//    void shouldReturnErrorNoteWhenInputIsMissing() throws Exception {
//        TechnologyInput input = new TechnologyInput(); // no equipmentName
//
//        AssessmentResult mockResult = new AssessmentResult();
//        mockResult.setNotes("Invalid input: Equipment name is required.");
//
//        when(assessmentService.assess(any(TechnologyInput.class))).thenReturn(mockResult);
//
//        mockMvc.perform(post("/api/assess")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(input)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.notes").value("Invalid input: Equipment name is required."));
//    }
//}
