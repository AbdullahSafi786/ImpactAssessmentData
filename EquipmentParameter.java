package com.agrihub.impact_assessment.model;
import lombok.Data;

@Data
public class EquipmentParameter {
	 private double emissionFactor;
	    private double unitCost;
    @Override
		public String toString() {
			return "EquipmentParameter [emissionFactor=" + emissionFactor + ", unitCost=" + unitCost + ", name=" + name
					+ ", metric=" + metric + ", value=" + value + ", yieldEnhancing=" + yieldEnhancing
					+ ", getEmissionFactor()=" + getEmissionFactor() + ", getUnitCost()=" + getUnitCost()
					+ ", getName()=" + getName() + ", getMetric()=" + getMetric() + ", getValue()=" + getValue()
					+ ", getYieldEnhancing()=" + getYieldEnhancing() + ", getClass()=" + getClass() + ", hashCode()="
					+ hashCode() + ", toString()=" + super.toString() + "]";
		}
	public EquipmentParameter(double emissionFactor, double unitCost, String name, String metric, Double value,
				Boolean yieldEnhancing) {
			super();
			this.emissionFactor = emissionFactor;
			this.unitCost = unitCost;
			this.name = name;
			this.metric = metric;
			this.value = value;
			this.yieldEnhancing = yieldEnhancing;
		}
	public double getEmissionFactor() {
			return emissionFactor;
		}
		public void setEmissionFactor(double emissionFactor) {
			this.emissionFactor = emissionFactor;
		}
		public double getUnitCost() {
			return unitCost;
		}
		public void setUnitCost(double unitCost) {
			this.unitCost = unitCost;
		}
	private String name;
    private String metric;     // e.g., "Ha/day"
    private Double value;
    private Boolean yieldEnhancing;
    // getters, setters, constructor
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMetric() {
		return metric;
	}
	public void setMetric(String metric) {
		this.metric = metric;
	}
	public EquipmentParameter() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public Boolean getYieldEnhancing() {
		return yieldEnhancing;
	}
	public void setYieldEnhancing(Boolean yieldEnhancing) {
		this.yieldEnhancing = yieldEnhancing;
	}
	public EquipmentParameter(String name, String metric, Double value, Boolean yieldEnhancing) {
		super();
		this.name = name;
		this.metric = metric;
		this.value = value;
		this.yieldEnhancing = yieldEnhancing;
	}
    
}
