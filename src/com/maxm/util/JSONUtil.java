package com.maxm.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JSONUtil {
	public static JSONObject toJSON(Object obj) {
		if (obj == null) {
			return new JSONObject();
		}
		return (JSONObject) JSON.toJSON(obj);
	}
}
