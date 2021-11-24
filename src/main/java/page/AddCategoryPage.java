package page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCategoryPage extends BasePage {
	WebDriver driver;
	int count=0;
	String category="Food";
	boolean deleted=false;
	
	public AddCategoryPage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy (how=How.NAME, using="categorydata") WebElement CATEGORY_ADD_ELEMENT;
	@FindBy (how=How.CSS, using="input[value='Add category']") WebElement ADD_CATEGORY_BUTTON_ELEMENT;
	@FindBy (how=How.CSS, using="select[name='colour']") WebElement SELECT_COLOR_ELEMENT;
	@FindBy (how=How.CSS, using="select[name='due_month']") WebElement SELECT_MONTH_ELEMENT;
	
	public void clickOnAddCategory() {
		ADD_CATEGORY_BUTTON_ELEMENT.click();
	}
	
	public void enterAddCategory(String category) {
		CATEGORY_ADD_ELEMENT.sendKeys(category);
	} 
	
    public void selectColorFromDropDown() {
    	selectFromDropDown(SELECT_COLOR_ELEMENT,"Gray");
    }
    
    
  
   
   
   public boolean compareDropDownMonth() {
	   String[] month= {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	   Select sel= new Select(SELECT_MONTH_ELEMENT);
	  List<String> lstMonth= Arrays.asList(month);
	  //List<WebElement> MonthList=sel.getOptions();
	  List<String> MonthList = new ArrayList<String>();
	  for(int i=0;i<sel.getOptions().size();i++) {
		  
		  String monthOption= sel.getOptions().get(i).getText();
		  if(!monthOption.equalsIgnoreCase("None"))
			  MonthList.add(monthOption);
	  }
	   return MonthList.equals(lstMonth);
	   
   }
   
 
  
   
}
