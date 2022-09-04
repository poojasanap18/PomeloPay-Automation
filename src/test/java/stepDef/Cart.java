package stepDef;
import org.junit.Assert;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObject.CartPageObject;


public class Cart{
	
	private WebDriver driver;

	public Cart() {
		driver = Hook.getDriver();
	}
    
    @Given("^user is  on homepage$")
    public void user_is_on_homepage() throws Throwable {
    	Assert.assertEquals("RA Watch Market", driver.getTitle());  	
    }
    
	@When("^user added the product into cart$")
    public void user_added_the_product_into_cart(DataTable arg1) throws Throwable {
		Thread.sleep(1000);
		driver.findElement(CartPageObject.productName).click();
		driver.findElement(CartPageObject.addToCartBtn).click();
		driver.findElement(CartPageObject.cart).click();
    }

    @Then("^cart updated with correct price$")
    public void cart_updated_with_correct_price() throws Throwable {
        String itemPrice = driver.findElement(CartPageObject.itemPrice).getText();
    	Assert.assertEquals("€8,500.00", itemPrice);  
    	driver.findElement(CartPageObject.crossSign);
    }

    @When("^click on the add cart$")
    public void click_on_the_add_cart() throws Throwable {
    	try {
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", CartPageObject.cart);

    	}catch(IllegalArgumentException e) {
    		
    	}

    }

    @When("^Change the item in the cart$")
    public void change_the_item_in_the_cart() throws Throwable {
    	Thread.sleep(1000);
    	driver.findElement(CartPageObject.changeBtn).click();
        driver.findElement(CartPageObject.plusSign).click();
        Thread.sleep(1000);
    	String itemCount=driver.findElement(CartPageObject.itemIncreased).getText();
    	Assert.assertEquals("2", itemCount); 
    	driver.findElement(CartPageObject.addToCartBtnPopup).click();
    }

    @Then("^Verify the price after adding new product$")
    public void verify_the_price_after_adding_new_product() throws Throwable {
    	try {
    		driver.findElement(CartPageObject.cart).click();
    	  } catch (Exception e) {
    	     JavascriptExecutor executor = (JavascriptExecutor) driver;
    	     executor.executeScript("arguments[0].click();", driver.findElement(CartPageObject.cart));
    	  }		
    	  
        String itemPrice2 = driver.findElement(CartPageObject.itemPrice2).getText();
    	Assert.assertEquals("€17,000.00", itemPrice2); 
        
        String taxes = driver.findElement(CartPageObject.taxes).getText();
    	Assert.assertEquals("€0.00", taxes); 
    	
    	String servicecharge = driver.findElement(CartPageObject.servicecharge).getText();
    	Assert.assertEquals("€1,700.00", servicecharge); 
    	
    	String shipping = driver.findElement(CartPageObject.shipping).getText();
    	Assert.assertEquals("€15.00", shipping); 
    	
    	String Total = driver.findElement(CartPageObject.Total).getText();
    	Assert.assertEquals("€18,715.00", Total); 
    }

    @When("^delete the item in the cart$")
    public void delete_the_item_in_the_cart() throws Throwable {
    	Thread.sleep(1000);
    	driver.findElement(CartPageObject.deleteIcon).click();    	
    }

    @Then("^Verify the price after deleting new product$")
    public void verify_the_price_after_deleting_new_product() throws Throwable {
    	Thread.sleep(1000);
    	String emptyBasketMessage = driver.findElement(CartPageObject.emptyBasketMessage).getText();
    	Assert.assertEquals("Your basket is empty", emptyBasketMessage); 
    	
    	driver.findElement(CartPageObject.crossSign).click();
    }
}

   