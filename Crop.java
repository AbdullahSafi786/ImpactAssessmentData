package com.agrihub.impact_assessment.model;

public class Crop {
    private String name;
    private Double eod;
    private Double eos;
    // getters, setters, constructor
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Crop [name=" + name + ", eod=" + eod + ", eos=" + eos + ", getName()=" + getName() + ", getEod()="
				+ getEod() + ", getEos()=" + getEos() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	public Crop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Double getEod() {
		return eod;
	}
	public void setEod(Double eod) {
		this.eod = eod;
	}
	public Double getEos() {
		return eos;
	}
	public void setEos(Double eos) {
		this.eos = eos;
	}
	public Crop(String name, Double eod, Double eos) {
		super();
		this.name = name;
		this.eod = eod;
		this.eos = eos;
	}
    
}