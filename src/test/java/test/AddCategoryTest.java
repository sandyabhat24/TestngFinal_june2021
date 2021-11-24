package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCategoryPage;
import page.BrowserFactory;

public class AddCategoryTest extends BrowserFactory {
	
	WebDriver driver;
	
	@Parameters({ "category" })
	@Test
    public void validUserShouldBeAbleToAddCategory(String testCategory) throws InterruptedException {
    	
        driver=BrowserFactory.init();
		
		AddCategoryPage addCategory=PageFactory.initElements(driver, AddCategoryPage.class);
		
		addCategory.enterAddCategory(testCategory);
		Thread.sleep(3000);
		addCategory.selectColorFromDropDown();
		addCategory.clickOnAddCategory();
		
		
		Assert.assertEquals( driver.getPageSource().contains(testCategory), true,"Category coudn't not be added successfully");
				
    }
 
	
	@Parameters({ "category" })
	@Test
	public void validatingOnlyUniqueOrdersCanBeAdded(String testCategory) throws InterruptedException {
		 driver=BrowserFactory.init();
			
		 AddCategoryPage addCategory=PageFactory.initElements(driver, AddCategoryPage.class);
		 
		 addCategory.enterAddCategory(testCategory);
		 Thread.sleep(3000);
		 addCategory.selectColorFromDropDown();
		 addCategory.clickOnAddCategory();
		 
		 Assert.assertEquals(driver.getPageSource().contains("The category you want to add already exist"), true, "Duplicate category not allowed");
	}
	
	
	

	@Test
	public void validateAllMonthsPresentInTheDropDown() throws InterruptedException {
		
		 driver=BrowserFactory.init();
			
		 AddCategoryPage addCategory=PageFactory.initElements(driver, AddCategoryPage.class);
		 
		 System.out.println(addCategory.compareDropDownMonth());
		 
		Assert.assertEquals( addCategory.compareDropDownMonth(), true,"months are not matching");
	}
}
