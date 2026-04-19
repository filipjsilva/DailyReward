package br.com.flp.dailyreward.utils;

public class Timer {
	
	public static String format(double ms) {
		int totalSeconds = (int) (ms / 1000);
		
		int hours = totalSeconds / 3600;
		int minutes = (totalSeconds % 3600) / 60;
		int seconds = totalSeconds % 60;
		
		StringBuilder result = new StringBuilder();
		
		if(hours > 0) {
			result.append(hours).append('h');
			if(minutes > 0) {
				result.append(minutes).append('m');
			}
			if(seconds > 0) {
				result.append(seconds).append('s');
			}
		} else if(minutes > 0) {
			result.append(minutes).append('m');
			if(seconds > 0) {
				result.append(seconds).append('s');
			}
		} else {
			result.append(seconds).append('s');
		}
		return result.toString();
	}
	
}