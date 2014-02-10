package com.maxm.service;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.maxm.dao.CardDao;
import com.maxm.domain.Card;
import com.maxm.util.CardFactory;

public class CardService {

	public static Map<String, Object> createCard(JSONObject json) {
		long id = json.getLong("id");
		String name = json.getString("name");
		return createCard(id, name);
	}

	public static Map<String, Object> createCard(long id, String name) {
		Map<String, Object> ret = new HashMap<>();
		ret.put("code", 200);

		Card card = CardFactory.createByIdAndName(id, name);
		new CardDao().save(card);

		ret.put(card.getId() + "", card);
		return ret;
	}

}
