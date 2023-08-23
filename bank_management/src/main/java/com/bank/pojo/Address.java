package com.bank.pojo;

public class Address {
	private int addressId;
	private int flatNumber;
	private String landMark;
	private String city;
	private String distric;
	private String state;
	private int pinNumber;
	private String country;
	

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(int flatNumber) {
		this.flatNumber = flatNumber;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistric() {
		return distric;
	}

	public void setDistric(String distric) {
		this.distric = distric;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPinNumber() {
		return pinNumber;
	}

	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", flatNumber=" + flatNumber + ", landMark=" + landMark + ", city="
				+ city + ", distric=" + distric + ", state=" + state + ", pinNumber=" + pinNumber + ", country="
				+ country + "]";
	}

}
