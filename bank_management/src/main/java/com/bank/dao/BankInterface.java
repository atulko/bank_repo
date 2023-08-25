package com.bank.dao;

import java.util.List;

import com.bank.pojo.Bank;

public interface BankInterface {

	public List<Bank> getBankList();

	public Bank saveBank(Bank bank);

	public List<Bank> saveBankList(List<Bank> bankList);

	public boolean isBankExists(Bank bank);

	public Bank updateBank(Bank bank, int id, String bank_name);

	public void deleteBank(int id);

	public boolean isBankEnable(int id, int isEnable);

	public boolean disableBank(int disable, int id);

	public int getBankId(String bank);
}
