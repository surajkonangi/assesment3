package com.atmecs.AssesmentAutomationProject.testdata;

import org.testng.annotations.DataProvider;

import com.atmecs.AssesmentAutomationProject.utils.ConstantPaths;

public class DataProvides {

	@DataProvider(name = "tutorialsninja")
	public Object[][] gethomepagedata(){
		TestDataProvider provideData=new TestDataProvider(ConstantPaths.TESTDATA_FILE,0);
		Object[][] getData=provideData.provideData();
		return getData;
	}
	
	@DataProvider(name = "heatclinic")
	public Object[][] getheroingdata(){
		TestDataProvider provideData=new TestDataProvider(ConstantPaths.TESTDATA_FILE,1);
		Object[][] getData=provideData.provideData();
		return getData;
}
}
