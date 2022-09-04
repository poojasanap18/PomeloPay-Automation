package utility;

import org.openqa.selenium.WebDriver;

	
    public class utils {
	static WebDriver driver;

	   
	   public static void switchPopup() {
			String parentWindowHandle = driver.getWindowHandle(); 

			for (String winHandle : driver.getWindowHandles()) {

			         if(!winHandle.equals(parentWindowHandle))
			         {
			           WebDriver window = driver.switchTo().window(winHandle); 
			        	
			        	
			         }

			   }   
			return;
			}


}
