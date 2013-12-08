package com.maxm.util;

import org.apache.log4j.Logger;

import com.maxm.domain.Card;

public class CardFactory {
	private static final Logger log = Logger.getLogger(CardFactory.class);

	public static Card create() {
		return new Card();
	}

	public static Card createByName(String name) {
		return new Card(name);
	}

	public static Card createByIdAndName(long id, String name) {
		log.info("createByIdAndName[" + id + "," + name + "]");
		return new Card(id, name);
	}
}
