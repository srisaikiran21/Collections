package com.cg.beans;

public class Address {
	private int addressId;
	private String Addressline1;
	private String City;
	private String state;
	
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getAddressline1() {
		return Addressline1;
	}
	public void setAddressline1(String addressline1) {
		Addressline1 = addressline1;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", Addressline1=" + Addressline1 + ", City=" + City + ", state="
				+ state + "]";
	}
	
}
