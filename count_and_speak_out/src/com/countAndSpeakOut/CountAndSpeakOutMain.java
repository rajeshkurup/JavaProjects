package com.countAndSpeakOut;

public class CountAndSpeakOutMain {
	
	private static int NUMBER_OF_ROWS = 15;
	
	public static void main(String[] args) {
		new CountAndSpeakOutMain().countAndSpeakOut();
	}
	
	private void countAndSpeakOut() {
		System.out.println("1");
		String currentLine = "11";
		
		for(int lineCount = 0; lineCount < NUMBER_OF_ROWS; ++lineCount) {
			System.out.println(currentLine);
			String newLine = "";
			int count = 0;
			int idxLastChar = currentLine.length() - 1;
			
			for(int idx = 0; idx < idxLastChar; ++idx) {
				if(currentLine.charAt(idx) == currentLine.charAt(idx + 1)) {
					++count;
					
				} else {
					newLine += currentLine.charAt(idx);
					newLine += String.valueOf(++count);
					count = 0;
				}
			}

			newLine += currentLine.charAt(idxLastChar);
			newLine += String.valueOf(++count);
			count = 0;
			currentLine = newLine;
		}
	}
	
}
