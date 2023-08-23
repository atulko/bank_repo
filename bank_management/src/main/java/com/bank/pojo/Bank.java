package com.bank.pojo;

public class Bank {
	private int bankId;
	private String bankName;
	private String ifscNumber;
	private int totalNumberofCustomer;
	private double bankBalance;
	private int addId;

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIfscNumber() {
		return ifscNumber;
	}

	public void setIfscNumber(String ifscNumber) {
		this.ifscNumber = ifscNumber;
	}

	public int getTotalNumberofCustomer() {
		return totalNumberofCustomer;
	}

	public void setTotalNumberofCustomer(int totalNumberofCustomer) {
		this.totalNumberofCustomer = totalNumberofCustomer;
	}

	public double getBankBalance() {
		return bankBalance;
	}

	public void setBankBalance(double bankBalance) {
		this.bankBalance = bankBalance;
	}

	public int getAddId() {
		return addId;
	}

	public void setAddId(int addId) {
		this.addId = addId;
	}

	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", bankName=" + bankName + ", ifscNumber=" + ifscNumber
				+ ", totalNumberofCustomer=" + totalNumberofCustomer + ", bankBalance=" + bankBalance + ", addId="
				+ addId + "]";
	}

}
