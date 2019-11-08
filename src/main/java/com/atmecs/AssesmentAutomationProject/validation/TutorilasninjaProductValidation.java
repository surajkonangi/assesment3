package com.atmecs.AssesmentAutomationProject.validation;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.atmecs.AssesmentAutomationProject.utils.ConstantPaths;
import com.atmecs.AssesmentAutomationProject.utils.LogReports;
import com.atmecs.AssesmentAutomationProject.utils.PageAction;
import com.atmecs.AssesmentAutomationProject.utils.Readproperties;

public class TutorilasninjaProductValidation {

	LogReports log = new LogReports();
	PageAction page;
	Readproperties read;

	@SuppressWarnings("static-access")
	public void homepagevalidate(WebDriver driver, String[] values) throws IOException {
		page = new PageAction(driver);
		read = new Readproperties();

		String actualhomepagetitle;
		String expectedhomepagetitle = values[0];
		
		log.info("validating homepage");
		actualhomepagetitle = page.getText(read.readPropertiesFile("homepage.title.txt", ConstantPaths.tutorialsninja));
		Assert.assertEquals(actualhomepagetitle, expectedhomepagetitle);
		log.info("homepage validated successful");
	}
	@SuppressWarnings("static-access")
	public void priceandextaxvalidation(WebDriver driver, String[] values) throws IOException {
		
		String actualproductprice;
		String expectedproductprice=values[3];
		log.info("validating product price and ex tax");
		actualproductprice=page.getText(read.readPropertiesFile("productpage.price.txt",ConstantPaths.tutorialsninja ));
		System.out.println(actualproductprice);
		Assert.assertEquals(actualproductprice, expectedproductprice);
		log.info("product price and ex tax vailidated successful");
	}
	@SuppressWarnings("static-access")
	public void productdecriptionvalidation(WebDriver driver, String[] values) throws IOException {
		
		String actualproductdescript;
		String expectedproductdescript=values[4];
		log.info("validating product desctiption");
		actualproductdescript=page.getText(read.readPropertiesFile("productpage.description.txt", ConstantPaths.tutorialsninja));
		Assert.assertTrue(actualproductdescript.contains(expectedproductdescript));
		log.info("productdescription validated successful");
		
	}
	@SuppressWarnings("static-access")
	public void cartvalidation(WebDriver driver, String[] values) throws IOException {
		
		String actualcartdetails;
		String expectedcartdetails=values[5];
		log.info("validating cartdetails");
		actualcartdetails=page.getText(read.readPropertiesFile("productpage.viewkart.btn",ConstantPaths.tutorialsninja ));
		Assert.assertEquals(actualcartdetails, expectedcartdetails);
		log.info("cartdetails validated successful");
	}
}
