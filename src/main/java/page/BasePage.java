package page;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	
	WebDriver driver;
	
	public static void selectFromDropDown(WebElement element, String itemname) {
		Select sel=new Select(element);
		sel.selectByVisibleText(itemname);
	}
	
	

}
