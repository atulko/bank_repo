package com.bank.pojo;

public class Nominee {
	private int id;
	private int nominee1;
	private int nominee2;
	private int nominee3;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNominee1() {
		return nominee1;
	}

	public void setNominee1(int nominee1) {
		this.nominee1 = nominee1;
	}

	public int getNominee2() {
		return nominee2;
	}

	public void setNominee2(int nominee2) {
		this.nominee2 = nominee2;
	}

	public int getNominee3() {
		return nominee3;
	}

	public void setNominee3(int nominee3) {
		this.nominee3 = nominee3;
	}

	@Override
	public String toString() {
		return "Nominee [id=" + id + ", nominee1=" + nominee1 + ", nominee2=" + nominee2 + ", nominee3=" + nominee3
				+ "]";
	}

}
