package com.org.stepdefination;

import java.util.List;
import java.util.Map;

import io.cucumber.java.en.When;

public class DataTable {
	@When("read the data from the below table")
	public void read_the_data_from_the_below_table(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps();
		System.out.println(data);
		Map<String, String> firstRow = data.get(0);
		System.out.println(firstRow);
		Map<String, String> secondRow = data.get(1);
		System.out.println(secondRow);
		Map<String, String> thirdRow = data.get(2);
		System.out.println(thirdRow);
		String empdata = data.get(0).get("empName");
		System.out.println(empdata);
		String empid = data.get(1).get("empid");
		System.out.println(empid);
	}
}
