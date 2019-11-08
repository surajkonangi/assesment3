package com.atmecs.AssesmentAutomationProject.testscripts;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.atmecs.AssesmentAutomationProject.testdata.DataProvides;
import com.atmecs.AssesmentAutomationProject.utils.ConstantPaths;
import com.atmecs.AssesmentAutomationProject.utils.PageAction;
import com.atmecs.AssesmentAutomationProject.utils.Readproperties;
import com.atmecs.AssesmentAutomationProject.utils.TestBase;
import com.atmecs.AssesmentAutomationProject.utils.WaitMethods;
import com.atmecs.AssesmentAutomationProject.validation.TutorilasninjaProductValidation;

public class TutorialsninjaProductAvailability extends TestBase {
	PageAction page;
	Readproperties read;
	WaitMethods wait;
	String url;

	@SuppressWarnings("static-access")
	@BeforeClass
	public void before() throws IOException {
		url = read.readPropertiesFile("Url1", ConstantPaths.CONFIG_FILE);
		driver.get(url);
	}

	@SuppressWarnings("static-access")
	@Test(dataProvider = "tutorialsninja", dataProviderClass = DataProvides.class)
	public void productavailability(String[] values) throws IOException, InterruptedException {
		page = new PageAction(driver);
		read = new Readproperties();

		new TutorilasninjaProductValidation().homepagevalidate(driver, values);
		page.sendKeys(read.readPropertiesFile("homepage.search.box", ConstantPaths.tutorialsninja), values[1]);
		page.click(read.readPropertiesFile("homepage.search.btn", ConstantPaths.tutorialsninja));
		page.click(read.readPropertiesFile("productpage.product.img", ConstantPaths.tutorialsninja));
		new TutorilasninjaProductValidation().priceandextaxvalidation(driver, values);
		new TutorilasninjaProductValidation().productdecriptionvalidation(driver, values);
		page.clear(read.readPropertiesFile("productpage.quantity.box", ConstantPaths.tutorialsninja));
		page.sendKeys(read.readPropertiesFile("productpage.quantity.box", ConstantPaths.tutorialsninja), values[2]);
		page.click(read.readPropertiesFile("productpage.addtocart.btn", ConstantPaths.tutorialsninja));
		page.click(read.readPropertiesFile("homepage.title.txt", ConstantPaths.tutorialsninja));
		page.click(read.readPropertiesFile("productpage.viewkart.btn", ConstantPaths.tutorialsninja));
		new TutorilasninjaProductValidation().cartvalidation(driver, values);
		page.click(read.readPropertiesFile("productpage.viewcartpage.btn", ConstantPaths.tutorialsninja));
		page.clear(read.readPropertiesFile("cartpage.productquantity.box", ConstantPaths.tutorialsninja));
		page.sendKeys(read.readPropertiesFile("cartpage.productquantity.box",ConstantPaths.tutorialsninja ), values[6]);
		page.click(read.readPropertiesFile("cartpage.update.btn",ConstantPaths.tutorialsninja ));
		
	}
}
