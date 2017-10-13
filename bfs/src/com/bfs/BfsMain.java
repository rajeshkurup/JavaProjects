package com.bfs;

import java.util.ArrayList;
import java.util.List;

public class BfsMain {
	
	public static void main(String[] args) {
		// Create 4x4 matrix
		String cell = "";
		String text = "A";
		List<List<String>> twoDTextMatrix = new ArrayList<List<String>>();
		for(int idxRow = 0; idxRow < 4; ++idxRow) {
			List<String> columns = new ArrayList<String>();
			
			for(int idxColumn = 0; idxColumn < 4; ++idxColumn) {
				cell = cell + text;
				columns.add(cell);
			}
			
			twoDTextMatrix.add(columns);
		}
		
		// Perform Breadth First Search 
		BfsUtil bfsUtil = new BfsUtil();
		bfsUtil.breadthFirstSearch(twoDTextMatrix, "AAAAAAAAAAAAAA");
		System.out.println(bfsUtil.getPath("AAAAAAAAAAAAAAAA"));
	}

}
