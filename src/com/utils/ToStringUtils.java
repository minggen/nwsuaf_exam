package com.utils;

public class ToStringUtils {
	public static String getString(String[] strArray) {
		String getStr = "";
		for(int i = 0 ;i< strArray.length ;i++) {
			getStr+=strArray[i];
		}
		return getStr;
	}
}
