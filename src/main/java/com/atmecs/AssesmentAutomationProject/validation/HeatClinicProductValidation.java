package com.atmecs.AssesmentAutomationProject.validation;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.atmecs.AssesmentAutomationProject.utils.ConstantPaths;
import com.atmecs.AssesmentAutomationProject.utils.LogReports;
import com.atmecs.AssesmentAutomationProject.utils.PageAction;
import com.atmecs.AssesmentAutomationProject.utils.Readproperties;

public class HeatClinicProductValidation {

	LogReports log = new LogReports();
	PageAction page;
	Readproperties read;

	@SuppressWarnings("static-access")
	public void homepagevalidate(WebDriver driver, String[] values) throws IOException {
		page = new PageAction(driver);
		read = new Readproperties();

		String actualhomepagecontent;
		String expectedhomepagecontent = values[0];
		log.info("validating homepage");
		actualhomepagecontent = page
				.getText(read.readPropertiesFile("homepage.validate.txt", ConstantPaths.heatclinic));
		Assert.assertEquals(actualhomepagecontent, expectedhomepagecontent);
		log.info("homepage validated successful");
	}

	@SuppressWarnings("static-access")
	public void hotsaucesvalidation(WebDriver driver, String[] values) throws IOException {
		page = new PageAction(driver);
		read = new Readproperties();
		String actualhotsaucescontent;
		String expectedhotsaucescontent = values[1];
		log.info("validating hotsaucespage");
		actualhotsaucescontent = page
				.getText(read.readPropertiesFile("hotsaucepage.product.txt", ConstantPaths.heatclinic));
		Assert.assertEquals(actualhotsaucescontent, expectedhotsaucescontent);
		log.info("hotsaucepage validated successful");
	}

	@SuppressWarnings("static-access")
	public void merchantiseandclearancevalidation(WebDriver driver, String[] values) throws IOException {
		page = new PageAction(driver);
		read = new Readproperties();

		String actualmerchantiseandclearancepage;
		String expectedmerchantiseandclearancepage = values[2];
		log.info("validatinh merchantisepage");
		actualmerchantiseandclearancepage = page
				.getText(read.readPropertiesFile("merchantisepage.heading.txt", ConstantPaths.heatclinic));
		Assert.assertEquals(actualmerchantiseandclearancepage, expectedmerchantiseandclearancepage);
		log.info("merchantiseandclearancepage validated");

	}

	@SuppressWarnings("static-access")
	public void newtohotsausevalidation(WebDriver driver, String[] values) throws IOException {
		page = new PageAction(driver);
		read = new Readproperties();
		String actualnewtohotsausepage;
		String expectednewtohotsausepage = values[3];
		
		log.info("validating newtohotsausepage");
		actualnewtohotsausepage=page.getText(read.readPropertiesFile("newtohotsause.content.txt",ConstantPaths.heatclinic ));
		Assert.assertEquals(actualnewtohotsausepage, expectednewtohotsausepage);
		log.info("newtohotsausepage validated successful");

	}
	@SuppressWarnings("static-access")
	public void merchantisemenspagevalidation(WebDriver driver, String[] values) throws IOException {
		page = new PageAction(driver);
		read = new Readproperties();
		String actualmerchantisemenspage;
		String expectedmerchantisemenspage=values[4];
		log.info("validating merchantisemenspage");
		actualmerchantisemenspage=page.getText(read.readPropertiesFile("merchantisepage.mens.txt",ConstantPaths.heatclinic ));
		Assert.assertEquals(actualmerchantisemenspage, expectedmerchantisemenspage);
		log.info("merchantisemenspage validated successful");
}
	@SuppressWarnings("static-access")
	public void itemnamevalidation(WebDriver driver, String[] values) throws IOException {
		page = new PageAction(driver);
		read = new Readproperties();
		
		String actualitemname;
		String expecteditemname=values[6];
		log.info("validating itemname");
		actualitemname=page.getText(read.readPropertiesFile("cartpage.itemname.txt",ConstantPaths.heatclinic ));
		Assert.assertEquals(actualitemname, expecteditemname);
		log.info("itemname validated successfully");
	}
	@SuppressWarnings("static-access")
	public void shirtsizenamecolourvalidation(WebDriver driver, String[] values) throws IOException {
		page = new PageAction(driver);
		read = new Readproperties();
		
		String actualshirtdetails;
		String expectedshirtdetails=values[7];
		log.info("validating shirtsize,name,colour");
		expectedshirtdetails=page.getText(read.readPropertiesFile("cartpage.shirtdetails.txt",ConstantPaths.heatclinic ));
		Assert.assertEquals(expectedshirtdetails, expectedshirtdetails);
		log.info("shirtsize,name,colour validated successful");
		
}
	@SuppressWarnings("static-access")
	public void pricevalidation(WebDriver driver, String[] values) throws IOException {
		page = new PageAction(driver);
		read = new Readproperties();
		
		String actualprice;
		String expectedprice=values[8];
		
		actualprice=page.getText(read.readPropertiesFile("cartpage.price.txt", ConstantPaths.heatclinic ));
		Assert.assertTrue(actualprice.contains(expectedprice));
		log.info("price validated successful");
 	}
}