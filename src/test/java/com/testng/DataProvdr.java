package com.testng;

import org.testng.annotations.DataProvider;

public class DataProvdr {
	
	@DataProvider
	public String[] flipkart() {
		String data[] = new String[3];
		data[0] = "mobile";
		data[1] = "smartwatch";
		data[2] = "laptop";
		return data;
	}
	
	@DataProvider
	public String[] demo() {
		String data[] = new String[3];
		data[0] = "mobile";
		data[1] = "smartwatch";
		data[2] = "laptop";
		return data;
	}
	
	@DataProvider
	public String[][] login() {
		String[][] data = new String[6][2];
		data[0][0] = "standard_user"; // 0<--row; 0<--column [username]
		data[0][1] = "secret_sauce"; // 0<--row; 1<--column [password]
		
		data[1][0] = "problem_user";
		data[1][1] = "secret_sauce";
		
		data[2][0] = "performance_glitch_user";
		data[2][1] = "secret_sauce";
		
		data[3][0] = "error_user";
		data[3][1] = "secret_sauce";
		
		data[4][0] = "visual_user";
		data[4][1] = "secret_sauce";
		
		data[5][0] = "locked_out_user";
		data[5][1] = "secret_sauce";		
		
		return data;
		
	}
}
