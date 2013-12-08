package com.maxm.domain;

import java.util.Random;

public class Card {
	private long id;
	private String name;

	public Card() {
		this.id = new Random().nextLong();
	}

	public Card(String name) {
		this.name = name;
	}

	public Card(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", name=" + name + "]";
	}
}
