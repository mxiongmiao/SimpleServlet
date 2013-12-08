package com.maxm.util;

public class StringUtil {
	public static boolean isEmpty(String input) {
		if (input == null || input.length() == 0) {
			return true;
		}
		return false;
	}
}
