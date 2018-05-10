package sht.practice.chapter5;

import java.io.Serializable;

public class Book implements Serializable {
	private String name;
	private int value;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

	public Book(String name,int value) {
		this.name = name;
		this.value = value;
	}

}
