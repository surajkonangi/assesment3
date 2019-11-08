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
import com.atmecs.AssesmentAutomationProject.validation.HeatClinicProductValidation;

public class HeatClinic extends TestBase {
	PageAction page;
	Readproperties read;
	WaitMethods wait;
	String url;
	@SuppressWarnings("static-access")
	@BeforeClass
	public void before() throws IOException {
	url=read.readPropertiesFile("Url2",ConstantPaths.CONFIG_FILE);
	driver.get(url);
	}  
	@SuppressWarnings("static-access")
	@Test(dataProvider = "heatclinic", dataProviderClass = DataProvides.class)
	public void methordname(String[] values) throws IOException, InterruptedException {
		Readproperties read = new Readproperties();
		page = new PageAction(driver);
		read = new Readproperties();
		wait = new WaitMethods();
		
		new HeatClinicProductValidation().homepagevalidate(driver, values);
		page.click(read.readPropertiesFile("homepage.hotsause.btn", ConstantPaths.heatclinic));
		new HeatClinicProductValidation().hotsaucesvalidation(driver, values);
		page.click(read.readPropertiesFile("homepage.merchandise.btn",ConstantPaths.heatclinic ));
		new HeatClinicProductValidation().merchantiseandclearancevalidation(driver, values);
		page.click(read.readPropertiesFile("homepage.clearance.btn", ConstantPaths.heatclinic));
		new HeatClinicProductValidation().merchantiseandclearancevalidation(driver, values);
		page.click(read.readPropertiesFile("homepage.newtohotsause.btn", ConstantPaths.heatclinic));
		new HeatClinicProductValidation().newtohotsausevalidation(driver, values);
		page.mouseOn(read.readPropertiesFile("homepage.merchandise.btn", ConstantPaths.heatclinic));
		page.click(read.readPropertiesFile("merchandisepage.mens.btn",ConstantPaths.heatclinic));
		new HeatClinicProductValidation().merchantisemenspagevalidation(driver, values);
		page.click(read.readPropertiesFile("merchandisepage.shirtselect.btn",ConstantPaths.heatclinic ));
		page.click(read.readPropertiesFile("merchandisepage.shirtcolour.box",ConstantPaths.heatclinic ));
		page.click(read.readPropertiesFile("merchandisepage.shirtsize.box", ConstantPaths.heatclinic));
		page.sendKeys(read.readPropertiesFile("merchantisepage.personilisedname.box", ConstantPaths.heatclinic), values[5]);
		page.click(read.readPropertiesFile("merchantisepage.buynow.btn", ConstantPaths.heatclinic));
		page.click(read.readPropertiesFile("merchantisepage.viewcart.btn",ConstantPaths.heatclinic ));
		new HeatClinicProductValidation().itemnamevalidation(driver, values);
		new HeatClinicProductValidation().shirtsizenamecolourvalidation(driver, values);
		//new HeatClinicProductValidation().pricevalidation(driver, values);
		page.clear(read.readPropertiesFile("cartpage.quantity.box",ConstantPaths.heatclinic ));
		page.sendKeys(read.readPropertiesFile("cartpage.quantity.box", ConstantPaths.heatclinic), values[9]);
		page.click(read.readPropertiesFile("cartpage.update.btn", ConstantPaths.heatclinic));
		

		
	}

}
