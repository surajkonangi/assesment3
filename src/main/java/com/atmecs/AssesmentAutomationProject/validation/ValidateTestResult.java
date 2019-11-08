package com.atmecs.AssesmentAutomationProject.validation;

import org.testng.Assert;

import com.atmecs.AssesmentAutomationProject.utils.LogReports;
import com.atmecs.AssesmentAutomationProject.utils.Readproperties;
import com.atmecs.AssesmentAutomationProject.utils.TestBase;

public class ValidateTestResult extends TestBase {
	static LogReports log = new LogReports();
	Readproperties read = new Readproperties();

	public static  boolean validateData(String actual,String expected, String message) {
		try {
			/*
			 * 
			 * print actual and expected value
			 * 
			*/
			Assert.assertEquals(actual, expected);
			
			return true;
		} catch (AssertionError assertionError) {
			
			return false;
		}
	}
}
