package com.ru.commons;

public class StringHelper {
	/**
	 * time format
	 * @param ampm
	 * @return
	 */
	public static String converTimeFormat(String ampm) {
		if (ampm.contains("am")) {
			ampm = ampm.substring(0, ampm.length() - 2);
		} else if (ampm.contains("pm")) {
			ampm = ampm.substring(0, ampm.length() - 2);
			int hour = Integer.parseInt(ampm.split(":")[0]);
			if (hour < 12) {
				ampm = (hour + 12) + ":" + ampm.split(":")[1];
			}
		}
		return ampm;
	}
}
