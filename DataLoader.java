package com.agrihub.impact_assessment.service;

import java.io.InputStream;
import java.util.*;
import org.apache.poi.ss.usermodel.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.agrihub.impact_assessment.model.Crop;
import com.agrihub.impact_assessment.model.EquipmentParameter;

@Component
public class DataLoader {
    private static final String EXCEL_FILE = "/Impact Assessment with Data.xlsm";

    public List<Crop> readCrops() {
        return readExcel(sheet -> {
            List<Crop> crops = new ArrayList<>();
            Iterator<Row> rows = sheet.iterator();

            skipRows(rows, 2);
            Map<String, Integer> headers = getHeaderMap(rows.next());

            while (rows.hasNext()) {
                Row row = rows.next();
                String name = getCellValue(row, headers, "crop name");
                Double eod = getNumericCellValue(row, headers, "eod (hrs/ha)");
                Double eos = getNumericCellValue(row, headers, "eos (hrs/ha)");

                if (name == null || name.isBlank()) continue;
                if (eod == null && eos == null) continue;

                crops.add(new Crop(name, eod, eos));
            }

            return crops;
        }, "Values");
    }

    public List<EquipmentParameter> readEquipmentParameters() {
        return readExcel(sheet -> {
            List<EquipmentParameter> params = new ArrayList<>();
            Iterator<Row> rows = sheet.iterator();

            skipRows(rows, 2);
            Map<String, Integer> headers = getHeaderMap(rows.next());

            while (rows.hasNext()) {
                Row row = rows.next();
                String name = getCellValue(row, headers, "crop name");
                String capacity = getCellValue(row, headers, "capacity of equipment");
                Double value = getNumericCellValue(row, headers, "eod (hrs/ha)");
                Boolean yieldEnhancing = getBooleanCellValue(row, headers, "is yield enhancing");

                if (name == null || name.isBlank() || value == null) continue;

                params.add(new EquipmentParameter(name, capacity, value, yieldEnhancing));
            }

            return params;
        }, "Values");
    }

    // --- Utility Methods ---

    private <T> T readExcel(SheetProcessor<T> processor, String sheetName) {
        try (InputStream is = new ClassPathResource(EXCEL_FILE).getInputStream();
             Workbook workbook = WorkbookFactory.create(is)) {
            Sheet sheet = workbook.getSheet(sheetName);
            return processor.process(sheet);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load data from Excel sheet: " + sheetName, e);
        }
    }

    private void skipRows(Iterator<Row> rows, int count) {
        for (int i = 0; i < count && rows.hasNext(); i++) {
            rows.next();
        }
    }

    private Map<String, Integer> getHeaderMap(Row headerRow) {
        Map<String, Integer> map = new HashMap<>();
        for (Cell cell : headerRow) {
            String header = cell.getStringCellValue().trim().toLowerCase();
            map.put(header, cell.getColumnIndex());
        }
        return map;
    }

    private String getCellValue(Row row, Map<String, Integer> headerMap, String key) {
        Integer index = headerMap.get(key.toLowerCase());
        if (index == null) return null;
        return getStringValue(row.getCell(index));
    }

    private Double getNumericCellValue(Row row, Map<String, Integer> headerMap, String key) {
        Integer index = headerMap.get(key.toLowerCase());
        if (index == null) return null;
        return getNumericValue(row.getCell(index));
    }

    private Boolean getBooleanCellValue(Row row, Map<String, Integer> headerMap, String key) {
        Integer index = headerMap.get(key.toLowerCase());
        if (index == null) return null;
        return getBooleanValue(row.getCell(index));
    }

    private Double getNumericValue(Cell cell) {
        if (cell == null) return null;
        if (cell.getCellType() == CellType.NUMERIC) return cell.getNumericCellValue();
        if (cell.getCellType() == CellType.STRING) {
            try {
                return Double.parseDouble(cell.getStringCellValue().trim());
            } catch (NumberFormatException ignored) {}
        }
        return null;
    }

    private String getStringValue(Cell cell) {
        if (cell == null) return null;
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue().trim();
            case NUMERIC -> String.valueOf(cell.getNumericCellValue());
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            default -> cell.toString().trim();
        };
    }

    private Boolean getBooleanValue(Cell cell) {
        if (cell == null) return null;
        String value = cell.toString().trim().toLowerCase();
        return value.equals("true") || value.equals("yes") || value.equals("1");
    }

    @FunctionalInterface
    private interface SheetProcessor<T> {
        T process(Sheet sheet) throws Exception;
    }
}
