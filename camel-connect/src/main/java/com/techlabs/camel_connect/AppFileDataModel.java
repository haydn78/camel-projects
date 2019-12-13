package com.techlabs.camel_connect;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord( separator = "," , skipFirstLine = true )
public class AppFileDataModel {

	@DataField(pos = 2, trim = true)
	private String lastName;
	
	@DataField(pos = 1, trim = true)
	private String givenName;
	
	@DataField(pos = 3, trim = true, defaultValue = "Mr")
	private String title;
	
	public String getGivenName() {
		return givenName;
	}
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAge() {
		return title;
	}
	public void setAge(String title) {
		this.title = title;
	}
	
	
	
}
