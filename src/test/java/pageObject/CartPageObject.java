package pageObject;

import org.openqa.selenium.By;

public class CartPageObject{

	public static final By productName = By.xpath("//pp-text[text()='SLGH005']");
    public static final By cart = By.xpath("//x-cart-indicator");
    public static final By orderSummaryTitle = By.xpath("//pp-text[text()='Order summary']");
    public static final By addToCartBtn = By.xpath("//pp-button[text()='Add €8,500.00 to order']");

    public static final By itemPrice = By.xpath("//pp-text[text()='€8,500.00']");
    public static final By crossSign = By.xpath("(//i[@class='fas fa-times text-2xl'])[1]");
  
    public static final By changeBtn = By.xpath("//pp-button[text()='Change']");
    public static final By plusSign = By.xpath("(//i[@class='fas fa-plus-circle cursor-pointer text-3xl text-primary'])[2]");
  
    public static final By itemIncreased = By.xpath("//pp-text[text()='2']");

    public static final By addToCartBtnPopup = By.xpath("(//pp-button[text()='Add €8,500.00 to order'])[2]");
    public static final By itemPrice2 = By.xpath("//pp-text[text()='€17,000.00']");
    public static final By taxes = By.xpath("//pp-text[text()='€0.00']");
    public static final By servicecharge = By.xpath("//pp-text[text()='€1,700.00']");
    public static final By shipping = By.xpath("//pp-text[text()='€15.00']");
    public static final By Total = By.xpath("//pp-text[text()='€18,715.00']");
    
    public static final By deleteIcon = By.xpath("//pp-button[@class='ml-2 hydrated']/i");
    public static final By emptyBasketMessage = By.xpath("//pp-text[text()='Your basket is empty']");


}
